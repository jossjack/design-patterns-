/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kobitxu.patronabstractfactory.conexion;

import com.kobitxu.patronabstractfactory.factory.FabricaAbstracta;

/**
 *
 * @author joseph
 */
public class FabricaProductor {

    public static FabricaAbstracta getFactory(String tipoFabrica) {

        if (tipoFabrica.equalsIgnoreCase("BD")) {
            return new ConexionBDFabrica();

        } else if (tipoFabrica.equalsIgnoreCase("REST")) {
            return new ConexionRESTFabrica();
        }

        return null;
    }
}
