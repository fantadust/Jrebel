package com.github.jrebel.core.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author fantadust (9677889@qq.com)
 * @description:
 * @date 2023/12/18 11:15
 */
@Slf4j
@Configuration
public class AppMvcConfigure implements WebMvcConfigurer {
    @Autowired
    private CommonInterceptor commonInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(commonInterceptor).addPathPatterns("/**");
    }
}
