package com.scalerLearning.blogging_app.security;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationConverter;

/**
 * Created by Jagadesh Narayanaswamy on 02/02/24.
 * Author comment:
 */

public class JWTAuthenticationConverter implements AuthenticationConverter {

    @Override
    public Authentication convert(HttpServletRequest request) {
        var authHeader = request.getHeader("Authorization");

        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            return null;
        }
        var jwt = authHeader.substring(7);
        return new JWTAuthentication(jwt);
    }

}
