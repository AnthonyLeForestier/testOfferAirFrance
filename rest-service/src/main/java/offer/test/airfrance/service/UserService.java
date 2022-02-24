package offer.test.airfrance.service;

import offer.test.airfrance.dto.UserDTO;
import offer.test.airfrance.exception.InvalidParameterException;
import offer.test.airfrance.exception.NotFoundException;

public interface UserService {

	/**
	 * User creation service.
	 * 
	 * @param user
	 * @return UserDTO including the created User.
	 * @throws NullPointerException      if user is null.
	 * @throws InvalidParameterException if user.userName already exists.
	 */
	public UserDTO createUser(UserDTO user) throws InvalidParameterException;

	/**
	 * User search service by id.
	 * 
	 * @param id
	 * @return UserDTO including the user found.
	 * @throws NotFoundException if user not found with id.
	 */
	public UserDTO findUserById(Long id) throws NotFoundException;
}
