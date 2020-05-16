package com.lls.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author lls
 * @date 2020/4/5 -12:37 PM
 */


//如果要扩展SpringMVC,官方建议这样做
@Configuration
public class mvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/index.html").setViewName("index");
        registry.addViewController("/main.html").setViewName("dashboard");
    }

    @Bean
    public LocaleResolver localeResolver() {
        return new MyLocaleResolve();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginHandlerInterceptor())
                .addPathPatterns("/**").excludePathPatterns("/index.html","/","/user/login");
    }
}
