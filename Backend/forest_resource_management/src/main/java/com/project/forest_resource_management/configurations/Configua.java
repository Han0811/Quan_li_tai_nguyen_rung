//package com.project.forest_resource_management.configurations;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//
////@EnableWebSecurity
//public class Configua {
////    @Bean
////    protected void configure(HttpSecurity http) throws Exception {
////        http
////                .authorizeRequests()
////                .requestMatchers("/admin/**").hasRole("ADMIN") // Chỉ cho phép role ADMIN truy cập vào /admin
////                .requestMatchers("/user/**").hasRole("USER")   // Chỉ cho phép role USER truy cập vào /user
////                .anyRequest().authenticated()                  // Các yêu cầu khác phải đăng nhập
////                .anyRequest().authenticated()              // Các yêu cầu khác phải đăng nhập
////                .and()
////                .formLogin()                               // Cấu hình form đăng nhập mặc định
////                .permitAll()
////                .and()
////                .logout()
////                .permitAll();
////    }
//}
