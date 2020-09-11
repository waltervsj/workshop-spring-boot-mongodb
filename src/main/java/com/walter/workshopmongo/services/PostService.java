package com.walter.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.walter.workshopmongo.domain.Post;
import com.walter.workshopmongo.repositories.PostRepository;
import com.walter.workshopmongo.services.exceptions.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	PostRepository postRepository;

	public void create(Post post) {
		postRepository.save(post);
	}

	public Post findById(String id) {
		Optional<Post> post = postRepository.findById(id);
		if (post.isEmpty())
			throw new ObjectNotFoundException("Post not found");
		return post.get();
	}
	
	public List<Post> findByTitle(String text) {
		return postRepository.findByTitleContainingIgnoreCase(text);
	}
}
