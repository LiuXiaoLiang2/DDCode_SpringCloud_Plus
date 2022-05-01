package com.ddcode.nacos.listener;

import com.alibaba.nacos.common.utils.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.jasypt.encryption.StringEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.environment.EnvironmentChangeEvent;
import org.springframework.cloud.context.environment.EnvironmentManager;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class JasyptEnvironmentChangeListener  implements ApplicationListener<EnvironmentChangeEvent> {

    // Environment 管理器，可以实现配置项的获取和修改
    @Autowired
    private EnvironmentManager environmentManager;

    // Jasypt 加密器，可以对配置项进行加密和加密
    @Autowired
    private StringEncryptor encryptor;

    @Override
    public void onApplicationEvent(EnvironmentChangeEvent event) {
        log.info("**********************哈哈哈哈, event.getKey {}" , event.getKeys());

        for (String key : event.getKeys()) {
            // 获得 value
            Object valueObj = environmentManager.getProperty(key);
            if (!(valueObj instanceof String)) {
                continue;
            }
            String value = (String) valueObj;
            // 判断 value 是否为加密。如果是，则进行解密
            if (value.startsWith("ENC(") && value.endsWith(")")) {
                value = encryptor.decrypt(StringUtils.substringBetween(value, "ENC(", ")"));
                log.info("[onApplicationEvent][key({}) 解密后为 {}]", key, value);
                // 设置到 Environment 中
                environmentManager.setProperty(key, value);
            }
        }
    }
}
