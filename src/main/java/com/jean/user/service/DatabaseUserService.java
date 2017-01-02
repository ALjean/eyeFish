package com.jean.user.service;



import com.jean.DaoDfmException;
import com.jean.config.security.jwt.UserService;
import com.jean.dao.UserDao;
import com.jean.entity.User;
import com.jean.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by jean on 02.01.17.
 */
@Service
public class DatabaseUserService implements UserService {
//    private final UserRepository userRepository;
    private final UserDao userDao;

    @Autowired
    public DatabaseUserService(UserDao userDao) {
        this.userDao = userDao;
//        this.userRepository = userRepository;
    }

/*    public UserRepository getUserRepository() {
        return userRepository;
    }*/

    @Override
    public Optional<User> getByUsername(String username) {
        Optional<User> user = null;
        try {
            user = this.userDao.getUserByEmail(username);
        } catch (DaoDfmException e) {
            e.printStackTrace();
        }
        return user;
    }
}

