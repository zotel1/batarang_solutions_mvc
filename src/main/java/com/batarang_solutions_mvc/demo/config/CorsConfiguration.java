package com.batarang_solutions_mvc.demo.config;

import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;

public class CorsConfiguration implements WebMvcAutoConfiguration {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://127.0.0.1:5501")
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS", "HEAD", "TRACE", "CONNECT");
    }
}
