package com.jean.config.security.jwt.model.token;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.jsonwebtoken.Claims;

/**
 * Created by jean on 02.01.17.
 */
public final class AccessJwtToken implements JwtToken {
    private final String rawToken;
    @JsonIgnore
    private Claims claims;

    protected AccessJwtToken(final String token, Claims claims) {
        this.rawToken = token;
        this.claims = claims;
    }

    public String getToken() {
        return this.rawToken;
    }

    public Claims getClaims() {
        return claims;
    }
}