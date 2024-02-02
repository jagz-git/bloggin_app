package com.scalerLearning.blogging_app.security;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Created by Jagadesh Narayanaswamy on 02/02/24.
 * Author comment:
 */

public class JWTServiceTest {

    JWTService jwtService = new JWTService();

    @Test
    void canCreateJWTFromUSerId() {
        var jwt = jwtService.createJWT(108L);
        assertNotNull(jwt);

    }

}
