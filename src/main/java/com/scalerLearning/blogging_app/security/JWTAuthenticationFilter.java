package com.scalerLearning.blogging_app.security;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AuthenticationFilter;

/**
 * Created by Jagadesh Narayanaswamy on 02/02/24.
 * Author comment: JWT Authentication Filter
 */
public class JWTAuthenticationFilter extends AuthenticationFilter {

    private JWTAuthenticationManager jwtAuthenticationManager;

    public JWTAuthenticationFilter(JWTAuthenticationManager jwtAuthenticationManager) {
        super(jwtAuthenticationManager, new JWTAuthenticationConverter());
        this.setSuccessHandler(((request, response, authentication) -> {
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }));
    }

}
