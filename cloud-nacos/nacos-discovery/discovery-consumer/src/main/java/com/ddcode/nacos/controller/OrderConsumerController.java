package com.ddcode.nacos.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderConsumerController {

    private static String BASE_URL = "nacos-provider";

    @Resource
    private RestTemplate restTemplate;

    @RequestMapping("/nacos/consumer")
    public String orderConsumer(){
        String forObject = restTemplate.getForObject("http://" + BASE_URL + "/nacos/provider", String.class);
        log.info("orderConsumer {}", forObject);
        return forObject;
    }
}
