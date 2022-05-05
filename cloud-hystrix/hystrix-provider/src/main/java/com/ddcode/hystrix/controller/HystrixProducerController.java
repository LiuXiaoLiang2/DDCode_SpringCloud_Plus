package com.ddcode.hystrix.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/hystrix/producer")
@Slf4j
public class HystrixProducerController {

    @GetMapping("/get")
    public String get(@RequestParam("id") Integer id) {
        log.info("id {} ,请求 get 方法", id);
        return "hystrix producer id:" + id;
    }

    @GetMapping("/batch/get")
    public List<String> batchGet(@RequestParam("ids") List<Integer> ids) {
        return ids.stream().map(id -> "User:" + id).collect(Collectors.toList());
    }
}
