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
public class ConnectOracle implements IConexion {

    private final String host;
    private final String puerto;
    private final String usuario;
    private final String contrasena;

    public ConnectOracle() {
        this.host = "localhost";
        this.puerto = "1521";
        this.usuario = "admin";
        this.contrasena = "123";
    }

    @Override
    public void conectar() {
        // Aqui puede ir código JDBC
        System.out.println("Se conectó a Oracle");

    }

    @Override
    public void desconectar() {
        System.out.println("Se desconectó de Oracle");
    }

    @Override
    public String toString() {
        return "ConexionOracle [host=" + host + ", puerto=" + puerto + ", usuario=" + usuario + ", contrasena="
                + contrasena + "]";
    }

}
