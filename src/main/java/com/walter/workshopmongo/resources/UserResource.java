package com.walter.workshopmongo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
