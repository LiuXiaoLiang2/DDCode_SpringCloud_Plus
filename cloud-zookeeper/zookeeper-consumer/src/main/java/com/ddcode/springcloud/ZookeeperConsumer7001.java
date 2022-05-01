package com.ddcode.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ZookeeperConsumer7001 {
    public static void main(String[] args) {
        SpringApplication.run(ZookeeperConsumer7001.class);
    }
}
