package com.ddcode.order.controller;

import com.ddcode.model.Order;
import com.ddcode.order.service.OrderService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Resource
    private OrderService orderService;

    @RequestMapping(value =  "/get/{id}", produces={"application/json;charset=UTF-8"})
    public Order getById(@PathVariable("id") Integer id){
        return orderService.getOrderById(id);
    }
}
