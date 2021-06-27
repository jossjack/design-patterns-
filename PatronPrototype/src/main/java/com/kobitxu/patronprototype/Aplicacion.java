/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kobitxu.patronprototype;

import com.kobitxu.patronprototype.service.PersonaImpl;

/**
 *
 * @author joseph
 */
public class Aplicacion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        PersonaImpl cuentaAhorro = new PersonaImpl();
        cuentaAhorro.setNombre("Joseph");
        cuentaAhorro.setEdad(32);

        PersonaImpl cuentaAhorro2 = new PersonaImpl();

        PersonaImpl cuentaClonada = (PersonaImpl) cuentaAhorro.clonar();

        System.out.println(cuentaAhorro);
        System.out.println(cuentaAhorro2);
        System.out.println(cuentaClonada);

        if (cuentaClonada != null) {
            System.out.println(cuentaClonada);
        }
        System.out.println(cuentaClonada == cuentaAhorro);
    }

}
