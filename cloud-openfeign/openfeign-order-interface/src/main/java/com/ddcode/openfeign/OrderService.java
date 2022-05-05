package com.ddcode.openfeign;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

public interface OrderService {
    @GetMapping("/echo")
    String echo(@RequestParam("name") String name);
}
