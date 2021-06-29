/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kobitxu.patronchainofresponsability.domain.order;

import com.kobitxu.patronchainofresponsability.domain.Contributor;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author joseph
 */
public abstract class AbstractOrder {

    private Calendar createDate;
    private Contributor contributor;
    private List<OrderItem> orderItems;

    public Calendar getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Calendar createDate) {
        this.createDate = createDate;
    }

    public Contributor getContributor() {
        return contributor;
    }

    public void setContributor(Contributor contributor) {
        this.contributor = contributor;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public double getTotal() {
        double total = 0d;
        total = orderItems
                .stream()
                .map((abstractOrderItem) -> abstractOrderItem.getTotal())
                .reduce(total, (accumulator, _item) -> accumulator + _item);
        return total;
    }
}
