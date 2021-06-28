/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kobitxu.patronadapter.adapter.impl;

import com.kobitxu.patronadapter.api.banky.YBankCreditAppoveResult;
import com.kobitxu.patronadapter.api.banky.YBankCreditApprove;
import com.kobitxu.patronadapter.api.banky.YBankCreditSender;
import com.kobitxu.patronadapter.api.banky.YBankCreditSenderListener;

/**
 *
 * @author joseph
 */
public class YBankCreditAdaptee implements IBankAdapter, YBankCreditSenderListener {

    private YBankCreditAppoveResult yresponse;

    @Override
    public BankCreditResponse sendCreditRequest(BankCreditRequest request) {
        YBankCreditApprove yrequest = new YBankCreditApprove();
        yrequest.setCredit((float) request.getAmount());
        yrequest.setName(request.getCustomer());

        YBankCreditSender sender = new YBankCreditSender();
        sender.sendCreditForValidate(yrequest, this);

        do {
            try {
                Thread.sleep(10000);
                System.out.println("YBank peticion en espera ...");
            } catch (InterruptedException e) {
            }
        } while (yresponse == null);

        BankCreditResponse response = new BankCreditResponse();
        response.setApproved(("Y".equals(yresponse.getApproved())));
        return response;
    }

    @Override
    public void notifyCreditResult(YBankCreditAppoveResult result) {
        this.yresponse = result;
    }
}
