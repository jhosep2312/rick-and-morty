package com.bolivar.rick_and_morthy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class RickAndMorthyApplication {

	public static void main(String[] args) {
		SpringApplication.run(RickAndMorthyApplication.class, args);
	}

}
