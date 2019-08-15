package com.example.cs564.config;

import com.example.cs564.utils.SysInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * This class is used for user authentication. Currently, lacking Spring Security
 * dependency, user authentication is implemented via jwt token and web interceptors. In the future,
 * we'll configure Spring Security and improve this functionality
 */

@Configuration
public class WebAppConfigurer implements WebMvcConfigurer {
    @Bean
    public HandlerInterceptor getLoginInterceptor(){
        return new SysInterceptor();
    }

    /**
     * Intercept routes "/playlist/**", "/match/**", "/playlist_song/**"
     * When hiting these routes, requires user token verification
     */
   /*@Override
    public void addInterceptors(InterceptorRegistry registry){
//        String[] patterns = new String[] { "/playlist/**","/match/**","/playlist_song/**"};
//        registry.addInterceptor(getLoginInterceptor())
//                .addPathPatterns(patterns);
    }*/

}
