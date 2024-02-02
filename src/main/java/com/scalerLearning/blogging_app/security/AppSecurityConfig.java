package com.scalerLearning.blogging_app.security;

import com.scalerLearning.blogging_app.users.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AnonymousAuthenticationFilter;

/**
 * Created by Jagadesh Narayanaswamy on 02/02/24.
 * Author comment: Spring security custom implementation class
 */

@Configuration
@EnableWebSecurity
public class AppSecurityConfig {

    private JWTAuthenticationFilter jwtAuthenticationFilter;
    private JWTService jwtService;
    private UserService userService;

    public AppSecurityConfig(JWTService jwtService, UserService userService) {
        this.jwtAuthenticationFilter = new JWTAuthenticationFilter(new JWTAuthenticationManager(jwtService, userService));
        this.jwtService = jwtService;
        this.userService = userService;
    }

    @Bean
    JWTAuthenticationFilter jwtAuthenticationFilter() throws Exception {
        return new JWTAuthenticationFilter(
                new JWTAuthenticationManager(jwtService, userService)
        );
    }

//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
//
//        httpSecurity
//                .authorizeHttpRequests(
//                        (requests) -> requests
//                                .requestMatchers(HttpMethod.POST, "/", "/users", "/users/login")
//                                .permitAll()
//                                .requestMatchers(HttpMethod.GET)
//                                .permitAll())
//                .csrf(AbstractHttpConfigurer::disable);
//    }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeRequests(authorizeRequests -> authorizeRequests.anyRequest()
                        .permitAll())
                .csrf(AbstractHttpConfigurer::disable);
        http.addFilterBefore(jwtAuthenticationFilter, AnonymousAuthenticationFilter.class);
        return http.build();
    }

}
