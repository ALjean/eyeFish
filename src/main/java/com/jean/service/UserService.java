package com.jean.service;


import com.jean.entity.User;

/**
 * Created by jean on 10.01.16.
 */
public interface UserService {

    User getUserByEmail(String email);
}
