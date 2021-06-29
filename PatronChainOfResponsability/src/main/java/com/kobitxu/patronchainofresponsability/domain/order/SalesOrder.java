/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kobitxu.patronchainofresponsability.domain.order;

import java.util.Calendar;

/**
 *
 * @author joseph
 */
public class SalesOrder extends AbstractOrder {

    protected Calendar deliveryDate;

    public Calendar getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Calendar deliveryDate) {
        this.deliveryDate = deliveryDate;
    }
}
