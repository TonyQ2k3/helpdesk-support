package com.tonyq.motionbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class MotionBackendApplication {
	public static void main(String[] args) {
		SpringApplication.run(MotionBackendApplication.class, args);
	}

	@GetMapping("/")
	public static String home() {
		return "This is the homepage of the API, nothing to see here";
	}
}
