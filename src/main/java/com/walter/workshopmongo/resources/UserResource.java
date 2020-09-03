package com.walter.workshopmongo.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.walter.workshopmongo.domain.User;

@RestController
@RequestMapping({ "/users" })
public class UserResource {

	@GetMapping
	public List<User> findAll() {
		List<User> users = new ArrayList<>();
		users.add(new User(1L, "Maria", "maria@gmail.com"));
		return users;
	}
}
