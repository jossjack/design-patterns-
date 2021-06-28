/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kobitxu.patronbridge;

import com.kobitxu.patronbridge.encript.AESEncryptAlgorithm;
import com.kobitxu.patronbridge.encript.DESEncryptAlgorithm;
import com.kobitxu.patronbridge.encript.NoEncryptAlgorithm;
import com.kobitxu.patronbridge.impl.DefaultMessageEncryptImpl;
import com.kobitxu.patronbridge.impl.IMessageEncrypt;

/**
 *
 * @author joseph
 */
public class Aplicacion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        IMessageEncrypt aesImpl = new DefaultMessageEncryptImpl(new AESEncryptAlgorithm());
        IMessageEncrypt desImpl = new DefaultMessageEncryptImpl(new DESEncryptAlgorithm());
        IMessageEncrypt noImpl = new DefaultMessageEncryptImpl(new NoEncryptAlgorithm());

        try {
            final String message = "<Person><Name>Joseph Reyes Moreira</Name></Person>";
            String messageAES = aesImpl.encryptMessage(message, "HG58YZ3CR9123456");
            System.out.println("messageAES > " + messageAES + "\n");

            String messageDES = desImpl.encryptMessage(message, "XMzDdG4D03CKm2Ix");
            System.out.println("messageDES > " + messageDES + "\n");

            String messageNO = noImpl.encryptMessage(message, null);
            System.out.println("messageNO > " + messageNO + "\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
