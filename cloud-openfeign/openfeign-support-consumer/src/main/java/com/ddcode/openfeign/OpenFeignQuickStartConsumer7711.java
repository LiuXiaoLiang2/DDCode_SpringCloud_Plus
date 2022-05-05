package com.ddcode.openfeign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@ComponentScan(basePackages = {"com.ddcode.openfeign.*"})
public class OpenFeignQuickStartConsumer7711 {
    public static void main(String[] args) {
        SpringApplication.run(OpenFeignQuickStartConsumer7711.class);
    }
}
