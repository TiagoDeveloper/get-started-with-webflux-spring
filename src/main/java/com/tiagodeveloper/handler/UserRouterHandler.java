package com.tiagodeveloper.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.tiagodeveloper.document.User;
import com.tiagodeveloper.service.UserService;

import reactor.core.publisher.Mono;

@Component
public class UserRouterHandler {
	
	@Autowired
	private UserService userService;
	
	public Mono<ServerResponse> findAll(ServerRequest request) {
		
		var limit = Long.parseLong(request.queryParam("size").orElse("20"));
		var page = Long.parseLong(request.queryParam("page").orElse("0"));
		var skip = page * limit;
				
		return ServerResponse
		.ok()
		.contentType(MediaType.APPLICATION_JSON)
		.body(
			userService.findAll(limit, skip),
			User.class
		);
	}
	
	
	public Mono<ServerResponse> findById(ServerRequest request) {
		
		return ServerResponse
		.ok()
		.contentType(MediaType.APPLICATION_JSON)
		.body(
			userService.findById(request.pathVariable("id")),
			User.class
		);
	}
	
	public Mono<ServerResponse> save(ServerRequest request) {
		
		final var user = request.bodyToMono(User.class);
		
		return ServerResponse
		.status(HttpStatus.CREATED)
		.contentType(MediaType.APPLICATION_JSON)
		.body(
			user.flatMap(userService::save),
			User.class
		);
	}

}
