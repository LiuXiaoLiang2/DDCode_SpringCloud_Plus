package com.ddcode.openfeign.service;

import com.ddcode.openfeign.OrderService;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "openfeign-order-producer")
public interface OrderFeignService extends OrderService {
}
