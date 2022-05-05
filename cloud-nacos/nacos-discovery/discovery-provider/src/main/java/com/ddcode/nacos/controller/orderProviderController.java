package com.ddcode.nacos.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class orderProviderController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/nacos/provider")
    public String echo() {
        return "nacos provider , server port: " + serverPort;
    }
}
