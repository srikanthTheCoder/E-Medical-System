package com.org.hms.apis.configurations;

import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class OpenApiConfig {
	
	@Bean
	public GroupedOpenApi publicApi() {
		String[] packagedToMatch = { "com.org" };
		return GroupedOpenApi.builder().setGroup("manage-patients-api").packagesToScan(packagedToMatch).pathsToMatch("/**")
				.build();
	}
	

	@Bean
	public OpenAPI customOpenAPI() {
		return new OpenAPI().components(new Components()).info(new Info()
				.title("Hospital Management System")
				.version("Hospital Management System")
				.description("API For Managing the hospital operations"));
	}
}
