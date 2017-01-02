package com.jean.config.security.jwt.auth.jwt.verifier;

import org.springframework.stereotype.Component;

/**
 * Created by jean on 02.01.17.
 */
@Component
public class BloomFilterTokenVerifier implements TokenVerifier {
    @Override
    public boolean verify(String jti) {
        return true;
    }
}