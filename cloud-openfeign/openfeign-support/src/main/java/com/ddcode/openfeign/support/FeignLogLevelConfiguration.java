package com.ddcode.openfeign.support;

import feign.Logger;
import org.springframework.cloud.openfeign.FeignClientsConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignLogLevelConfiguration extends FeignClientsConfiguration{

    @Bean
    public Logger.Level multipartLoggerLevel() {
        return Logger.Level.FULL;
    }
}
