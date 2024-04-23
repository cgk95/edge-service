package com.polarbookshop.edgeservice.config;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Mono;

import java.security.Principal;

@Configuration
public class RateLimiterConfig {
    @Bean
    public KeyResolver keyResolver() {
        return exchange ->
                exchange.getPrincipal() // 현재 인증된 사용자(프린시플)를 현재 요청에서 가져온다
                        .map(Principal::getName) // 프린시플로부터 유저명을 추출
                        .defaultIfEmpty("anonymous"); // 요청이 인증되지 않았다면 기본 키 값을 사용

    }
}
