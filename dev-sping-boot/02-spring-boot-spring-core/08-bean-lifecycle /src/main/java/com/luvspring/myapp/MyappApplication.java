package com.luvspring.myapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/* @SpringBootApplication(
		scanBasePackages = {
				"com.luvspring.myapp",
				"com.luvspring.util"
		}
)*/

@SpringBootApplication
public class MyappApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyappApplication.class, args);
	}

}
