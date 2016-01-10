package com.jean.service.impl;

import com.jean.config.property.CryptProperties;
import com.jean.service.CryptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;


/**
 * Created by Stas on 10.01.16.
 */
@Service
public class CryptServiceImpl implements CryptService {

    @Autowired
    CryptProperties cryptProperties;

    @Override
    public String crypt(String password) throws Exception {
        byte[] encValue = getCipher(Cipher.ENCRYPT_MODE).doFinal(password.getBytes());
        return new BASE64Encoder().encode(encValue);
    }

    @Override
    public String decrypt(String password) throws Exception {
        byte[] decordedValue = new BASE64Decoder().decodeBuffer(password);
        byte[] decValue = getCipher(Cipher.DECRYPT_MODE).doFinal(decordedValue);
        return new String(decValue);
    }

    @Override
    public Boolean compere(String password) throws Exception {
        return null;
    }


    private Cipher getCipher(int mode) throws Exception{
        byte[] keyAsBytes = cryptProperties.getSecretKey().getBytes(cryptProperties.getUnCodeFormat());
        Key key =  new SecretKeySpec(keyAsBytes, cryptProperties.getAlgorithm());
        Cipher cipher = Cipher.getInstance(cryptProperties.getAlgorithm());
        cipher.init(mode, key);
        return cipher;
    }

}
