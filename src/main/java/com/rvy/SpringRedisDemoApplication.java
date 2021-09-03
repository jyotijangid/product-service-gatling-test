package com.rvy;

import static springfox.documentation.builders.PathSelectors.regex;

import java.util.function.Predicate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

//import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@SpringBootApplication
//@EnableSwagger2
//@EnableOpenApi
public class SpringRedisDemoApplication {


	
	public static void main(String[] args) {
		SpringApplication.run(SpringRedisDemoApplication.class, args);
	}
	
//	@Bean
//	public Docket openApiPetStore() {
//		return new Docket(DocumentationType.OAS_30)
//				.groupName("open-api-product-management-service")
//				.select()
//				.paths(cmsPaths())
//				.build();
//	}
//
//	private Predicate<String> cmsPaths() {
//		return regex(".*/v1/.*");
//	}


}
