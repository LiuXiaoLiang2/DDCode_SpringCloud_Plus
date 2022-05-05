package com.ddcode.openfeign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(basePackages = {"com.ddcode.openfeign.*"})
public class OpenFeignQuickStartProvider8811 {
    public static void main(String[] args) {
        SpringApplication.run(OpenFeignQuickStartProvider8811.class);
    }
}
