package com.jean.entity;

/**
 * Created by jean on 02.01.17.
 */
public enum Role {
    ADMIN, PREMIUM_MEMBER, MEMBER;

    public String authority() {
        return "ROLE_" + this.name();
    }
}
