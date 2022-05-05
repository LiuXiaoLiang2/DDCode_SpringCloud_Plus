package com.ddcode.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {

//    @Bean
//    @LoadBalanced
//    public RestTemplate getRestTemplate(){
//        //设置restTemplate超时时间
//        HttpComponentsClientHttpRequestFactory httpRequestFactory = new HttpComponentsClientHttpRequestFactory();
//        httpRequestFactory.setConnectionRequestTimeout(50000);//单位毫秒
//        httpRequestFactory.setConnectTimeout(50000);
//        httpRequestFactory.setReadTimeout(50000);
//        return new RestTemplate(httpRequestFactory);
//    }


    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
