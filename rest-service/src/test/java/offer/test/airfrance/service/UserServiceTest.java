package offer.test.airfrance.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import offer.test.airfrance.dto.UserDTO;
import offer.test.airfrance.entity.User;
import offer.test.airfrance.exception.InvalidParameterException;
import offer.test.airfrance.exception.NotFoundException;
import offer.test.airfrance.mapper.UserMapper;
import offer.test.airfrance.mapper.UserMapperImpl;
import offer.test.airfrance.repository.UserRepository;
import offer.test.airfrance.service.impl.UserServiceImpl;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

	@InjectMocks
	private UserServiceImpl userService;

	@Mock
	private UserRepository userRepository;

	@Spy
	private UserMapper userMapper = new UserMapperImpl();

	private User userMock;

	@BeforeEach
	private void setup() {
		userMock = new User();
		userMock.setUserName("Anthony");
		userMock.setBirthdate(LocalDate.of(2020, 02, 02));
		userMock.setCountryResidence("FRA");
		userMock.setGender("M");
		userMock.setPhoneNumber("0754425875");
	}

	@Test()
	public void userNotFoundTest() {
		Mockito.when(userRepository.findById(Mockito.eq(5L))).thenReturn(Optional.empty());
		try {
			userService.findUserById(5L);
			Assertions.fail();
		} catch (NotFoundException e) {
			Assertions.assertSame("User not found.", e.getMessage());
		}
	}

	@Test
	public void userFoundTest() {

		Mockito.when(userRepository.findById(Mockito.eq(1L))).thenReturn(Optional.of(userMock));
		try {
			UserDTO result = userService.findUserById(1L);
			Assertions.assertNotNull(result);
			Assertions.assertEquals("Anthony", result.getUserName());
			Assertions.assertEquals(LocalDate.of(2020, 02, 02), result.getBirthdate());
			Assertions.assertEquals("FRA", result.getCountryResidence());
			Assertions.assertEquals("M", result.getGender());
			Assertions.assertEquals("0754425875", result.getPhoneNumber());

		} catch (Exception e) {
			Assertions.fail();
		}
	}

	@Test
	public void createUserAlreadyExistsTest() {
		List<User> listUserMock = new ArrayList<>();
		listUserMock.add(userMock);
		Mockito.when(userRepository.findByUserName(Mockito.eq("UserName"))).thenReturn(listUserMock);
		try {
			UserDTO user = new UserDTO();
			user.setUserName("UserName");
			userService.createUser(user);
			Assertions.fail();
		} catch (InvalidParameterException e) {
			Assertions.assertSame("userName must be unique.", e.getMessage());
		}
	}

	@Test
	public void createUserTest() {
		List<User> listUserMock = new ArrayList<>();
		listUserMock.add(userMock);

		Mockito.when(userRepository.findByUserName(Mockito.eq("UserName"))).thenReturn(new ArrayList<>());
		Mockito.when(userRepository.save(Mockito.any())).thenReturn(userMock);
		try {
			UserDTO user = new UserDTO();
			user.setUserName("UserName");
			Assertions.assertNotNull(userService.createUser(user));
		} catch (InvalidParameterException e) {
			Assertions.fail();
		}
	}
}
