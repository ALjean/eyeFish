/*
package com.jean.user.service;



import com.jean.DaoDfmException;

import com.jean.dao.entity.user.User;
import com.jean.dao.repository.UserRepository;

import com.jean.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

*/
/**
 * Created by jean on 02.01.17.
 *//*

@Service
public class DatabaseUserService implements UserService {
//    private final UserRepository userRepository;
    private final UserRepository userRepository;

    @Autowired
    public DatabaseUserService(UserRepository userDao) {
        this.userRepository = userDao;
//        this.userRepository = userRepository;
    }

*/
/*    public UserRepository getUserRepository() {
        return userRepository;
    }*//*


    @Override
    public Optional<User> getByUsername(String username) {
        Optional<User> user = null;
        try {
            user = this.userRepository.getUserByEmail(username);
        } catch (DaoDfmException e) {
            e.printStackTrace();
        }
        return user;
    }
}

*/
