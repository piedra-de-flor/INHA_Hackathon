package com.example.INHA_Hackathon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class InhaHackathonApplication {
	public static void main(String[] args) {
		SpringApplication.run(InhaHackathonApplication.class, args);
	}
}
