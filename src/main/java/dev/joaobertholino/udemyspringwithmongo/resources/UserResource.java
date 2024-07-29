package dev.joaobertholino.udemyspringwithmongo.resources;

import dev.joaobertholino.udemyspringwithmongo.dataaccessobject.UserDTO;
import dev.joaobertholino.udemyspringwithmongo.domain.User;
import dev.joaobertholino.udemyspringwithmongo.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/users")
public class UserResource {
	private final UserService userService;

	public UserResource(UserService userService) {
		this.userService = userService;
	}

	@GetMapping
	public ResponseEntity<List<UserDTO>> findAll() {
		List<User> userList = this.userService.findAll();

		List<UserDTO> userDTOList = userList.stream().map(user -> new UserDTO(user)).toList();
		return ResponseEntity.ok(userDTOList);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<UserDTO> findById(@PathVariable String id) {
		UserDTO userDTO = new UserDTO(this.userService.findById(id));
		return ResponseEntity.ok(userDTO);
	}
}
