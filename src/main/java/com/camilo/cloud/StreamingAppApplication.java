package com.camilo.cloud;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StreamingAppApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(StreamingAppApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {

	}
}
