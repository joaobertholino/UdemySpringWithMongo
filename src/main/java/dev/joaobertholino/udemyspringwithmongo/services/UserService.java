package dev.joaobertholino.udemyspringwithmongo.services;

import dev.joaobertholino.udemyspringwithmongo.domain.User;
import dev.joaobertholino.udemyspringwithmongo.repository.UserRepository;
import dev.joaobertholino.udemyspringwithmongo.services.exceptions.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
	private final UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public List<User> findAll() {
		return this.userRepository.findAll();
	}

	public User findById(String id) {
		Optional<User> user = this.userRepository.findById(id);
		return user.orElseThrow(() -> new ObjectNotFoundException(id));
	}

	public void insert(User user) {
		this.userRepository.save(user);
	}

	public void delete(String id) {
		this.userRepository.delete(findById(id));
	}

	public void update(String id, User entity) {
		User user = this.userRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException(id));
		updateData(entity, user);
		this.userRepository.save(user);
	}

	private void updateData(User entity, User user) {
		if(entity.getName() != null) user.setName(entity.getName());
		if(entity.getEmail() != null) user.setEmail(entity.getEmail());
	}
}
