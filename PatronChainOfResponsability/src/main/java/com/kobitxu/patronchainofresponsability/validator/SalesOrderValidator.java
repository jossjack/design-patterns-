/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kobitxu.patronchainofresponsability.validator;

import com.kobitxu.patronchainofresponsability.domain.order.AbstractOrder;
import com.kobitxu.patronchainofresponsability.domain.order.SalesOrder;

/**
 *
 * @author joseph
 */
public class SalesOrderValidator extends AbstractOrderValidator {

    @Override
    public void validate(AbstractOrder order) throws ValidationException {
        if (!(order instanceof SalesOrder)) {
            throw new ValidationException("A sales order was expected");
        }

        for (AbstractOrderValidator validator : validators) {
            validator.validate(order);
        }
    }
}
