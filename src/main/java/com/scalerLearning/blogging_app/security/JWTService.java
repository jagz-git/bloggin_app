package com.scalerLearning.blogging_app.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by Jagadesh Narayanaswamy on 02/02/24.
 * Author comment: JWT service class
 */
@Service
public class JWTService {

    //    some random key that acts as JWT key
//    Move the key to a safe place
//    TODO: Move it to a .properties file and not on git
    private static final String JWT_KEY = "jaeya123456dcbafdersgskjhshfgdsklsjdfnjksdsdkcjvbsd1231234124";
    private Algorithm algorithm = Algorithm.HMAC256(JWT_KEY);

    public String createJWT(Long userId) {
        return JWT.create()
                .withSubject(userId.toString())
                .withIssuedAt(new Date())
//                .withExpiresAt(new Date()) //TODO: set expiry date
                .sign(algorithm);
    }

    public Long retrieveUserId(String jwtString) {
        try {
            var decodeJWT = JWT.decode(jwtString);
            var userId = Long.valueOf(decodeJWT.getSubject());
            return userId;
        } catch (JWTDecodeException | NumberFormatException e) {
            throw new RuntimeException(e);
        }
    }

}
