package com.gmalheiro.tasks.taskify_api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.ignoringRequestMatchers("/api/tasks/**"))
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/api/tasks/**").permitAll()
                        .anyRequest().authenticated());
        return http.build();
    }
}
