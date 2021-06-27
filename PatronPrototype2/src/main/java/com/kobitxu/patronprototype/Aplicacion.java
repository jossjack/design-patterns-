/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kobitxu.patronprototype;

import com.kobitxu.patronprototype.model.ProductItem;
import com.kobitxu.patronprototype.service.PriceListImpl;
import com.kobitxu.patronprototype.service.PrototypeFactory;

/**
 *
 * @author joseph
 */
public class Aplicacion {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {

		// We create the initial price list
		// This has the products with the list price
		PriceListImpl standarPriceList = new PriceListImpl("Standar Price List");
		for (int c = 1; c <= 5; c++) {
			ProductItem item = new ProductItem("Product " + c, c * 2);
			standarPriceList.addProductItem(item);
		}
		PrototypeFactory.addPrototype(standarPriceList.getListName(), standarPriceList);

		// Second list for wholesale customers from the list
		// standard with a 10% discount on the standard price list.
		PriceListImpl wholesalePriceList = (PriceListImpl) PrototypeFactory.getPrototype("Standar Price List");
		wholesalePriceList.setListName("Wholesale Price List");
		for (ProductItem item : wholesalePriceList.getProducts()) {
			item.setPrice(item.getPrice() * 0.90);
		}
		PrototypeFactory.addPrototype(wholesalePriceList.getListName(), wholesalePriceList);

		// Third price list for VIP customers from the list
		// wholesale with 10% on the wholesale price list.
		PriceListImpl vipPriceList = (PriceListImpl) PrototypeFactory.getPrototype("Wholesale Price List");
		vipPriceList.setListName("VIP Price List");
		for (ProductItem item : vipPriceList.getProducts()) {
			item.setPrice(item.getPrice() * 0.90);
		}

		// Imprimimos las listas de precio.
		System.out.println(standarPriceList);
		System.out.println(wholesalePriceList);
		System.out.println(vipPriceList);
	}
}
