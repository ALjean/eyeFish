package com.jean.config.security.jwt;

import com.jean.entity.User;

import java.util.Optional;

/**
 * Created by jean on 02.01.17.
 */
public interface UserService {
    Optional<User> getByUsername(String username);
}
