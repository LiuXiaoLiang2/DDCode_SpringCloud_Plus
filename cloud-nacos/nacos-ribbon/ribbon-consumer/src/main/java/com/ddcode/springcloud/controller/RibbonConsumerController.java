package com.ddcode.springcloud.controller;

import com.alibaba.cloud.nacos.NacosDiscoveryProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
public class RibbonConsumerController {

    private static String BASE_URL = "ribbon-nacos-quickstart-provider";

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private NacosDiscoveryProperties nacosDiscoveryProperties;

    /**
     * 方式1
     * @return
     */
    @RequestMapping("/ribbon/quickstart/consumer1")
    public String orderConsumer1(){
        String forObject = restTemplate.getForObject("http://" + BASE_URL + "/ribbon/quickstart/provider", String.class);
        log.info("orderConsumer {}", forObject);
        log.info("nacosDiscoveryProperties {}", nacosDiscoveryProperties.getMetadata());
        return forObject;
    }


    @Resource
    private LoadBalancerClient loadBalancerClient;
    /**
     * 方式2
     * @return
     */
    @RequestMapping("/ribbon/quickstart/consumer2")
    public String orderConsumer2(){
        // <1> 获得服务 `demo-provider` 的一个实例
        ServiceInstance instance;
        //负载均衡选择节点
        instance = loadBalancerClient.choose(BASE_URL);
        // <2> 发起调用
        if (instance == null) {
            throw new IllegalStateException("获取不到实例");
        }
        String targetUrl = instance.getUri() + "/ribbon/quickstart/provider";
        //这种方式不能使用有 @LoadBalanced 注解的 restTemplate
        //我们新new一个 restTemplate
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(targetUrl, String.class);
        return response;
    }
}
