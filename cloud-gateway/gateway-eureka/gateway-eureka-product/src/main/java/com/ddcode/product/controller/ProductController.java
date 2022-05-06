package com.ddcode.product.controller;

import com.ddcode.model.Product;
import com.ddcode.product.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/product")
@Slf4j
public class ProductController {

    @Resource
    private ProductService productService;

    @RequestMapping(value = "/get/{id}", produces={"application/json;charset=UTF-8"})
    public Product getProductById(@PathVariable("id") Integer id){
        log.info("id {} 开始访问 product-service", id);
        return productService.getProductById(id);
    }

    @RequestMapping(value = "/info", produces={"application/json;charset=UTF-8"})
    public Product info(@RequestParam("id") Integer id){
        log.info("id {} 开始访问 product-service info", id);
        return productService.getProductById(id);
    }

    @RequestMapping(value = "/getParam/{id}", produces={"application/json;charset=UTF-8"})
    public Product getProductByIdParam(@PathVariable("id") Integer id, @RequestParam("appFlag") String appFlag){
        log.info("id {} appFlag {} 开始访问 product-service", id, appFlag);
        return productService.getProductById(id);
    }
}
