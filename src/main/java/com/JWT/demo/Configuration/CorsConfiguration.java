package com.JWT.demo.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfiguration{
    @Bean
    public WebMvcConfigurer webconfigurer(){

        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
               registry.addMapping("/**")
                       .allowedHeaders("*")
                       .allowedMethods("GET","POST","DELETE","PUT","PATCH","OPTIONS")
                       .allowedOriginPatterns("*")
                       .allowCredentials(true);
            }
        };
    };
}
