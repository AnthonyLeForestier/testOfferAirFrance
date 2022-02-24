package offer.test.airfrance.service.impl;

import org.springframework.stereotype.Service;

import offer.test.airfrance.dto.UserDTO;
import offer.test.airfrance.exception.InvalidParameterException;
import offer.test.airfrance.exception.NotFoundException;
import offer.test.airfrance.mapper.UserMapper;
import offer.test.airfrance.repository.UserRepository;
import offer.test.airfrance.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;

	private final UserMapper userMapper;

	public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
		super();
		this.userRepository = userRepository;
		this.userMapper = userMapper;
	}

	@Override
	public UserDTO createUser(UserDTO userDTO) throws InvalidParameterException {
		if (userRepository.findByUserName(userDTO.getUserName()).isEmpty()) {
			return userMapper.userToUserDTO(userRepository.save(userMapper.userDTOToUser(userDTO)));
		} else {
			throw new InvalidParameterException("userName must be unique.");
		}
	}

	@Override
	public UserDTO findUserById(Long id) throws NotFoundException {
		return userMapper
				.userToUserDTO(userRepository.findById(id).orElseThrow(() -> new NotFoundException("User not found.")));
	}
}
