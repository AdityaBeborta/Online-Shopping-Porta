package com.order_lookup_service.config;

import java.util.Collections;

import org.modelmapper.ModelMapper;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class AppConfig {

	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
	
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(getInfo()).select().apis(RequestHandlerSelectors.basePackage("com.order_lookup_service"))
				.paths(PathSelectors.any()).build();
	}

	private ApiInfo getInfo() {
		@SuppressWarnings("unchecked")
		ApiInfo apiInfo = new ApiInfo("Order Look Up Service : Backend Application",
				"This project is for Learning Rest developed by Aditya Beborta", "1,0", "Terms Of Service",
				new Contact("Aditya Beborta", "adityabeborta", "adityabeborta123@gmail.com"),
				"copyright@2022 Aditya Beborta", "Api Response", Collections.EMPTY_LIST);
		return apiInfo;

	}
}
