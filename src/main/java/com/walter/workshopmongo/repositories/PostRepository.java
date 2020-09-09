package com.walter.workshopmongo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.walter.workshopmongo.domain.Post;

public interface PostRepository extends MongoRepository<Post, String>{

}
