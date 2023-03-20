package com.ngo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;




@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "NGO API", version = "0.1.0", description = "A application for an ngo with member and user databases."))
public class NgoApplication {

	public static void main(String[] args) {
		SpringApplication.run(NgoApplication.class, args);
		
	}

}
