package dev.joaobertholino.udemyspringwithmongo.resources;

import dev.joaobertholino.udemyspringwithmongo.dataaccessobject.UserDTO;
import dev.joaobertholino.udemyspringwithmongo.domain.User;
import dev.joaobertholino.udemyspringwithmongo.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

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

	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody User user) {
		this.userService.insert(user);
		UriComponentsBuilder builder = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}");
		UriComponents components = builder.buildAndExpand(user.getId());
		return ResponseEntity.created(components.toUri()).build();
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable String id) {
		this.userService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
