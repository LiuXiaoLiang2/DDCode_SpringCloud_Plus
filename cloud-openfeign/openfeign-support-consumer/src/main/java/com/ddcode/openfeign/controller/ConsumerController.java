package com.ddcode.openfeign.controller;

import com.ddcode.openfeign.pojo.User;
import com.ddcode.openfeign.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.Map;

@RestController
@Slf4j
public class ConsumerController {

    @Resource
    private OrderService orderService;

    @GetMapping("/openfeign/consumer/echo1")
    public String echo1(String name, String pwd) {
        String echo = orderService.echo1(name, pwd);
        log.info("echo {} ", echo);
        return echo;
    }

    @GetMapping("/openfeign/consumer/echo2")
    public String echo2(@RequestParam Map<String, Object> paramMap) {
        String echo = orderService.echo2(paramMap);
        log.info("echo {} ", echo);
        return echo;
    }

    @GetMapping("/openfeign/consumer/echo3")
    public String echo3(User user) {
        String echo = orderService.echo3(user);
        log.info("echo {} ", echo);
        return echo;
    }

    @PostMapping("/openfeign/consumer/echo4")
    public String echo4(User user) {
        String echo = orderService.echo4(user);
        log.info("echo {} ", echo);
        return echo;
    }

    @PostMapping("/openfeign/consumer/echo5")
    public String echo5(@RequestBody String userJson) {
        String echo = orderService.echo5(userJson);
        log.info("echo {} ", echo);
        return echo;
    }

    @PostMapping("/openfeign/consumer/echo6")
    public String echo6(@RequestPart(value = "file") MultipartFile file, @RequestParam(value= "name", required = false) String name) {
        String echo = orderService.echo6(file, name);
        log.info("echo {} ", echo);
        return echo;
    }

    @PostMapping("/openfeign/consumer/echo7")
    public String echo7(@RequestPart(value = "file") MultipartFile file, @RequestParam(value= "name", required = false) String name) {
        String echo = orderService.echo7(file, name);
        log.info("echo {} ", echo);
        return echo;
    }

    @PostMapping("/openfeign/consumer/echo8")
    public String echo8(String name, String pwd) {
        String echo = orderService.echo8(name, pwd);
        log.info("echo {} ", echo);
        return echo;
    }

    @PostMapping("/openfeign/consumer/echo9")
    public String echo9(User user) {
        String echo = orderService.echo9(user);
        log.info("echo9 {} ", echo);
        return echo;
    }
}
