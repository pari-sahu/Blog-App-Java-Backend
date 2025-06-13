package com.blog.blog_app_backend;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
//pari
@SpringBootApplication
public class BlogAppBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlogAppBackendApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}


}