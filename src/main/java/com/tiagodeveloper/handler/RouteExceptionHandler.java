package com.tiagodeveloper.handler;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.WebFilter;

import com.tiagodeveloper.exception.NotFoundException;

@Component
public class RouteExceptionHandler {

	@Bean
	WebFilter onNotFoundException() {
		return (exchange, next) -> next.filter(exchange)
		.onErrorResume(NotFoundException.class, e -> {
           var response = exchange.getResponse();
            response.setStatusCode(HttpStatus.NOT_FOUND);
            return response.setComplete();
		});
	}
	
	@Bean
	WebFilter onIllegalArgumentException() {
		return (exchange, next) -> next.filter(exchange)
				.onErrorResume(IllegalArgumentException.class, e -> {
					var response = exchange.getResponse();
					response.setStatusCode(HttpStatus.BAD_REQUEST);
					return response.setComplete();
				});
	}
	
	
	
}
