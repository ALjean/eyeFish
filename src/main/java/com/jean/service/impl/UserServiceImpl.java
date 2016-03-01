package com.jean.service.impl;

import com.jean.CustomDfmException;
import com.jean.dao.UserDao;
import com.jean.entity.User;
import com.jean.service.CryptService;
import com.jean.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.security.SecureRandom;

/**
 * Created by jean on 10.01.16.
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;


    @Override
    public User getUserByEmail(String email) {
        User user = null;
        try {
            user = userDao.getUserByEmail(email);
        } catch (CustomDfmException e) {
            e.printStackTrace();
        }
        return user;
    }
}
