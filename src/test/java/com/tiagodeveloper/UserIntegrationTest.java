package com.tiagodeveloper;


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

}
