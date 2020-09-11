package com.walter.workshopmongo.config;

import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.walter.workshopmongo.domain.Post;
import com.walter.workshopmongo.domain.User;
import com.walter.workshopmongo.dto.AuthorDTO;
import com.walter.workshopmongo.repositories.PostRepository;
import com.walter.workshopmongo.repositories.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {
	@Autowired
	UserRepository userRepository;

	@Autowired
	PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		userRepository.deleteAll();
		
		User u1 = new User(null, "João", "joao@gmail.com");
		User u2 = new User(null, "Pedro", "pedro@gmail.com");
		User u3 = new User(null, "Chico", "chico@gmail.com");
		
		userRepository.saveAll(Arrays.asList(u1, u2, u3));
		
		postRepository.deleteAll();
		
		AuthorDTO author1 = new AuthorDTO(u1);
		AuthorDTO author2 = new AuthorDTO(u2);
		
		Post p1 = new Post(null, new Date(), "Post title", "Post body", author1);
		Post p2 = new Post(null, new Date(), "Post title 2", "Post body 2", author2);
		Post p3 = new Post(null, new Date(), "Post title 3", "Post body 3", author2);
		
		postRepository.saveAll(Arrays.asList(p1, p2, p3));
	}

}
