package com.ddcode.openfeign.controller;

import com.ddcode.openfeign.service.OpenFeignService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class OrderConsumerController {

    @Resource
    private OpenFeignService openFeignService;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/hystrix/openfeign/consumer")
    String hystrixOpenfeign(@RequestParam("name") String name){
        String hystrixOpenfeign = openFeignService.hystrixOpenfeign(name);
        return hystrixOpenfeign;
    }

}
