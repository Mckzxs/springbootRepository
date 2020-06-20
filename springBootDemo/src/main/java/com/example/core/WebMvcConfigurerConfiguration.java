package com.example.core;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

@Configuration//0--xml文件
public class WebMvcConfigurerConfiguration implements org.springframework.web.servlet.config.annotation.WebMvcConfigurer {

    /*//注册拦截器
    @Bean
    public LoginInterceptor loginInterceptor()
        return new LoginInterceptor();
    }
4
 /*   @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**")
                .allowedOrigins("*")
                .allowedMethods("POST", "GET", "PUT", "OPTIONS", "DELETE")
                .maxAge(3600)
                .allowCredentials(true);
    }
*/
 /*   //添加拦截器到spring mvc拦截器链
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //注册拦截器
        registry.addInterceptor(loginInterceptor()).addPathPatterns("/index");
    }*/


    // 静态资源处理
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").addResourceLocations("classpath:/resources/","classpath:/static/");
    }

}
