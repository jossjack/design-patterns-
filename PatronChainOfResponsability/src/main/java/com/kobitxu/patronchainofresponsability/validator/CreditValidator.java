/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kobitxu.patronchainofresponsability.validator;

import com.kobitxu.patronchainofresponsability.domain.CreditData;
import com.kobitxu.patronchainofresponsability.domain.order.AbstractOrder;

/**
 *
 * @author joseph
 */
public class CreditValidator extends AbstractOrderValidator {

    @Override
    public void validate(AbstractOrder order) throws ValidationException {
        double total = order.getTotal();
        CreditData creditData = order.getContributor().getCreditData();
        double newBalance = creditData.getBalance() + total;
        if (newBalance > creditData.getCreditLimit()) {
            throw new ValidationException("The amount of the order  "
                    + "exceeds the available credit limit");
        }
    }
}
