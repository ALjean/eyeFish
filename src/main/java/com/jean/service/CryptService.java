package com.jean.service;


/**
 * Created by jean on 10.01.16.
 */
public interface CryptService {

    String crypt(String password) throws Exception;
    String decrypt(String password) throws Exception;
    Boolean compere(String password) throws Exception;

}
