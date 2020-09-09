package com.walter.workshopmongo.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.walter.workshopmongo.domain.User;
import com.walter.workshopmongo.dto.UserDTO;
import com.walter.workshopmongo.services.UserService;

@RestController
@RequestMapping({ "/users" })
public class UserResource {

	@Autowired
	UserService userService;

	@GetMapping
	public List<UserDTO> findAll() {
		return userService.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<UserDTO> findById(@PathVariable String id) {
		User user = userService.findById(id);
		return ResponseEntity.ok().body(new UserDTO(user));
	}
	
	@PostMapping
	public ResponseEntity<Void> create(@RequestBody UserDTO userDTO) {
		User user = userService.fromDTO(userDTO);
		userService.create(user);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<UserDTO> deleteById(@PathVariable String id) {
		userService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<UserDTO> update(@PathVariable String id, @RequestBody UserDTO userDTO) {
		userDTO.setId(id);
		User user = userService.fromDTO(userDTO);
		userService.update(user);
		return ResponseEntity.noContent().build();
	}
}
