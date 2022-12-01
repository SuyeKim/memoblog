package com.sparta.memoblog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class MemoblogApplication {

	public static void main(String[] args) {
		SpringApplication.run(MemoblogApplication.class, args);
	}

}
