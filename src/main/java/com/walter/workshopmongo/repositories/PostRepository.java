package com.walter.workshopmongo.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.walter.workshopmongo.domain.Post;

public interface PostRepository extends MongoRepository<Post, String> {
	List<Post> findByTitleContainingIgnoreCase(String text);

	@Query("{'title': { $regex: ?0, $options: 'i' } }")
	List<Post> _findByTitle(String text);
}
