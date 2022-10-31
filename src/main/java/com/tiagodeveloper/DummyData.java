package com.tiagodeveloper;

import java.util.UUID;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.tiagodeveloper.document.User;
import com.tiagodeveloper.repository.UserRepository;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

//@Component
//@RequiredArgsConstructor
public class DummyData implements CommandLineRunner {
	
//	private final UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		
//		userRepository.deleteAll().thenMany(
//			Flux.just("Tânia", "Tiago", "Rodrigo", "José", "Patrícia")
//			.map(name -> new User(UUID.randomUUID().toString(), name, "email", "cpf", "cpf_value"))
//			.flatMap(userRepository::save)
//		)
//		.subscribe(System.out::println);
		
		
	}

}
