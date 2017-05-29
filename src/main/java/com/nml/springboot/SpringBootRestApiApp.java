package com.nml.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages={"com.nml.springboot"})// same as @Configuration @EnableAutoConfiguration @ComponentScan combined
public class SpringBootRestApiApp {


	public static void main(String[] args) {
		SpringApplication.run(SpringBootRestApiApp.class, args);
	}
}
