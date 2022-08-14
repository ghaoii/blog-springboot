package com.ghaoi.blogspringboot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 全局配置文件
 */
@Configuration
public class AppConfig implements WebMvcConfigurer {
    /**
     * 配置拦截器和拦截规则
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**")// 拦截所有请求
                .excludePathPatterns("/**/*.html")
                .excludePathPatterns("/**/*.css")
                .excludePathPatterns("/**/*.js")
                .excludePathPatterns("**/user/login");// 排除接口
    }
}
