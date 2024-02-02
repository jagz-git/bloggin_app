package com.scalerLearning.blogging_app.security;

import com.scalerLearning.blogging_app.users.UserService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * Created by Jagadesh Narayanaswamy on 02/02/24.
 * Author comment:
 */

public class JWTAuthenticationManager implements AuthenticationManager {

    private JWTService jwtService;
    private UserService userService;

    public JWTAuthenticationManager(JWTService jwtService, UserService userService) {
        this.jwtService = jwtService;
        this.userService = userService;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        if (authentication instanceof JWTAuthentication) {
            var jwtAuthentication = (JWTAuthentication) authentication;
            var jwt = jwtAuthentication.getCredentials();
            var userId = jwtService.retrieveUserId(jwt);
            var userEntity = userService.getUser(userId);

            jwtAuthentication.userEntity = userEntity;
            jwtAuthentication.setAuthenticated(true);
            return jwtAuthentication;
        }

        throw new IllegalAccessError("Cannot authenticate non-JWT authentication");

    }

}
