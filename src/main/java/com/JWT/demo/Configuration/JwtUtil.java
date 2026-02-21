package com.JWT.demo.Configuration;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.util.Date;

public class JwtUtil {

    private static String secretKey = "ZmFrZXNlY3JldGtleTEyMzQ1"; // Base64 encoded

    // Generate JWT token
    public static String generateToken(String username) {

        SecretKey key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(secretKey));

        return Jwts.builder()
                .setSubject(username)             // "sub" claim
                .setIssuedAt(new Date())          // "iat" claim
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60)) // 1 hour expiry
                .signWith(key)                    // HMAC SHA256
                .compact();
    }
}
