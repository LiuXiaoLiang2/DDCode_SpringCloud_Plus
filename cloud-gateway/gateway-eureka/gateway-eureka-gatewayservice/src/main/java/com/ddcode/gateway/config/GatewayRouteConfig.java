package com.ddcode.gateway.config;

import com.ddcode.gateway.filter.CustomerGatewayFilter;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayRouteConfig {

    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder routeLocatorBuilder) {
        RouteLocator build = routeLocatorBuilder.routes().route(r -> r
                .path("/product/**")
                .uri("lb://gateway-product")
                .filters(new CustomerGatewayFilter())
                .id("gateway-product"))
                .build();
        return build;
    }
}
