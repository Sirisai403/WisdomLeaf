package com.interview.speakingclock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@SpringBootApplication
@OpenAPIDefinition(
	info = @Info(
			title = "Speaking Time",
			version = "1.0.0",
			description = "Project for Speaking Time",
			termsOfService = "runcodenow",
			contact = @Contact(
					name = "Ms Sirini",
					email = "sirisai403@gmail.com"),
			license = @License(
					name = "license",
					url = "runcodenow")
			)
)
public class SpeackingClockApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpeackingClockApplication.class, args);
	}

}
