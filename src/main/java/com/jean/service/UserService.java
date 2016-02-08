package com.jean.service;


import com.jean.entity.User;

/**
 * Created by jean on 10.01.16.
 */
public interface UserService {

    @Deprecated
    boolean authenticate(String email, String password) throws Exception;

    @Deprecated
    String generateToken();

    User getUserByEmail(String email);
}
