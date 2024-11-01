package com.nhnacademy.twojopingeureka.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

/**
 * Spring Security를 위한 설정 클래스입니다.
 * <p>
 *     이 클래스는 HTTP 보안을 설정하고, 모든 요청에 대해 인증을 요구합니다.
 * </p>
 *
 * @author : 정세희
 * @date : 2024-10-25
 */
@EnableWebSecurity
@Configuration
public class SecurityConfig {

    /**
     * 보안 필터 체인을 구성합니다.
     *
     * @param http HttpSecurity 객체로, 보안 설정을 구성하는 데 사용됩니다.
     * @return 구성된 SecurityFilterChain 객체
     * @throws Exception 보안 설정 중 발생할 수 있는 예외
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth -> auth.anyRequest().authenticated())
                .httpBasic(withDefaults());

        return http.build();
    }
}
