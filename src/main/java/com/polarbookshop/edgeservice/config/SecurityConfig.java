package com.polarbookshop.edgeservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

public class SecurityConfig {
    @Bean
    SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http){
        return http
                .authorizeExchange(exchange -> exchange.anyExchange().authenticated())
                .formLogin(Customizer.withDefaults()) // 스프링 보안 Customizer 인터페이스를 통해 제공되는 기본 설정
                .build();
    }
}
