package com.walter.workshopmongo.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.walter.workshopmongo.domain.User;
import com.walter.workshopmongo.dto.UserDTO;
import com.walter.workshopmongo.repositories.UserRepository;
import com.walter.workshopmongo.services.exceptions.ObjectNotFoundException;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;

	public List<UserDTO> findAll() {
		List<User> users = userRepository.findAll();
		List<UserDTO> dtoUsers = users.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
		return dtoUsers;
	}

	public User findById(String id) {
		//userRepository.findOne(id);
		Optional<User> user = userRepository.findById(id);
		if (user.isEmpty())
			throw new ObjectNotFoundException("User not found.");

		return user.get();
	}
	
	public void create(User user) {
		userRepository.save(user);
	}
	
	public void delete(String id) {
		User user = this.findById(id);
		userRepository.delete(user);
	}

	public User update(User user) {
		return userRepository.save(user);
	}

	public User fromDTO(UserDTO userDTO) {
		return new User(userDTO.getId(), userDTO.getName(), userDTO.getEmail());
	}
}
