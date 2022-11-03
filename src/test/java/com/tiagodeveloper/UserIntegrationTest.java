package com.tiagodeveloper;


import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.AutoConfigureDataMongo;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;

import com.tiagodeveloper.config.UserPopulatorConfiguration;
import com.tiagodeveloper.document.Address;
import com.tiagodeveloper.document.User;
import com.tiagodeveloper.enums.DocumentType;


@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureDataMongo
@Import(UserPopulatorConfiguration.class)
class UserIntegrationTest {

	@Autowired
	private WebTestClient webTestClient;
	
	@Test
	void findAllTest() {
		
		webTestClient
	      .get().uri("/user")
	      .accept(MediaType.APPLICATION_JSON)
	      .exchange()
	      .expectStatus().isOk()
	      .expectBody()
	      .jsonPath("$[0].name").isEqualTo("Tânia");
	      
	}
	
	
	@Test
	void saveTest() {
		
		Set<Address> address = new HashSet<>();
		address.add(
			Address.builder()
				.name("principal")
				.address("Rua comendador teixeira da costa")
			.build()
		); 
		
		var user = User.builder()
				.name("Tiago Fonseca")
				.email("tiago.fonseca@zup.com.br")
				.documentType(DocumentType.CPF)
				.documentValue("08829991676")
				.address(address)
				.build();
		webTestClient
	      .post().uri("/user")
	      .bodyValue(user)
	      .accept(MediaType.APPLICATION_JSON)
	      .exchange()
	      .expectStatus().isCreated()
	      .expectBody()
	      .jsonPath("$.name").isEqualTo("Tiago Fonseca");
	      
	}

}
