package com.ddcode.hystrix.controller;

import com.ddcode.hystrix.service.HystrixCacheService;
import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class HystrixCacheController {

    @Resource
    private HystrixCacheService hystrixCacheService;

    @RequestMapping("/hystrix/cache/getUser")
    public String getUser(Integer id){
        //一个请求内多次调用
        String user1 = hystrixCacheService.getUser(id);
        String user2 = hystrixCacheService.getUser(id);
        String user3 = hystrixCacheService.getUser(id);
        return user1;
    }

    @RequestMapping("/hystrix/cache/updateUser")
    public String updateUser(Integer id){
        String user1 = hystrixCacheService.getUser(id);
        //清除缓存
        hystrixCacheService.updateUser(id);
        String user2 = hystrixCacheService.getUser(id);
        return user2;
    }
}
