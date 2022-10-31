package com.tiagodeveloper.router;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.tiagodeveloper.handler.UserRouterHandler;

@Configuration(proxyBeanMethods = false)
public class UserRouter {
	
	@Autowired
	private UserRouterHandler userRouterHandler;
	
	@Bean
	RouterFunction<ServerResponse> findAll() {
		return RouterFunctions.route(
			RequestPredicates.GET("/user")
			.and(RequestPredicates.accept(APPLICATION_JSON)),
			userRouterHandler::findAll
		);
	}
	
	@Bean
	RouterFunction<ServerResponse> findById() {
		return RouterFunctions.route(
			RequestPredicates.GET("/user/{id}")
			.and(RequestPredicates.accept(APPLICATION_JSON)),
			userRouterHandler::findById
		);
	}
	
	@Bean
	RouterFunction<ServerResponse> save() {
		return RouterFunctions.route(
			RequestPredicates.POST("/user")
			.and(RequestPredicates.accept(APPLICATION_JSON)),
			userRouterHandler::save
		);
	}
	
}
