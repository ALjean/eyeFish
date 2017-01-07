package com.jean.dao;

import com.jean.BaseTest;
import com.jean.CustomDfmException;
import com.jean.DaoDfmException;
import com.jean.entity.User;
import org.junit.Ignore;
import org.junit.Test;

/**
 * Created by jean on 10.01.16.
 */
public class UserDaoTest extends BaseTest {

    @Test
    @Ignore
    public void getUserByEmailTest() throws DaoDfmException {
        User user = null;//userDao.getUserByEmail("mail@mail.com");
        System.out.println(user);
    }
}
