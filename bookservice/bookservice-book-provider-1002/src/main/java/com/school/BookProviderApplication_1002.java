package com.school;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class BookProviderApplication_1002 {
	public static void main(String[] args) {
        SpringApplication.run(BookProviderApplication_1002.class, args);
    }
}
