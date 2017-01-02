package com.jean.config.security.jwt.model;

/**
 * Created by jean on 02.01.17.
 */
public enum Scopes {
    REFRESH_TOKEN;

    public String authority() {
        return "ROLE_" + this.name();
    }
}