package com.jean.service;


/**
 * Created by jean on 10.01.16.
 */
public interface UserService {

    boolean authenticate(String email, String password) throws Exception;
    String generateToken();
}
