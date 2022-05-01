package com.ddcode.cloud.controller;

import com.ddcode.cloud.config.OrderProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
// 自动刷新配置
@RefreshScope
public class NacosConfigController {

    @Value(value = "${order.pay-timeout-seconds}") // @NacosValue(value = "${order.pay-timeout-seconds}")
    private Integer payTimeoutSeconds;
    @Value(value = "${order.create-frequency-seconds}") // @NacosValue(value = "${order.create-frequency-seconds}")
    private Integer createFrequencySeconds;

    @GetMapping("/test01")
    public String test01() {
        log.info("payTimeoutSeconds {}, createFrequencySeconds {}", payTimeoutSeconds, createFrequencySeconds);
        return payTimeoutSeconds + ", " + createFrequencySeconds;
    }

    @Resource
    private OrderProperties orderProperties;
    @GetMapping("/test02")
    public OrderProperties test02() {
        log.info("orderProperties {}", orderProperties);
        return orderProperties;
    }

    @GetMapping("/test")
    public String  test() {
        log.info("orderProperties {}", orderProperties);
        log.info("payTimeoutSeconds {}, createFrequencySeconds {}", payTimeoutSeconds, createFrequencySeconds);
        return "ok";
    }
}
