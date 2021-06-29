/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kobitxu.patronchainofresponsability.validator;

import com.kobitxu.patronchainofresponsability.domain.Address;
import com.kobitxu.patronchainofresponsability.domain.order.AbstractOrder;

/**
 *
 * @author joseph
 */
public class AddressValidator extends AbstractOrderValidator {

    @Override
    public void validate(AbstractOrder order) throws ValidationException {
        Address address = order.getContributor().getAddress();
        if (address.getAddress1() == null || address.getAddress1().length() == 0) {
            throw new ValidationException("Address 1 is mandatory");
        } else if (address.getCP() == null || address.getCP().length() != 4) {
            throw new ValidationException("ZIP code must be 4 digits");
        } else if (address.getCountry() == null || address.getCountry().length() == 0) {
            throw new ValidationException("The country is mandatory");
        }
    }
}
