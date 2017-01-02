package com.jean.config.security.jwt.exceptions;

import org.springframework.security.authentication.AuthenticationServiceException;

/**
 * Created by jean on 02.01.17.
 */
public class AuthMethodNotSupportedException extends AuthenticationServiceException {
    private static final long serialVersionUID = 3705043083010304496L;

    public AuthMethodNotSupportedException(String msg) {
        super(msg);
    }
}
