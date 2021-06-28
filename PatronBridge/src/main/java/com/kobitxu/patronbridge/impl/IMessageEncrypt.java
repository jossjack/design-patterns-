/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kobitxu.patronbridge.impl;

/**
 *
 * @author joseph
 */
public interface IMessageEncrypt {

    public String encryptMessage(String message, String password) throws Exception;
}
