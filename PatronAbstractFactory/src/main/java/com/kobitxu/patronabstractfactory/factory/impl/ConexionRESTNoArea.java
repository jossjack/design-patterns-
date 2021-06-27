/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kobitxu.patronabstractfactory.factory.impl;

import com.kobitxu.patronabstractfactory.factory.IConexionREST;

/**
 *
 * @author joseph
 */
public class ConexionRESTNoArea implements IConexionREST {

    @Override
    public void leerURL(String url) {
        System.out.println("AREA NO ELEGIDA");
    }

}
