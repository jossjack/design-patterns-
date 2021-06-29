/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kobitxu.patronchainofresponsability.validator;

import com.kobitxu.patronchainofresponsability.domain.Customer;
import com.kobitxu.patronchainofresponsability.domain.order.AbstractOrder;

/**
 *
 * @author joseph
 */
public class CustomerValidator extends AbstractOrderValidator {

    @Override
    public void validate(AbstractOrder order) throws ValidationException {
        for (AbstractOrderValidator validator : validators) {
            validator.validate(order);
        }

        if (!(order.getContributor() instanceof Customer)) {
            throw new ValidationException("The taxpayer is not a client");
        }
    }
}
