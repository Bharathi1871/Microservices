package com.configserver.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class AdmissionsConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdmissionsConfigServerApplication.class, args);
	}

}
