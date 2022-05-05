package com.ddcode.openfeign.service;

import com.ddcode.openfeign.OrderService;
import com.ddcode.openfeign.fallback.OrderServiceFeignFallBackFactory;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "hystrix-openfeign-order-producer", fallbackFactory = OrderServiceFeignFallBackFactory.class)
public interface OpenFeignService extends OrderService {
}
