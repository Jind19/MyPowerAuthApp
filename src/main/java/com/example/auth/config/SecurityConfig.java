package com.example.auth.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain  securityFilterChain(HttpSecurity httpSecurity)  throws Exception{
        httpSecurity
                .authorizeHttpRequests( auth -> auth
                        .requestMatchers("/","/login").permitAll()
                        .anyRequest().authenticated()
                )
                .oauth2Login(oauth2 -> oauth2
                        .loginPage("/my_login")
                        .defaultSuccessUrl("/dashboard", true)
                ); // enables Google login
        return httpSecurity.build();
    }
}
