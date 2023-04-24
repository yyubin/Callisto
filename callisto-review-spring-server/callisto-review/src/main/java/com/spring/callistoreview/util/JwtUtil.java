package com.spring.callistoreview.util;

import com.spring.callistoreview.exception.JwtValidationException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

import java.nio.charset.StandardCharsets;
import java.security.Key;

public class JwtUtil {
    private static final String SECRET_KEY = "secret-key";

    public static String extractProfileIdFromJwt(String jwtToken) throws JwtValidationException {
        try {
            Key key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes(StandardCharsets.UTF_8));
            Jws<Claims> jws = Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(jwtToken);
            Claims claims = jws.getBody();
            String profileId = claims.get("loginInfo", String.class);

            if (profileId == null) {
                throw new JwtValidationException("Profile Id not found in JWT");
            }
            return profileId;
        } catch (Exception e) {
            throw new JwtValidationException("Failed to extract login info from JWT", e);
        }
    }
}
