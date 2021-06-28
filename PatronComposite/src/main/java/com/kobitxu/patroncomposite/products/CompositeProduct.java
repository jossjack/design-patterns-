/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kobitxu.patroncomposite.products;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author joseph
 */
public class CompositeProduct extends AbstractProduct {

    private final List<AbstractProduct> products = new ArrayList<>();

    public CompositeProduct(String name) {
        super(name, 0);
    }

    @Override
    public double getPrice() {
        double price = 0d;
        price = products.stream()
                .map((child) -> child.getPrice())
                .reduce(price, (acumulador, precio) -> acumulador + precio);
        return price;
    }

    @Override
    public void setPrice(double price) {
        throw new UnsupportedOperationException();
    }

    public void addProduct(AbstractProduct product) {
        this.products.add(product);
    }

    public boolean removeProduct(AbstractProduct product) {
        return this.products.remove(product);
    }
}
