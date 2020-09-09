package com.walter.workshopmongo.config;

import java.util.Arrays;
import java.util.Date;

import javax.print.attribute.standard.DateTimeAtCompleted;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.walter.workshopmongo.domain.Post;
import com.walter.workshopmongo.domain.User;
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
		
		Post p1 = new Post(null, new Date(), "Post title", "Post body", u1);
		Post p2 = new Post(null, new Date(), "Post title 2", "Post body 2", u2);
		Post p3 = new Post(null, new Date(), "Post title 3", "Post body 3", u2);
		
		postRepository.saveAll(Arrays.asList(p1, p2, p3));
	}

}
