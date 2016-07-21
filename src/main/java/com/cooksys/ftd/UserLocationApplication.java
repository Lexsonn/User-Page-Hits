package com.cooksys.ftd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@Configuration
@RestController
@EnableScheduling
public class UserLocationApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserLocationApplication.class, args);
	}
}
