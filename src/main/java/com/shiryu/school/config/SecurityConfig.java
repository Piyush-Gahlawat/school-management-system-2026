package com.shiryu.school.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.Customizer;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                // 1. Disable CSRF so H2 console POST requests work
                .csrf(csrf -> csrf.disable())

                // 2. Permit H2, Swagger, and Error pages
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/h2-console/**", "/swagger-ui/**", "/v3/api-docs/**", "/error").permitAll()
                        .anyRequest().authenticated())

                // 3. Disable frame options so H2 console can render in an iframe
                // (Note: This uses the new Spring Security 6 syntax)
                .headers(headers -> headers.frameOptions(frame -> frame.disable()))
                // 4. Use Basic Auth for testing API endpoints later
                .httpBasic(Customizer.withDefaults());

        return http.build();
    }
}