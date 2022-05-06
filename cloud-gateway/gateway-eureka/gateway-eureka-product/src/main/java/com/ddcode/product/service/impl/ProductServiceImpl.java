package com.ddcode.product.service.impl;

import com.ddcode.model.Product;
import com.ddcode.product.service.ProductService;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Override
    public Product getProductById(Integer id) {
        return Product.builder().id(1).desc("Iphone 11").price(11.0).build();
    }
}
