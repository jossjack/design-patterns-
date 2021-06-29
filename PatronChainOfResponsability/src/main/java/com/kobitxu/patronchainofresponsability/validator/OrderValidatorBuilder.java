/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kobitxu.patronchainofresponsability.validator;

/**
 *
 * @author joseph
 */
public class OrderValidatorBuilder {

    public static final AbstractOrderValidator buildSalesOrderValidator() {
        AbstractOrderValidator validator = new SalesOrderValidator();
        validator.addValidator(buildCustomerValidator());
        validator.addValidator(new OrderItemValidator());
        validator.addValidator(new CreditValidator());
        return validator;
    }

    private static AbstractOrderValidator buildCustomerValidator() {
        AbstractOrderValidator validator = new CustomerValidator();
        validator.addValidator(buildContributorValidator());
        return validator;
    }

    private static AbstractOrderValidator buildContributorValidator() {
        AbstractOrderValidator validator = new ContributorValidator();
        validator.addValidator(new AddressValidator());
        validator.addValidator(new TelephoneValidator());
        return validator;
    }
}
