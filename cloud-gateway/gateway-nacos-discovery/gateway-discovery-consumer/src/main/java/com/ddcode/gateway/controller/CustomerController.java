package com.ddcode.gateway.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/gateway")
public class CustomerController {

    @Value("${server.port}")
    private String serverPort;

    @RequestMapping("/customer")
    public String customer(){
        return "gateway_customer : " + serverPort;
    }
}
