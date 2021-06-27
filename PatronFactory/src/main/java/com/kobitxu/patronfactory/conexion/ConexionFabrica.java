/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kobitxu.patronfactory.conexion;

import com.kobitxu.patronfactory.factory.IConexion;
import com.kobitxu.patronfactory.factory.impl.ConnectEmpty;
import com.kobitxu.patronfactory.factory.impl.ConnectMySQL;
import com.kobitxu.patronfactory.factory.impl.ConnectOracle;
import com.kobitxu.patronfactory.factory.impl.ConnectPostgreSQL;
import com.kobitxu.patronfactory.factory.impl.ConnectQLServer;

/**
 *
 * @author joseph
 */
public class ConexionFabrica {

    public IConexion getConexion(String motor) {
        if (motor == null) {
            return new ConnectEmpty();
        }
        if (motor.equalsIgnoreCase("MYSQL")) {
            return new ConnectMySQL();
        } else if (motor.equalsIgnoreCase("ORACLE")) {
            return new ConnectOracle();
        } else if (motor.equalsIgnoreCase("POSTGRE")) {
            return new ConnectPostgreSQL();
        } else if (motor.equalsIgnoreCase("SQL")) {
            return new ConnectQLServer();
        }

        return new ConnectEmpty();
    }
}
