package com.login.auth.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class LoginConfig {

	@Bean("restClient")
	public RestTemplate setTemplateRegistry() {
		return new RestTemplate();
	}
}
