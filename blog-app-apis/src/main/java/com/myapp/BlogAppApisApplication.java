package com.myapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BlogAppApisApplication {

	@Autowired

	public static void main(String[] args) {

		SpringApplication.run(BlogAppApisApplication.class, args);

	}


}
