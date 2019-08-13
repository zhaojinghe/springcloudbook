package com.school.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigClientController {
 
    @Value("${port}")
    private String port;
 
    @GetMapping("/getPort")
    public String getPort() {
        return port;
    }
 
    public void setPort(String port) {
        this.port = port;
    }
     
     
}