/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kobitxu.patronabstractfactory;

import com.kobitxu.patronabstractfactory.conexion.FabricaProductor;
import com.kobitxu.patronabstractfactory.factory.FabricaAbstracta;
import com.kobitxu.patronabstractfactory.factory.IConexionBD;
import com.kobitxu.patronabstractfactory.factory.IConexionREST;

/**
 *
 * @author joseph
 */
public class Aplicacion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        FabricaAbstracta fabricaBD = FabricaProductor.getFactory("BD");
        IConexionBD cxBD1 = fabricaBD.getBD("MYSQL");

        cxBD1.conectar();

        FabricaAbstracta fabricaREST = FabricaProductor.getFactory("REST");
        IConexionREST cxRS1 = fabricaREST.getREST("COMPRAS");

        cxRS1.leerURL("https://www.youtube.com/subscription_center?add_user=mitocode");
    }

}
