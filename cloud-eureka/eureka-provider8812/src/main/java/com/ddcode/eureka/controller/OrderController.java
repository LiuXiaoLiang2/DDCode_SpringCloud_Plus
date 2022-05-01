package com.ddcode.eureka.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Value("${server.port}")
    public String serverPort;

    @Value("${spring.application.name}")
    public String applicationName;

    @GetMapping("/eureka/provider/getOrder/{id}")
    public String getOrder(@PathVariable("id") Long id){
        return "applicationName :" + applicationName + ", serverPort :" + serverPort + ", id: " + id;
    }
}
