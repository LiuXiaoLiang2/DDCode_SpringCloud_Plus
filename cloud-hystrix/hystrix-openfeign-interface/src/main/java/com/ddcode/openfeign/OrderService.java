package com.ddcode.openfeign;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

public interface OrderService {

    @GetMapping("/hystrix/openfeign/producer")
    String hystrixOpenfeign(@RequestParam("name") String name);
}
