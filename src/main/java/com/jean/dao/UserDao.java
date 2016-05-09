package com.jean.dao;

import com.jean.DaoDfmException;
import com.jean.entity.User;

/**
 * Created by jean on 10.01.16.
 */
public interface UserDao {

    User getUserByEmail(String email) throws DaoDfmException;
}
