/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kobitxu.patronbridge.encript;

/**
 *
 * @author joseph
 */
public class NoEncryptAlgorithm implements IEncryptAlgorithm {

    @Override
    public String encrypt(String message, String password) throws Exception {
        return message;

    }
}