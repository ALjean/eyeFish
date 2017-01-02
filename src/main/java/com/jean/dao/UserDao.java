package com.jean.dao;

import com.jean.DaoDfmException;
import com.jean.entity.User;

import java.util.Optional;

/**
 * Created by jean on 10.01.16.
 */
public interface UserDao {

    Optional<User> getUserByEmail(String email) throws DaoDfmException;
}
