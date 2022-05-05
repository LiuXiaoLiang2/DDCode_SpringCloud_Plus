package com.ddcode.openfeign.controller;

import com.ddcode.openfeign.service.OrderFeignService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class OrderConsumer {

    @Resource
    private OrderFeignService orderFeignService;

    @GetMapping("/order/consumer")
    public String orderConsumer(String name){
        return orderFeignService.echo(name);
    }
}
