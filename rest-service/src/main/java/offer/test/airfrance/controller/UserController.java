package offer.test.airfrance.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import offer.test.airfrance.dto.UserDTO;
import offer.test.airfrance.exception.InvalidParameterException;
import offer.test.airfrance.exception.NotFoundException;
import offer.test.airfrance.service.UserService;

@RequestMapping("v1")
@RestController("userController")
@Tag(name = "User", description = "User repository management application")
public class UserController {

	private final UserService userService;

	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}

	@Operation(summary = "Create User", description = "Allows to register a user.")
	@PostMapping(consumes = "application/json", path = "/user", produces = "application/json")
	public UserDTO createUser(@RequestBody @Validated UserDTO userDto) throws InvalidParameterException {
		return userService.createUser(userDto);
	}

	@Operation(summary = "Find User", description = "Displays the details of a registered user.")
	@GetMapping(path = "/user/{id}", produces = "application/json")
	public UserDTO findUser(@PathVariable(value = "id") Long id) throws NotFoundException {
		return userService.findUserById(id);
	}

}
