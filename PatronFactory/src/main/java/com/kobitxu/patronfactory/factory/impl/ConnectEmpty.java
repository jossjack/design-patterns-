/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kobitxu.patronfactory.factory.impl;

import com.kobitxu.patronfactory.factory.IConexion;

/**
 *
 * @author joseph
 */
public class ConnectEmpty implements IConexion {

    @Override
    public void conectar() {
        System.out.println("NO SE ESPECIFICĂ“ PROVEEDOR");
    }

    @Override
    public void desconectar() {
        System.out.println("NO SE ESPECIFICĂ“ PROVEEDOR");
    }

}
