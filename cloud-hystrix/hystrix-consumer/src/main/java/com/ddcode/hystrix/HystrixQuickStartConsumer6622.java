package com.ddcode.hystrix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
//声明开启断路器
@EnableCircuitBreaker
@EnableHystrix
public class HystrixQuickStartConsumer6622 {
    public static void main(String[] args) {
        SpringApplication.run(HystrixQuickStartConsumer6622.class);
    }
}
