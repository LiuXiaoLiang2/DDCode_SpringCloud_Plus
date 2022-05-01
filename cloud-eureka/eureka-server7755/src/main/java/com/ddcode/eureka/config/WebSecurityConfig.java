package com.ddcode.eureka.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //这个路径就是 http://eureka-server1:7745/eureka/
        http.csrf().ignoringAntMatchers("/eureka/**");
        super.configure(http);
    }
}
