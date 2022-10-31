package com.tiagodeveloper.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.data.repository.init.Jackson2RepositoryPopulatorFactoryBean;

@Configuration
public class UserPopulatorConfiguration {

	@Value("classpath:script/test/user/insert-user.json")
	private Resource resourceFile;

	@Bean
	public Jackson2RepositoryPopulatorFactoryBean getRepositoryPopulator() {
		Jackson2RepositoryPopulatorFactoryBean factory = new Jackson2RepositoryPopulatorFactoryBean();
		factory.setResources(new Resource[] { resourceFile });

		return factory;
	}

}
