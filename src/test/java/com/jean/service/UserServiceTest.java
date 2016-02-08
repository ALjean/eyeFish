package com.jean.service;

import com.jean.BaseTest;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by jean on 10.01.16.
 */
public class UserServiceTest extends BaseTest {

    @Test
    @Ignore
    public void authenticateTest() throws Exception {
        boolean auth = userService.authenticate("mail@mail.com", "123");
        assertTrue(auth);
    }

    @Test
    @Ignore
    public void generateTokenTest(){
        String token = userService.generateToken();
        System.out.println(token);
    }
}
