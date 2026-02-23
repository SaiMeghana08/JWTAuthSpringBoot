package com.JWT.demo.Configuration;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;

@Component
public class JwtUtil {
    private final SecretKey key;

    public JwtUtil(@Value("${jwt.secret}") String secret) {
        this.key = Keys.hmacShaKeyFor(
                Decoders.BASE64.decode(secret)
        );
    }

    // Generate JWT token
    public String generateToken(String username) {

        return Jwts.builder()
                .setSubject(username)             // "sub" claim
                .setIssuedAt(new Date())          // "iat" claim
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60)) // 1 hour expiry
                .signWith(key)                    // HMAC SHA256
                .compact();
    }
}
