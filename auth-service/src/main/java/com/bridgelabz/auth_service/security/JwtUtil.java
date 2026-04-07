package com.bridgelabz.auth_service.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtUtil {
//    private final Key SECRET_KEY = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    private static final String SECRET = "9fK3xZp!Q7mL2@vR8sW#cD4hTnY6uJ$e-QMA";

    private final Key SECRET_KEY = Keys.hmacShaKeyFor(SECRET.getBytes());
    private final long EXPIRATION_TIME = 1000 * 60 * 60;

    public String generateToken(String email) {
        return Jwts.builder().setSubject(email)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SECRET_KEY, SignatureAlgorithm.HS256)
                .compact();
    }

    public String extractEmail(String token) {
        return getClaims(token).getSubject();
    }

    public boolean validateToken(String token, String email) {
        return extractEmail(token).equals(email) && !isTokenExpired(token);
    }

    public boolean isTokenExpired(String token) {
        return getClaims(token).getExpiration().before(new Date());
    }

    public Claims getClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(SECRET_KEY)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}
