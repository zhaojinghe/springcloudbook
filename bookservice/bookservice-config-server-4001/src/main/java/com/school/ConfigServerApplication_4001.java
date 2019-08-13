package com.school;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ConfigServerApplication_4001 {
 
    public static void main(String[] args) {
        SpringApplication.run(ConfigServerApplication_4001.class, args);
    }
}