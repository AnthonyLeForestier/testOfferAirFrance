package offer.test.airfrance.mapper;

import org.mapstruct.Mapper;

import offer.test.airfrance.dto.UserDTO;
import offer.test.airfrance.entity.User;

@Mapper(componentModel = "spring")
public interface UserMapper {

	UserDTO userToUserDTO(User user);
	
	User userDTOToUser(UserDTO userDTO);
}
