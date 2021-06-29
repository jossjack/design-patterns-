/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kobitxu.patronchainofresponsability.validator;

import com.kobitxu.patronchainofresponsability.domain.Product;
import com.kobitxu.patronchainofresponsability.domain.order.AbstractOrder;
import com.kobitxu.patronchainofresponsability.domain.order.OrderItem;
import java.util.List;

/**
 *
 * @author joseph
 */
public class OrderItemValidator extends AbstractOrderValidator {

    @Override
    public void validate(AbstractOrder order) throws ValidationException {
        List<OrderItem> orderItems = order.getOrderItems();
        for (OrderItem item : orderItems) {
            Product product = item.getProduct();
            if (item.getQuantity() <= 0) {
                throw new ValidationException("The product '"
                        + product.getName() + "' has no amount");
            }

            double listPrice = item.getProduct().getListPrice();
            double price = item.getPrice();
            double priceLimit = listPrice - (listPrice * 0.20d);
            if (price < priceLimit) {
                throw new ValidationException("The price of the product '"
                        + product.getName() + "' exceeds the allowed limit");
            }
        }
    }
}
