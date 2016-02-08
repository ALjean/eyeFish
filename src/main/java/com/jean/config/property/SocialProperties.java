package com.jean.config.property;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SocialProperties {

    @Value("${facebook.api.key}")
    private String facebookKey = "227404384266033";

    @Value("${facebook.api.secret}")
    private String secret = "1f407cff8e1b794cacf4d0300969feb7";


    public String getFacebookKey() {
        return facebookKey;
    }

    public void setFacebookKey(String facebookKey) {
        this.facebookKey = facebookKey;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }
}
