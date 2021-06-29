/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kobitxu.patronchainofresponsability.validator;

import com.kobitxu.patronchainofresponsability.domain.order.AbstractOrder;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author joseph
 */
public abstract class AbstractOrderValidator {

    protected List<AbstractOrderValidator> validators = new ArrayList<>();

    public abstract void validate(AbstractOrder order) throws ValidationException;

    public void addValidator(AbstractOrderValidator validator) {
        validators.add(validator);
    }
}
