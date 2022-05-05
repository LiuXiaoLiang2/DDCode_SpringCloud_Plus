package com.ddcode.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

/**
 * 自定义rule：可以针对某个特定的应用名
 */
public class MyRibbonClientConfiguration {
    @Bean
    @Primary
    public IRule ribbonCustomRule() {
        return new RandomRule();
    }
}
