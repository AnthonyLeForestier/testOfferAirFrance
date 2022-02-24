package offer.test.airfrance.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import offer.test.airfrance.dto.UserDTO;
import offer.test.airfrance.exception.InvalidParameterException;
import offer.test.airfrance.exception.NotFoundException;
import offer.test.airfrance.service.UserService;

@ExtendWith(MockitoExtension.class)
public class UserControllerTest {

	@InjectMocks
	private UserController userController;

	@Mock
	private UserService userService;

	@Test()
	public void createUserTest() throws InvalidParameterException {
		UserDTO user = new UserDTO();
		Mockito.when(userService.createUser(Mockito.eq(user))).thenReturn(user);

		Assertions.assertNotNull(userController.createUser(user));
	}

	@Test()
	public void findUserTest() throws NotFoundException {
		UserDTO user = new UserDTO();
		Mockito.when(userService.findUserById(Mockito.eq(1L))).thenReturn(user);

		Assertions.assertNotNull(userController.findUser(1L));
	}

	@Test
	public void createUserAlreadyExist() throws InvalidParameterException {
		UserDTO user = new UserDTO();
		Mockito.when(userService.createUser(Mockito.eq(user)))
				.thenThrow(new InvalidParameterException("userName must be unique."));
		try {
			userController.createUser(user);
			Assertions.fail();
		} catch (InvalidParameterException e) {
			Assertions.assertSame("userName must be unique.", e.getMessage());
		}
	}

	@Test
	public void userNotFoundTest() throws NotFoundException {
		Mockito.when(userService.findUserById(Mockito.eq(1L))).thenThrow(new NotFoundException("User not found."));
		try {
			userController.findUser(1L);
			Assertions.fail();
		} catch (NotFoundException e) {
			Assertions.assertSame("User not found.", e.getMessage());
		}
	}
}
