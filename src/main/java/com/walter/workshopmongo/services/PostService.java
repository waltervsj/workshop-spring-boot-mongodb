package com.walter.workshopmongo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.walter.workshopmongo.domain.Post;
import com.walter.workshopmongo.repositories.PostRepository;

@Service
public class PostService {
	
	@Autowired
	PostRepository postRepository;
	
	public void create(Post post) {
		postRepository.save(post);
	}
}
