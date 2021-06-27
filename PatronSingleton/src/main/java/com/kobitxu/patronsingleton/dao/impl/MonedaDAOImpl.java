/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kobitxu.patronsingleton.dao.impl;

import com.kobitxu.patronsingleton.dao.MonedaDAO;
import com.kobitxu.patronsingleton.model.Moneda;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author joseph
 */
public class MonedaDAOImpl implements MonedaDAO {

    @Override
    public List<Moneda> getListadoMonedas() {
        List<Moneda> lMoneda = new ArrayList<>();

        Moneda m1 = new Moneda();
        m1.setNombre("Euro");
        m1.setSimbolo("€");

        Moneda m2 = new Moneda();
        m2.setNombre("Dolar");
        m2.setSimbolo("$");

        Moneda m3 = new Moneda();
        m3.setNombre("Yen");
        m3.setSimbolo("¥");

        Moneda m4 = new Moneda();
        m4.setNombre("Libra");
        m4.setSimbolo("£");

        lMoneda.add(m1);
        lMoneda.add(m2);
        lMoneda.add(m3);
        lMoneda.add(m4);

        return lMoneda;
    }
}
