package com.prologiccreations.payrollapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class PayrollApplication {
	public static ApplicationContext context;
	public static void main(String[] args) {context =
		SpringApplication.run(PayrollApplication.class, args);
		System.out.println(new BCryptPasswordEncoder().encode("1234"));
	}


	public static String getCurrentUsername(){
		return SecurityContextHolder.getContext().getAuthentication().getName();
	}

}
