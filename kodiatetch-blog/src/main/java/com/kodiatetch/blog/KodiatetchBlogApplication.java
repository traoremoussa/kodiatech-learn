package com.kodiatetch.blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@PropertySource({"Classpth:application:yml"})
public class KodiatetchBlogApplication {

	public static void main(String[] args) {
		SpringApplication.run(KodiatetchBlogApplication.class, args);
	}

}
