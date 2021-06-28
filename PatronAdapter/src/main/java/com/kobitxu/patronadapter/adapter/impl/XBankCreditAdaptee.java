/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kobitxu.patronadapter.adapter.impl;

import com.kobitxu.patronadapter.api.bankx.XBankCreditAPI;
import com.kobitxu.patronadapter.api.bankx.XBankCreditRequest;
import com.kobitxu.patronadapter.api.bankx.XBankCreditResponse;

/**
 *
 * @author joseph
 */
public class XBankCreditAdaptee implements IBankAdapter {

    @Override
    public BankCreditResponse sendCreditRequest(BankCreditRequest request) {
        XBankCreditRequest xrequest = new XBankCreditRequest();
        xrequest.setCustomerName(request.getCustomer());
        xrequest.setRequestAmount(request.getAmount());

        XBankCreditAPI api = new XBankCreditAPI();
        XBankCreditResponse xresponse = api.sendCreditRequest(xrequest);

        BankCreditResponse response = new BankCreditResponse();
        response.setApproved(xresponse.isApproval());
        return response;
    }
}
