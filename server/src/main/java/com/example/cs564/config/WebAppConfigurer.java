package com.example.cs564.config;

import com.example.cs564.utils.SysInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebAppConfigurer implements WebMvcConfigurer {
    @Bean
    public HandlerInterceptor getLoginInterceptor(){
        return new SysInterceptor();
    }

   /*@Override
    public void addInterceptors(InterceptorRegistry registry){
//        String[] patterns = new String[] { "/playlist/**","/match/**","/playlist_song/**"};
//        registry.addInterceptor(getLoginInterceptor())
//                .addPathPatterns(patterns);
    }

}
