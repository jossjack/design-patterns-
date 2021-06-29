/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kobitxu.patronchainofresponsability.validator;

import com.kobitxu.patronchainofresponsability.domain.Telephone;
import com.kobitxu.patronchainofresponsability.domain.order.AbstractOrder;

/**
 *
 * @author joseph
 */
public class TelephoneValidator extends AbstractOrderValidator {

    @Override
    public void validate(AbstractOrder order) throws ValidationException {
        Telephone tel = order.getContributor().getTelephone();
        if (null == tel) {
            throw new ValidationException(
                    "The taxpayer's phone is required");
        } else if (tel.getNumber().length() != 7) {
            throw new ValidationException("Invalid phone number");
        } else if (tel.getLada().length() != 3) {
            throw new ValidationException("Invalid lada");
        }
    }
}
