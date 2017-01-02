package com.jean.config.security.jwt.model.token;

import com.jean.config.security.jwt.exceptions.JwtExpiredTokenException;
import io.jsonwebtoken.*;

import org.apache.log4j.Logger;
import org.springframework.security.authentication.BadCredentialsException;

/**
 * Created by jean on 02.01.17.
 */
public class RawAccessJwtToken implements JwtToken {

    private static Logger logger = Logger.getLogger(RawAccessJwtToken.class);

    private String token;

    public RawAccessJwtToken(String token) {
        this.token = token;
    }


    public Jws<Claims> parseClaims(String signingKey) {
        try {
            return Jwts.parser().setSigningKey(signingKey).parseClaimsJws(this.token);
        } catch (UnsupportedJwtException | MalformedJwtException | IllegalArgumentException | SignatureException ex) {
            logger.error("Invalid JWT Token", ex);
            throw new BadCredentialsException("Invalid JWT token: ", ex);
        } catch (ExpiredJwtException expiredEx) {
            logger.info("JWT Token is expired", expiredEx);
            throw new JwtExpiredTokenException(this, "JWT Token expired", expiredEx);
        }
    }

    @Override
    public String getToken() {
        return token;
    }
}