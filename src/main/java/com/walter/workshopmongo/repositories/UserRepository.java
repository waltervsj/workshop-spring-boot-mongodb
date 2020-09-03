package com.walter.workshopmongo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.walter.workshopmongo.domain.User;

public interface UserRepository extends MongoRepository<User, String> {

}
