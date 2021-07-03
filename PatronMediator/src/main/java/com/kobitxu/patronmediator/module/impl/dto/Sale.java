/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kobitxu.patronmediator.module.impl.dto;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author joseph
 */
public class Sale {

    protected List<Product> productos = new ArrayList<>();

    public List<Product> getProductos() {
        return productos;
    }

    public void addProduct(Product product) {
        this.productos.add(product);
    }

    public void setProductos(List<Product> productos) {
        this.productos = productos;
    }
}
