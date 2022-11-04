package com.tiagodeveloper.service.impl;

import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import com.tiagodeveloper.document.User;
import com.tiagodeveloper.exception.NotFoundException;
import com.tiagodeveloper.repository.UserRepository;
import com.tiagodeveloper.service.UserService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
	
	private final UserRepository userRepository;

	@Override
	@CircuitBreaker(name = "find-all-users")
	public Flux<User> findAll(long limit, long skip) {
		return userRepository.findAll().skip(skip).take(limit);
	}

	@Override
	public Mono<User> findById(ObjectId id) {
		return userRepository.findById(id).switchIfEmpty(
				Mono.error( new NotFoundException("ID {} não encontrado"))
		);
	}

	@Override
	public Mono<User> save(User user) {
		return userRepository.save(user);
	}
	

}
