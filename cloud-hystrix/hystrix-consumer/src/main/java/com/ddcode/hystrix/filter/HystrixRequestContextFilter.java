package com.ddcode.hystrix.filter;

import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@Component
@WebFilter(urlPatterns = "/")
@Slf4j
public class HystrixRequestContextFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        // 初始化 HystrixRequestContext
        HystrixRequestContext context = HystrixRequestContext.initializeContext();
        log.info("进入过滤器");
        // 继续过滤器
        try {
            chain.doFilter(request, response);
        } finally {
            // 销毁 HystrixRequestContext
            context.close();
        }
    }
}
