package com.walter.workshopmongo.config;

import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.walter.workshopmongo.domain.Post;
import com.walter.workshopmongo.domain.User;
import com.walter.workshopmongo.dto.AuthorDTO;
import com.walter.workshopmongo.dto.CommentDTO;
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
		postRepository.deleteAll();

		User u1 = new User(null, "João", "joao@gmail.com");
		User u2 = new User(null, "Pedro", "pedro@gmail.com");
		User u3 = new User(null, "Chico", "chico@gmail.com");

		userRepository.saveAll(Arrays.asList(u1, u2, u3));

		AuthorDTO author1 = new AuthorDTO(u1);
		AuthorDTO author2 = new AuthorDTO(u2);

		Post p1 = new Post(null, new Date(), "Post title", "Post body", author1);
		Post p2 = new Post(null, new Date(), "Post title 2", "Post body 2", author2);
		Post p3 = new Post(null, new Date(), "Post title 3", "Post body 3", author2);

		postRepository.saveAll(Arrays.asList(p1, p2, p3));

		CommentDTO comment1 = new CommentDTO("Opa! Comment 1", new Date(), author1);
		CommentDTO comment2 = new CommentDTO("Opa! Comment 2", new Date(), author2);
		CommentDTO comment3 = new CommentDTO("Opa! Comment 3", new Date(), author2);

		p2.getComments().addAll(Arrays.asList(comment1, comment2, comment3));

		postRepository.save(p2);

		u2.getPosts().addAll(Arrays.asList(p2, p3));

		userRepository.save(u2);
	}

}
