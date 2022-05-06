package com.ddcode.gateway.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.support.ServerWebExchangeUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.util.MultiValueMap;
import reactor.core.publisher.Mono;

@Configuration
@Slf4j
public class KeyResolverConfiguration {

    @Bean
    public KeyResolver pathKeyResolver(){
        // 方式2
        return exchange -> {
            Route route = exchange.getAttribute(ServerWebExchangeUtils.GATEWAY_ROUTE_ATTR);
            log.info("限流规则 id {} ", route.getId());
            return Mono.just(exchange.getRequest().getURI().getPath());
        };
    }


    @Primary
    @Bean
    public KeyResolver paramKeyResolver(){
        // 方式2
        return exchange -> {
            Route route = exchange.getAttribute(ServerWebExchangeUtils.GATEWAY_ROUTE_ATTR);
            log.info("限流规则 id {} ", route.getId());
            String userName = exchange.getRequest().getQueryParams().getFirst("userName");
            if(userName != null){
                return Mono.just(exchange.getRequest().getQueryParams().getFirst("userName"));
            } else {
                return Mono.just("");
            }
        };
    }
}
