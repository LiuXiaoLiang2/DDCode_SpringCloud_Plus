package com.ddcode.openfeign.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderProducerController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/hystrix/openfeign/producer")
    String hystrixOpenfeign(@RequestParam("name") String name){
        return "OrderProducer hystrix openfeign serverPort :" + serverPort + ", name :" + name;
    }
}
