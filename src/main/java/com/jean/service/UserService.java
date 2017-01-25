package com.jean.service;


import com.jean.dao.entity.user.User;

import java.util.Optional;

/**
 * Created by jean on 10.01.16.
 */
public interface UserService {

    Optional<User> getUserByEmail(String email);
}

/*
package com.jean.config.security.jwt;


        import com.jean.dao.entity.user.User;

        import java.util.Optional;

*/
/**
 * Created by jean on 02.01.17.
 *//*

public interface UserService {
    Optional<User> getByUsername(String username);
}
*/
