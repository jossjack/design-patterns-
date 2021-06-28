/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kobitxu.patronbridge.encript;

import java.security.Key;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author joseph
 */
public class AESEncryptAlgorithm implements IEncryptAlgorithm {

    @Override
    public String encrypt(String message, String password) throws Exception {
        Key key = new SecretKeySpec(password.getBytes(), "AES");
        Cipher c = Cipher.getInstance("AES");

        c.init(Cipher.ENCRYPT_MODE, key);
        byte[] encVal = c.doFinal(message.getBytes());

        String encryptedValue = Base64.getEncoder().encodeToString(encVal);
        return encryptedValue;
    }
}
