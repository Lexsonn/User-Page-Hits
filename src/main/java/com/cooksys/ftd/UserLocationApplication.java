package com.cooksys.ftd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@Configuration
@RestController
public class UserLocationApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserLocationApplication.class, args);
	}
}
