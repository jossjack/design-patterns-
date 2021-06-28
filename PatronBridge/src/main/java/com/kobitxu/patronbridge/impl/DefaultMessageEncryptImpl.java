/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kobitxu.patronbridge.impl;

import com.kobitxu.patronbridge.encript.IEncryptAlgorithm;

/**
 *
 * @author joseph
 */
public class DefaultMessageEncryptImpl implements IMessageEncrypt {

    private final IEncryptAlgorithm encryptAlgorith;

    public DefaultMessageEncryptImpl(IEncryptAlgorithm encryptAlgorith) {
        this.encryptAlgorith = encryptAlgorith;
    }

    @Override
    public String encryptMessage(String message, String password) throws Exception {
        return encryptAlgorith.encrypt(message, password);
    }
}
