package com.ddcode.hystrix.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
@RequestMapping("/hystrix/consumer")
public class HystrixConsumerController {

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/get")
    @HystrixCommand(fallbackMethod = "getUserFallback")
    public String get(@RequestParam("id") Integer id) {
        ResponseEntity<String> responseEntity = restTemplate.getForEntity("http://127.0.0.1:6611/hystrix/producer/get?id=" + id, String.class);
        return responseEntity.getBody();
    }


    public String getUserFallback(Integer id, Throwable throwable) {
        log.info("id {} 进入兜底方法, 抛异常 {}", id, throwable);
        return "id " + id + ", 进入兜底方法";
    }
}
