package com.example.satya.rest.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableAspectJAutoProxy
@Configuration
@EntityScan({"com.example.satya.vo"})
@ComponentScan(basePackages = {"com.example"})
@Component
public class Main extends SpringBootServletInitializer   {

	public static void main(String... args) {
		SpringApplication.run(Main.class, args);
	}
	
	
	@GetMapping(value = "/welcomemessage")
	public String getWelcomeMessage() {
		return "Welcome to Personal Information Portal";
	}

	
	
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Main.class);
	}
	 
	 

}
