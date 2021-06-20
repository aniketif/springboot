package com.aniket.Boot;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;



@SpringBootApplication
@EnableSwagger2
public class BootApplication 
{

	public static void main(String[] args) {
		SpringApplication.run(BootApplication.class, args);
	}

	@Bean
	public Docket swaggerConfiguration()
	{
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.aniket.Boot.StudentController"))
				.build()
				.apiInfo(apiDetails());
	}
	
	private ApiInfo apiDetails()
	{
		return new ApiInfo(
				"Student Details", 
				"Sample Api for student infromation",
				"1.0", 
				"Free to Use",
				new springfox.documentation.service.Contact("Aniket Gayakwad", "https://github.com/aniketif", "aniketif@gmail.com"), 
				"Api License",
				"https://github.com/aniketif",
				Collections.emptyList());
	}
}
