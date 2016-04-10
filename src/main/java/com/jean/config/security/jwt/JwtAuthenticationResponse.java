package com.jean.config.security.jwt;

/**
 * Created by jean on 10.04.16.
 */
public class JwtAuthenticationResponse {

    public JwtAuthenticationResponse(String token){
        this.token = token;
    }

    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
