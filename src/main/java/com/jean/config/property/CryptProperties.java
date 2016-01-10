package com.jean.config.property;

import org.springframework.stereotype.Component;

/**
 * Created by jean on 10.01.16.
 */
@Component
public class CryptProperties {

    private String algorithm = "AES";
    private String secretKey = "gTn1IRSebt51tyKe"; // key word must be 16 symbol
    private String unCodeFormat = "UTF8";


    public String getAlgorithm() {
        return algorithm;
    }

    public void setAlgorithm(String algorithm) {
        this.algorithm = algorithm;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public String getUnCodeFormat() {
        return unCodeFormat;
    }

    public void setUnCodeFormat(String unCodeFormat) {
        this.unCodeFormat = unCodeFormat;
    }
}
