package com.myApp.superApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.myApp.superApp.repository.RoleRepository;

@SpringBootApplication
public class SuperAppApplication {
	
	@Autowired
	RoleRepository roleRepository;

	public static void main(String[] args) {
		SpringApplication.run(SuperAppApplication.class, args);
	}

}
