/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kobitxu.patronchainofresponsability.validator;

import com.kobitxu.patronchainofresponsability.domain.Contributor;
import com.kobitxu.patronchainofresponsability.domain.Status;
import com.kobitxu.patronchainofresponsability.domain.order.AbstractOrder;

/**
 *
 * @author joseph
 */
public class ContributorValidator extends AbstractOrderValidator {

    @Override
    public void validate(AbstractOrder order) throws ValidationException {
        for (AbstractOrderValidator validator : validators) {
            validator.validate(order);
        }
        Contributor contributor = order.getContributor();
        if (Status.ACTIVO != contributor.getStatus()) {
            throw new ValidationException("The taxpayer is not active");
        }
    }
}
