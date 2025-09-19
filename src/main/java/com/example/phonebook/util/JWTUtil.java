package com.example.phonebook.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JWTUtil {
    @Value("${jwt.secret}")
    private String secret;

    private static final long EXPIRATION_TIME = 864_000_000; // 10 dias

    public String generateToken(String username) {
        return JWT.create()
                .withSubject(username)
                .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .sign(Algorithm.HMAC512(secret.getBytes()));
    }

    public String validateToken(String token) {
        try {
            return JWT.require(Algorithm.HMAC512(secret.getBytes()))
                    .build()
                    .verify(token)
                    .getSubject();

        } catch (Exception e ){
            return null;
        }
    }
}
