package com.ddcode.hystrix.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheRemove;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@Service
@Slf4j
public class HystrixCacheService {

    @Resource
    private RestTemplate restTemplate;

    /**
     * 增加缓存
     * @param id
     * @return
     */
    @HystrixCommand(fallbackMethod = "getUserFallback", commandProperties = {
            @HystrixProperty(name="requestCache.enabled",value = "true")
    })
    @CacheResult(cacheKeyMethod = "getUserCacheKeyMethod")
    public String getUser(Integer id){
        log.info("调用远程方法查询用户");
        ResponseEntity<String> responseEntity = restTemplate.getForEntity("http://127.0.0.1:6611/hystrix/producer/get?id=" + id, String.class);
        log.info("调用远程方法查询用户 , 结果 {}", responseEntity.getBody());
        return responseEntity.getBody();
    }


    public String getUserFallback(Integer id, Throwable throwable) {
        log.info("id {} 进入兜底方法, 抛异常 {}", id, throwable);
        return "id " + id + ", 进入兜底方法";
    }

    /**
     * 移除缓存
     * @param id
     * @return
     */
    @HystrixCommand
    @CacheRemove(commandKey = "getUser",cacheKeyMethod = "getUserCacheKeyMethod")
    public String updateUser(Integer id){
        return "update success";
    }

    /**
     * 设置缓存键的生成方法
     * @param id
     * @return
     */
    public String getUserCacheKeyMethod(Integer id){
        return "hystrix:cache:key:id:" + id;
    }
}
