package com.fpt.test.topic1.security;

import com.fpt.test.topic1.service.impl.UserDetailsImpl;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Map;

/**
 * @author : Admin
 * @created : 11-Aug-21
 **/
@Component
public class JwtTokenManager {

    private final String SECRET = "fpt_test";

    private final long EXPIRATION = 43200;

    public String generateToken(UserDetails userDetails) {
        Date now = new Date();
        Claims claims = Jwts.claims().setSubject(userDetails.getUsername());
        claims.put("auth", userDetails.getAuthorities());
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(now)
                .setExpiration(new Date(now.getTime() + EXPIRATION * 60 * 1000))
                .signWith(SignatureAlgorithm.HS256, SECRET)
                .compact();
    }

    public String getUserFromJwt(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(SECRET)
                .parseClaimsJws(token)
                .getBody();

        return claims.getSubject();
    }
}
