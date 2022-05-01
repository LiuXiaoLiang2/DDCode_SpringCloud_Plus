package com.ddcode.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class OrderProviderController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/zookeeper/provider")
    public String echo() {
        return "zookeeper provider , server port: " + serverPort;
    }
}
