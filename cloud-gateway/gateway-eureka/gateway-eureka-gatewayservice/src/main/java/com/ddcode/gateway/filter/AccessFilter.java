package com.ddcode.gateway.filter;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

/**
 * 权限认证过滤器
 */
@Component
@Slf4j
public class AccessFilter implements GlobalFilter, Ordered {


    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("进入全局权限认证过滤器");
        //获取请求参数
        String token = exchange.getRequest().getQueryParams().getFirst("token");
        if(token == null){
            log.info("进入全局权限认证过滤器, token is null");
            ServerHttpResponse response = exchange.getResponse();
            response.getHeaders().add("Content-Type", "application/json;charset=utf-8");
            response.setStatusCode(HttpStatus.UNAUTHORIZED);
            //设置响应内容
            Map<String, String> result = new HashMap<>();
            result.put("msg", "没有token");
            DataBuffer buffer = response.bufferFactory().wrap(JSON.toJSONBytes(result));
            return response.writeWith(Mono.just(buffer));
        }

        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
