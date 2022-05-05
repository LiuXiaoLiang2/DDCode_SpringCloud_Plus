package com.ddcode.openfeign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
//将服务注册到nacos
@EnableDiscoveryClient
public class HystrixOpenFeignProducerMain6632 {
    public static void main(String[] args) {
        SpringApplication.run(HystrixOpenFeignProducerMain6632.class);
    }
}
