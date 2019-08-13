package com.school;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
public class BookProviderHystrixApplication_1005 {
	public static void main(String[] args) {
        SpringApplication.run(BookProviderHystrixApplication_1005.class, args);
    }
}
