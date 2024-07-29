package dev.joaobertholino.udemyspringwithmongo.config;

import dev.joaobertholino.udemyspringwithmongo.domain.User;
import dev.joaobertholino.udemyspringwithmongo.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class Instantiation implements CommandLineRunner {
	private final UserRepository userRepository;

	public Instantiation(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		this.userRepository.deleteAll();

		User u1 = new User("Joao Bertholino", "joao@email.com");
		User u2 = new User("Ellen Sthefani", "ellen@email.com");
		User u3 = new User("Nicolas Emanuel", "nicolas@email.com");
		this.userRepository.saveAll(Arrays.asList(u1, u2, u3));
	}
}
