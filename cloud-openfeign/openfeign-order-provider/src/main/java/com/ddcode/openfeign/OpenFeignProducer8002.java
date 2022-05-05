package com.ddcode.openfeign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class OpenFeignProducer8002 {
    public static void main(String[] args) {
        SpringApplication.run(OpenFeignProducer8002.class);
    }
}
