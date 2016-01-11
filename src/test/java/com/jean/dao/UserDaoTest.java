package com.jean.dao;

import com.jean.BaseTest;
import com.jean.CustomDfmException;
import com.jean.entity.User;
import org.junit.Test;

/**
 * Created by jean on 10.01.16.
 */
public class UserDaoTest extends BaseTest {

    @Test
    public void getUserByEmailTest() throws CustomDfmException {
        User user = userDao.getUserByEmail("mail@mail.com");
        System.out.println(user);
    }
}
