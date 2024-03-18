package com.prototype;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class TiviaApplication {

	public static void main(String[] args) {
		SpringApplication.run(TiviaApplication.class, args);
	}
}