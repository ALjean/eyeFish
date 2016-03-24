package com.jean.service;

import com.jean.CustomDfmException;

public interface TokenService {

    String getToken(String username, String password) throws CustomDfmException;
}
