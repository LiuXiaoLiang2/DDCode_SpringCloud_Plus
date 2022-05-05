package com.ddcode.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
public class RibbonProviderController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/ribbon/quickstart/provider")
    public String echo() throws InterruptedException {
        log.info("ribbon quickstart provider , server port: {}", serverPort);
        // 休息20s
        TimeUnit.SECONDS.sleep(20);
        return "ribbon quickstart provider , server port: " + serverPort;
    }
}
