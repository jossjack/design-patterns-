/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kobitxu.patronabstractfactory.conexion;

import com.kobitxu.patronabstractfactory.factory.FabricaAbstracta;
import com.kobitxu.patronabstractfactory.factory.IConexionBD;
import com.kobitxu.patronabstractfactory.factory.IConexionREST;
import com.kobitxu.patronabstractfactory.factory.impl.ConnectEmpty;
import com.kobitxu.patronabstractfactory.factory.impl.ConnectMySQL;
import com.kobitxu.patronabstractfactory.factory.impl.ConnectOracle;
import com.kobitxu.patronabstractfactory.factory.impl.ConnectPostgreSQL;
import com.kobitxu.patronabstractfactory.factory.impl.ConnectQLServer;

/**
 *
 * @author joseph
 */
public class ConexionBDFabrica implements FabricaAbstracta {

    @Override
    public IConexionBD getBD(String motor) {
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

    @Override
    public IConexionREST getREST(String area) {
        return null;
    }
}
