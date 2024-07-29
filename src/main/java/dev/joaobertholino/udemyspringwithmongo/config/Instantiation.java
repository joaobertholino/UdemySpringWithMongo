package dev.joaobertholino.udemyspringwithmongo.config;

import dev.joaobertholino.udemyspringwithmongo.domain.Post;
import dev.joaobertholino.udemyspringwithmongo.domain.User;
import dev.joaobertholino.udemyspringwithmongo.repository.PostRepository;
import dev.joaobertholino.udemyspringwithmongo.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

@Configuration
public class Instantiation implements CommandLineRunner {
	private final UserRepository userRepository;
	private final PostRepository postRepository;

	public Instantiation(UserRepository userRepository, PostRepository postRepository) {
		this.userRepository = userRepository;
		this.postRepository = postRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'");

		this.userRepository.deleteAll();
		this.postRepository.deleteAll();

		User u1 = new User("Joao Bertholino", "joao@email.com");
		User u2 = new User("Ellen Sthefani", "ellen@email.com");
		User u3 = new User("Nicolas Emanuel", "nicolas@email.com");
		this.userRepository.saveAll(Arrays.asList(u1, u2, u3));

		Post p1 = new Post(LocalDateTime.parse("2020-07-23T15:01:00Z", dateTimeFormatter), "First day", "I wait for you", u1);
		Post p2 = new Post(LocalDateTime.parse("2022-09-03T15:01:00Z", dateTimeFormatter), "Last day", "Goodbye", u1);
		this.postRepository.saveAll(Arrays.asList(p1, p2));
	}
}
