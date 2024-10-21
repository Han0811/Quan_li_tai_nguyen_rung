package com.project.forest_resource_management.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
public class Webconfig implements WebMvcConfigurer {
    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        return resolver;
    }
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Cho phép mọi đường dẫn
                .allowedOrigins("http://localhost:63342") // Cho phép từ origin cụ thể
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Cho phép các phương thức
                .allowedHeaders("*") // Cho phép tất cả các headers
                .allowCredentials(true); // Cho phép cookies
    }
}
