package com.cloudfinch.interview;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class CloudFinch {
	final public static String PARAMETER_API_URL = "https://restcountries-v1.p.rapidapi.com/all";
	public static void main(String[] args) {
		SpringApplication.run(CloudFinch.class, args);
	}

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

}
