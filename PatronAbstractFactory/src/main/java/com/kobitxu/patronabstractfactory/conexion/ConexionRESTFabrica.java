/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kobitxu.patronabstractfactory.conexion;

import com.kobitxu.patronabstractfactory.factory.FabricaAbstracta;
import com.kobitxu.patronabstractfactory.factory.IConexionBD;
import com.kobitxu.patronabstractfactory.factory.IConexionREST;
import com.kobitxu.patronabstractfactory.factory.impl.ConexionRESTCompras;
import com.kobitxu.patronabstractfactory.factory.impl.ConexionRESTNoArea;
import com.kobitxu.patronabstractfactory.factory.impl.ConexionRESTVentas;

/**
 *
 * @author joseph
 */
public class ConexionRESTFabrica implements FabricaAbstracta {

    @Override
    public IConexionBD getBD(String motor) {
        return null;
    }

    @Override
    public IConexionREST getREST(String area) {
        if (area == null) {
            return new ConexionRESTNoArea();
        }
        if (area.equalsIgnoreCase("COMPRAS")) {
            return new ConexionRESTCompras();
        } else if (area.equalsIgnoreCase("VENTAS")) {
            return new ConexionRESTVentas();
        }

        return new ConexionRESTNoArea();
    }

}
