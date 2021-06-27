/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kobitxu.patronabstractfactory.factory.impl;

import com.kobitxu.patronabstractfactory.factory.IConexionBD;



/**
 *
 * @author joseph
 */
public class ConnectMySQL implements IConexionBD {

    private final String host;
    private final String puerto;
    private final String usuario;
    private final String contrasena;

    public ConnectMySQL() {
        this.host = "localhost";
        this.puerto = "3306";
        this.usuario = "root";
        this.contrasena = "123";
    }

    @Override
    public void conectar() {
        // Aqui puede ir código JDBC
        System.out.println("Se conectó a MySQL");

    }

    @Override
    public void desconectar() {
        System.out.println("Se desconectó de MySQL");
    }

    @Override
    public String toString() {
        return "ConexionMySQL [host=" + host + ", puerto=" + puerto + ", usuario=" + usuario + ", contrasena="
                + contrasena + "]";
    }
}
