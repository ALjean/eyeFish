package com.jean.config.security.jwt.auth.jwt.extractor;

/**
 * Created by jean on 02.01.17.
 */
public interface TokenExtractor {
    String extract(String payload);
}