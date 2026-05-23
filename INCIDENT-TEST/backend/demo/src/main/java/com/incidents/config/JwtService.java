package com.incidents.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import org.springframework.beans.factory.annotation.Value;

import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JwtService {

    @Value("${jwt.secret}")
    private String secret;

    private final long jwtExpiration =
            1000 * 60 * 60 * 24;

    public String generateToken(
            String email
    ) {

        return Jwts.builder()

                .setSubject(email)

                .setIssuedAt(
                        new Date(System.currentTimeMillis())
                )

                .setExpiration(
                        new Date(
                                System.currentTimeMillis()
                                        + jwtExpiration
                        )
                )

                .signWith(
                        SignatureAlgorithm.HS256,
                        secret
                )

                .compact();
    }

    public String extractUsername(
            String token
    ) {

        return extractAllClaims(token)
                .getSubject();
    }

    public boolean isTokenValid(
            String token
    ) {

        return !extractAllClaims(token)
                .getExpiration()
                .before(new Date());
    }

    private Claims extractAllClaims(
            String token
    ) {

        return Jwts.parser()

                .setSigningKey(secret)

                .parseClaimsJws(token)

                .getBody();
    }
}