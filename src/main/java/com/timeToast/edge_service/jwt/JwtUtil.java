package com.timeToast.edge_service.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Base64;

@Component
public class JwtUtil {

    private final String jwtKey;

    public JwtUtil(@Value("${spring.jwt.key}") String jwtKey) {
        this.jwtKey = jwtKey;
    }

    public Claims validateToken(String token) throws JwtException {
        SecretKey tokenKey = Keys.hmacShaKeyFor(Base64.getDecoder().decode(jwtKey));
        Jws<Claims> claims = Jwts.parserBuilder().setSigningKey(tokenKey).build().parseClaimsJws(token);

        return claims.getBody();
    }
}
