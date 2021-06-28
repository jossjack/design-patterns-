/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kobitxu.patroncomposite.orders;

import com.kobitxu.patroncomposite.products.AbstractProduct;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author joseph
 */
public class SaleOrder {

    private long orderId;
    private String customer;
    private List<AbstractProduct> products = new ArrayList<>();

    public SaleOrder(long orderId, String customer) {
        super();
        this.orderId = orderId;
        this.customer = customer;
    }

    public double getPrice() {
        double price = 0d;
        price = products.stream()
                .map((child) -> child.getPrice())
                .reduce(price, (acumulador, precio) -> acumulador + precio);
        return price;
    }

    public void addProduct(AbstractProduct product) {
        products.add(product);
    }

    public void printOrder() {

        NumberFormat formater = new DecimalFormat("###,##0.00");
        System.out.println("\\\n=============================================" + "\nOrden: " + orderId + "\nCustomer: " + customer + "\nProducts:\n");
        products.forEach((prod) -> {
            System.out.println(prod.getName() + "\t\t\t$ " + formater.format(prod.getPrice()));
        });
        System.out.println("Total: " + formater.format(getPrice()) + "\n=============================================");
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public List<AbstractProduct> getProducts() {
        return products;
    }

    public void setProducts(List<AbstractProduct> products) {
        this.products = products;
    }
}
