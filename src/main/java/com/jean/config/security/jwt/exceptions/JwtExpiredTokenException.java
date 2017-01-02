package com.jean.config.security.jwt.exceptions;

import com.jean.config.security.jwt.model.token.JwtToken;
import org.springframework.security.core.AuthenticationException;

/**
 * Created by jean on 02.01.17.
 */
public class JwtExpiredTokenException extends AuthenticationException {
    private static final long serialVersionUID = -5959543783324224864L;

    private JwtToken token;

    public JwtExpiredTokenException(String msg) {
        super(msg);
    }

    public JwtExpiredTokenException(JwtToken token, String msg, Throwable t) {
        super(msg, t);
        this.token = token;
    }

    public String token() {
        return this.token.getToken();
    }
}
