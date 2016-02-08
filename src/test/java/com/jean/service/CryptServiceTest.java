package com.jean.service;

import com.jean.BaseTest;
import org.junit.Ignore;
import org.junit.Test;

/**
 * Created by jean on 10.01.16.
 */
public class CryptServiceTest extends BaseTest {

    @Test
    @Ignore
    public void cryptTest() throws Exception {
        String cryptValue = cryptService.crypt("123");
        System.out.println("---> " + cryptValue);
    }

    @Test
    @Ignore
    public void decryptTest() throws Exception {
        String decryptValue = cryptService.decrypt("+njbxjO/zR2YPS4UIHimjQ==");
        System.out.println("---> " + decryptValue);
    }
}
