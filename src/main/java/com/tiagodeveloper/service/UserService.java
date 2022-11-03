package com.tiagodeveloper.service;

import org.bson.types.ObjectId;

import com.tiagodeveloper.document.User;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserService {
	
	
	Flux<User> findAll(long limit, long skip);
	Mono<User> findById(ObjectId id);
	Mono<User> save(User user);

}
