package com.jean.config.security.jwt.auth.jwt.verifier;

/**
 * Created by jean on 02.01.17.
 */
public interface TokenVerifier {
    boolean verify(String jti);
}
