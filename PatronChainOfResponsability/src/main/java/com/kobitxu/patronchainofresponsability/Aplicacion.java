/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kobitxu.patronchainofresponsability;

import com.kobitxu.patronchainofresponsability.domain.Address;
import com.kobitxu.patronchainofresponsability.domain.CreditData;
import com.kobitxu.patronchainofresponsability.domain.Customer;
import com.kobitxu.patronchainofresponsability.domain.Product;
import com.kobitxu.patronchainofresponsability.domain.Status;
import com.kobitxu.patronchainofresponsability.domain.Telephone;
import com.kobitxu.patronchainofresponsability.domain.order.OrderItem;
import com.kobitxu.patronchainofresponsability.domain.order.SalesOrder;
import com.kobitxu.patronchainofresponsability.validator.AbstractOrderValidator;
import com.kobitxu.patronchainofresponsability.validator.OrderValidatorBuilder;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author joseph
 */
public class Aplicacion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SalesOrder salesOrder = new SalesOrder();
        salesOrder.setDeliveryDate(Calendar.getInstance());
        Customer customer = new Customer();
        customer.setName("Joseph Reyes");
        customer.setRfc("XXX0000000X0");
        customer.setStatus(Status.ACTIVO);

        Telephone phone = new Telephone();
        phone.setExt("123");
        phone.setLada("999");
        phone.setNumber("1234567");
        customer.setTelephone(phone);

        Address address = new Address();
        address.setAddress1("Address 1");
        address.setAddress2("Address 2");
        address.setCP("1234");
        address.setCountry("Ecuador");
        customer.setAddress(address);

        CreditData creditData = new CreditData();
        creditData.setBalance(1000);
        creditData.setCreditLimit(13000);
        customer.setCreditData(creditData);

        salesOrder.setContributor(customer);

        List<OrderItem> orderItems = new ArrayList<>();
        for (int c = 0; c < 10; c++) {
            OrderItem item = new OrderItem();
            item.setPrice((c + 1) * 30);
            Product product = new Product();
            product.setListPrice((c + 1) * 32);
            product.setName("Product " + (c + 1));
            item.setProduct(product);
            item.setQuantity(0);
            orderItems.add(item);
        }
        salesOrder.setOrderItems(orderItems);
        System.out.println("Total orden > " + salesOrder.getTotal());
        try {
            AbstractOrderValidator validator
                    = OrderValidatorBuilder.buildSalesOrderValidator();
            validator.validate(salesOrder);
            System.out.println("Successful validation");
        } catch (Exception e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
