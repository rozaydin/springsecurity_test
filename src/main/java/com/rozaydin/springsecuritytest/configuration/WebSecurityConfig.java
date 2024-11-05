package com.rozaydin.springsecuritytest.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity(debug = true)
@EnableGlobalAuthentication
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        var cookieTokenRepository = CookieCsrfTokenRepository.withHttpOnlyFalse();

        return http
                .authorizeHttpRequests( auth -> auth.requestMatchers("/api/hello", "/api/bye", "/api/csrf").permitAll())
                .csrf(customizer -> {
                    customizer
                            .csrfTokenRepository(cookieTokenRepository)
                            .requireCsrfProtectionMatcher(AntPathRequestMatcher.antMatcher("/api/**"))
                            .ignoringRequestMatchers("/api/bye");
                } )
                .build();
    }
}
