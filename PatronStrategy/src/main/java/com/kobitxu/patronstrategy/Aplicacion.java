/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kobitxu.patronstrategy;

import com.kobitxu.patronstrategy.service.AntivirusAvanzado;
import com.kobitxu.patronstrategy.service.AntivirusSimple;
import com.kobitxu.patronstrategy.service.Contexto;

/**
 *
 * @author joseph
 */
public class Aplicacion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Contexto contexto = new Contexto(new AntivirusAvanzado());
        contexto.ejecutar();
        System.out.println("############");
        contexto = new Contexto(new AntivirusSimple());
        contexto.ejecutar();
    }
}
