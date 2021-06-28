/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kobitxu.patroncomposite;

import com.kobitxu.patroncomposite.orders.SaleOrder;
import com.kobitxu.patroncomposite.products.CompositeProduct;
import com.kobitxu.patroncomposite.products.SimpleProduct;
import java.util.Random;

/**
 *
 * @author joseph
 */
public class Aplicacion {

    /**
     * @param args the command line arguments
     */
    private final Random random = new Random();

    private SimpleProduct ram4gb;
    private SimpleProduct ram8gb;
    private SimpleProduct disk500gb;
    private SimpleProduct disk1tb;
    private SimpleProduct cpuAMD;
    private SimpleProduct cpuIntel;
    private SimpleProduct smallCabinete;
    private SimpleProduct bigCabinete;
    private SimpleProduct monitor20inch;
    private SimpleProduct monitor30inch;
    private SimpleProduct simpleMouse;
    private SimpleProduct gammerMouse;

    private CompositeProduct gammerPC;
    private CompositeProduct homePC;
    private CompositeProduct pc2x1;

    private void buildProducts() {
        //Simple product construction
        ram4gb = new SimpleProduct("RAM 4GB", 750, "KingStone");
        ram8gb = new SimpleProduct("RAM 8GB", 1000, "KingStone");
        disk500gb = new SimpleProduct("HDD 500GB", 1500, "ACME");
        disk1tb = new SimpleProduct("HDD 1TB", 2000, "ACME");
        cpuAMD = new SimpleProduct("AMD phenon", 4000, "AMD");
        cpuIntel = new SimpleProduct("Intel i7", 4500, "Intel");
        smallCabinete = new SimpleProduct("Small cabinet", 2000, "ExCom");
        bigCabinete = new SimpleProduct("Big Cabinet", 2200, "ExCom");
        monitor20inch = new SimpleProduct("Display 20'", 1500, "HP");
        monitor30inch = new SimpleProduct("Display 30'", 2000, "HP");
        simpleMouse = new SimpleProduct("Simple mouse", 150, "Genius");
        gammerMouse = new SimpleProduct("Gammer mouse", 750, "Alien");

        //Gammer pc with 8gb ram,HDD 1tb, Intel i7 processor
        //large cabinet,display 30' and one gammer mouse.
        gammerPC = new CompositeProduct("Gammer PC");
        gammerPC.addProduct(ram8gb);
        gammerPC.addProduct(disk1tb);
        gammerPC.addProduct(cpuIntel);
        gammerPC.addProduct(bigCabinete);
        gammerPC.addProduct(monitor30inch);
        gammerPC.addProduct(gammerMouse);

        //Home PC with RAM 4gb, HDD 500gb, AMD Phenon processor
        //small Cabinet, dsplay 20' and simple mouse.
        homePC = new CompositeProduct("Home PC");
        homePC.addProduct(ram4gb);//
        homePC.addProduct(disk500gb);
        homePC.addProduct(cpuAMD);
        homePC.addProduct(smallCabinete);
        homePC.addProduct(monitor20inch);
        homePC.addProduct(simpleMouse);

        //Package consisting of two packages, Gammer PC + Home PC
        pc2x1 = new CompositeProduct("Pack PC Gammer + Home PC");
        pc2x1.addProduct(gammerPC);
        pc2x1.addProduct(homePC);
    }

    private void orderSimpleProducts() {

        SaleOrder simpleProductOrder = new SaleOrder(random.nextInt(), "Joseph Reyes");
        simpleProductOrder.addProduct(ram4gb);
        simpleProductOrder.addProduct(disk1tb);
        simpleProductOrder.addProduct(simpleMouse);
        simpleProductOrder.printOrder();
    }

    private void orderGammerPC() {
        SaleOrder gammerOrder = new SaleOrder(1, "Jackson");
        gammerOrder.addProduct(gammerPC);
        gammerOrder.printOrder();
    }

    private void orderHomePC() {
        SaleOrder homeOrder = new SaleOrder(2, "Korn");
        homeOrder.addProduct(homePC);
        homeOrder.printOrder();
    }

    private void orderCombo() {
        SaleOrder comboOrder = new SaleOrder(3, "Paquete 2x1 en PC");
        comboOrder.addProduct(pc2x1);
        comboOrder.printOrder();
    }

    private void orderBig() {
        SaleOrder customOrder = new SaleOrder(4, "Joseph Reyes Moreira");
        customOrder.addProduct(homePC);
        customOrder.addProduct(ram8gb);
        customOrder.addProduct(ram4gb);
        customOrder.addProduct(monitor30inch);
        customOrder.addProduct(gammerMouse);
        customOrder.printOrder();
    }

    public static void main(String[] args) {
        Aplicacion main = new Aplicacion();
        main.buildProducts();

        //main.orderSimpleProducts();
        //main.orderHomePC();
        //main.orderGammerPC();
        //main.orderCombo();
        main.orderBig();
    }
}
