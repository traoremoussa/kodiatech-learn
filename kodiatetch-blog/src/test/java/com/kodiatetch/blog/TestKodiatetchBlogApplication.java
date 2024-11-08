package com.kodiatetch.blog;

import org.springframework.boot.SpringApplication;

public class TestKodiatetchBlogApplication {

	public static void main(String[] args) {
		SpringApplication.from(KodiatetchBlogApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
