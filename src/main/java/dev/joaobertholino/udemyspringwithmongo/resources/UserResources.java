package dev.joaobertholino.udemyspringwithmongo.resources;

import dev.joaobertholino.udemyspringwithmongo.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(path = "/users")
public class UserResources {

	@GetMapping
	public ResponseEntity<List<User>> getAll() {
		User userOne = new User(1, "Joao Bertholino", "joao@email.com");
		User userTwo = new User(2, "Ellen Sthefani", "ellen@email.com");
		return ResponseEntity.ok(Arrays.asList(userOne, userTwo));
	}
}
