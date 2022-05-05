package com.ddcode.openfeign.support;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.FeignClientsConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class FeignMultipartSupportConfig extends FeignClientsConfiguration {
	
	@Autowired
	private ObjectFactory<HttpMessageConverters> messageConverters;
	
//	@Bean
//	@Primary
//	@Scope("prototype")
//	public Encoder multipartFormEncoder() {
//		return new FeignSpringFormEncoder();
//	}
//    @Bean
//    public Contract feignConfiguration(){
//        return new feign.Contract.Default();
//    }
    @Bean
    public feign.Logger.Level multipartLoggerLevel() {
        return feign.Logger.Level.NONE;
    }
    
	@Bean
	@Primary
	public CustomFormEncoder customFormEncoder() {
		return new CustomFormEncoder(new CustomSpringEncoder(this.messageConverters));
	}
}
