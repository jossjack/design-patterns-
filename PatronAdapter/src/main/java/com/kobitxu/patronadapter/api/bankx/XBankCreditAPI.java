/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kobitxu.patronadapter.api.bankx;

/**
 *
 * @author joseph
 */
public class XBankCreditAPI {

    public XBankCreditResponse sendCreditRequest(XBankCreditRequest request) {
        XBankCreditResponse response = new XBankCreditResponse();
        if (request.getRequestAmount() <= 5000) {
            response.setApproval(true);
        } else {
            response.setApproval(false);
        }
        return response;
    }
}
