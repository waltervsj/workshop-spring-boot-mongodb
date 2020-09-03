package com.walter.workshopmongo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.walter.workshopmongo.domain.User;
import com.walter.workshopmongo.repositories.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {
	@Autowired
	UserRepository userRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		userRepository.deleteAll();
		
		User u1 = new User(null, "João", "joao@gmail.com");
		User u2 = new User(null, "Pedro", "pedro@gmail.com");
		User u3 = new User(null, "Chico", "chico@gmail.com");
		
		userRepository.saveAll(Arrays.asList(u1, u2, u3));
	}

}