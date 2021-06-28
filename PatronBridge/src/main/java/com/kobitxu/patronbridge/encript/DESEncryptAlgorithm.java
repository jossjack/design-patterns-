/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kobitxu.patronbridge.encript;

import java.util.Base64;
import java.util.Base64.Encoder;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

/**
 *
 * @author joseph
 */
public class DESEncryptAlgorithm implements IEncryptAlgorithm {

    @Override
    public String encrypt(String message, String password) throws Exception {
        DESKeySpec dks = new DESKeySpec(message.getBytes());
        SecretKeyFactory skf = SecretKeyFactory.getInstance("DES");
        SecretKey desKey = skf.generateSecret(dks);
        Cipher desCipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
        desCipher.init(Cipher.ENCRYPT_MODE, desKey);

        Encoder base64encoder = Base64.getEncoder();
        return base64encoder.encodeToString(desCipher.doFinal(message.getBytes()));
    }
}
