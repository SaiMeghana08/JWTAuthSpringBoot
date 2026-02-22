package com.JWT.demo.Configuration;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.util.Date;

public class JwtUtil {

    private static final SecretKey secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS256); // Base64 encoded

    // Generate JWT token
    public static String generateToken(String username) {

        return Jwts.builder()
                .setSubject(username)             // "sub" claim
                .setIssuedAt(new Date())          // "iat" claim
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60)) // 1 hour expiry
                .signWith(secretKey)                    // HMAC SHA256
                .compact();
    }
}
