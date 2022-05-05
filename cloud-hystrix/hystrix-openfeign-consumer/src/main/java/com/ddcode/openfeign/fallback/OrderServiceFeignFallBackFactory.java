package com.ddcode.openfeign.fallback;

import com.ddcode.openfeign.service.OpenFeignService;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class OrderServiceFeignFallBackFactory implements FallbackFactory<OpenFeignService>{

    @Override
    public OpenFeignService create(Throwable throwable) {

        return new OpenFeignService(){
            @Override
            public String hystrixOpenfeign(String name) {
                log.info("openFeign进入兜底方法 name {}", name);
                return "进入兜底方法 name:" + name;
            }
        };
    }
}
