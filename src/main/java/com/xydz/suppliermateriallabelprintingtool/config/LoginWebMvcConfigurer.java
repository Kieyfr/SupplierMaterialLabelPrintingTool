package com.xydz.suppliermateriallabelprintingtool.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

/**
 * @Author xiachenchen
 * @ClassName: LoginWebMvcConfigurer
 * @Description: 拦截器配置 TODO
 * @Date 2022/11/22
*/

@Component
@Configuration
public class LoginWebMvcConfigurer implements WebMvcConfigurer {

    @Resource
    private LoginHandlerInterceptor loginHandlerInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // addPathPatterns 用于添加拦截规则，/**表示拦截所有请求
        // excludePathPatterns 用户排除拦截

        registry.addInterceptor(loginHandlerInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/login")
                .excludePathPatterns("/getSuppName")
                .excludePathPatterns("/addSuppUser")
                .excludePathPatterns("/adminGetSuppNames");

    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")      // 设置映射
                .allowedOriginPatterns("*")        // 设置域
                .allowedMethods("*")               // 设置请求的方式GET、POST等
                .allowCredentials(true)            // 设置是否携带cookie
                .maxAge(3600)                      // 设置设置的有效期 秒单位
                .allowedHeaders("*");              // 设置头
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

//        registry.addResourceHandler()   // 静态映射
//                .addResourceLocations(); 文件在服务器的路径
    }
}

