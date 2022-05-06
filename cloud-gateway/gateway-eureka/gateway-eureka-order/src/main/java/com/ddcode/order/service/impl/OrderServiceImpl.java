package com.ddcode.order.service.impl;

import com.ddcode.model.Order;
import com.ddcode.model.Product;
import com.ddcode.order.service.OrderService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.Date;

@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    private RestTemplate restTemplate;

    @Override
    public Order getOrderById(Integer id) {

        Product product = restTemplate.getForObject("http://gateway-product/product/get/1", Product.class);
        return Order.builder().id(1).userName("jack").createTime(new Date()).product(product).build();
    }
}
