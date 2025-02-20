package com.bimuan.freshpress;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class FreshpressApplication {

	public static void main(String[] args) {

		SpringApplication.run(FreshpressApplication.class, args);
	}

}
