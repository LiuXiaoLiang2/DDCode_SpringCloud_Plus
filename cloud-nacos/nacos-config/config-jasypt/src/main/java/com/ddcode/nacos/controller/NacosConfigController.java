package com.ddcode.nacos.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class NacosConfigController {

    @Value("${spring.redis.password}")
    private String redisPwd;

    @RequestMapping("/redisPwd")
    public String redisPwd(){
        return redisPwd;
    }
}
