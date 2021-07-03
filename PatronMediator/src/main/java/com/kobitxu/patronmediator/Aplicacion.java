/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kobitxu.patronmediator;

import com.kobitxu.patronmediator.module.impl.CRMModule;
import com.kobitxu.patronmediator.module.impl.ECommerceModule;
import com.kobitxu.patronmediator.module.impl.NotifyModule;
import com.kobitxu.patronmediator.module.impl.PurchaseModule;
import com.kobitxu.patronmediator.module.impl.StockModule;
import com.kobitxu.patronmediator.module.impl.dto.Product;
import com.kobitxu.patronmediator.module.impl.dto.Sale;

/**
 *
 * @author joseph
 */
public class Aplicacion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new CRMModule().activate();
        new NotifyModule().activate();
        new StockModule().activate();
        new PurchaseModule().activate();

        ECommerceModule client = new ECommerceModule();
        client.activate();

        Sale sale = new Sale();
        for (int c = 0; c < 5; c++) {
            sale.addProduct(new Product("Product" + (c + 1)));
        }
        client.createSale(sale);
    }
}
