package com.sample.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class EventlistenerPocApplication {

	public static void main(String[] args) {
		SpringApplication.run(EventlistenerPocApplication.class, args);
	}
}
