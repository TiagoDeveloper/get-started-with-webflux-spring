package com.tiagodeveloper.service.impl;

import org.springframework.stereotype.Service;

import com.tiagodeveloper.document.User;
import com.tiagodeveloper.repository.UserRepository;
import com.tiagodeveloper.service.UserService;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
	
	private final UserRepository userRepository;

	@Override
	public Flux<User> findAll(long limit, long skip) {
		return userRepository.findAll().skip(skip).take(limit);
	}

	@Override
	public Mono<User> findById(String id) {
		return userRepository.findById(id);
	}

	@Override
	public Mono<User> save(User user) {
		return userRepository.save(user);
	}

}
