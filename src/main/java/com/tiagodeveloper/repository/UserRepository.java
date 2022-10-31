package com.tiagodeveloper.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.tiagodeveloper.document.User;

public interface UserRepository extends ReactiveMongoRepository<User, String>{

}
