/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kobitxu.patronadapter.api.banky;

/**
 *
 * @author joseph
 */
public class YBankCreditSender {

    public void sendCreditForValidate(final YBankCreditApprove request, final YBankCreditSenderListener listener) {
        new Thread(() -> {
            System.out.println("YBank recibio la solicitud en un momento y tendra la respuesta, sea paciente por favor");
            YBankCreditAppoveResult response = new YBankCreditAppoveResult();
            if (request.getCredit() <= 1500) {
                response.setApproved("Y");
            } else {
                response.setApproved("N");
            }

            try {
                Thread.sleep(1000 * 30);
            } catch (InterruptedException e) {
            }

            listener.notifyCreditResult(response);
        }).start();
    }
}
