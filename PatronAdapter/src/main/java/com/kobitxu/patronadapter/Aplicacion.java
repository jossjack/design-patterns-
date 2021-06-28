/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kobitxu.patronadapter;

import com.kobitxu.patronadapter.adapter.impl.BankCreditRequest;
import com.kobitxu.patronadapter.adapter.impl.BankCreditResponse;
import com.kobitxu.patronadapter.adapter.impl.IBankAdapter;
import com.kobitxu.patronadapter.adapter.impl.XBankCreditAdaptee;
import com.kobitxu.patronadapter.adapter.impl.YBankCreditAdaptee;

/**
 *
 * @author joseph
 */
public class Aplicacion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BankCreditRequest request = new BankCreditRequest();
        request.setCustomer("Joseph Reyes");
        request.setAmount(1000);

        IBankAdapter xBank = new XBankCreditAdaptee();
        BankCreditResponse xresponse = xBank.sendCreditRequest(request);
        System.out.println("XBank approved > " + xresponse.isApproved());

        IBankAdapter yBank = new YBankCreditAdaptee();
        BankCreditResponse yresponse = yBank.sendCreditRequest(request);
        System.out.println("YBank approved > " + yresponse.isApproved());

        if (xresponse.isApproved()) {
            System.out.println("XBank aprobo su credito, felicidades !!");
        } else if (yresponse.isApproved()) {
            System.out.println("YBank aprobo su credito, felicidades !!");
        } else {
            System.out.println("lo sentimos su credito no ha sido aprobado");
        }
    }
}
