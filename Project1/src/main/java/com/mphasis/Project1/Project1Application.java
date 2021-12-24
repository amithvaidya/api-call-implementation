package com.mphasis.Project1;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Project1Application {

	public static void main(String[] args) {
		System.out.println(LocalDateTime.now().toString());
		SpringApplication.run(Project1Application.class, args);
	}

}
