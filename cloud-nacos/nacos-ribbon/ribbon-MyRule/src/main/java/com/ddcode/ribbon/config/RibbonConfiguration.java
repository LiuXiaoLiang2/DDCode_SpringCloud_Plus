package com.ddcode.ribbon.config;

import com.ddcode.myrule.DefaultRibbonClientConfiguration;
import com.ddcode.myrule.MyRibbonClientConfiguration;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@RibbonClients(value = {@RibbonClient(name = "ribbon-nacos-quickstart-provider", configuration = MyRibbonClientConfiguration.class)},
                defaultConfiguration = DefaultRibbonClientConfiguration.class
)
public class RibbonConfiguration {
}
