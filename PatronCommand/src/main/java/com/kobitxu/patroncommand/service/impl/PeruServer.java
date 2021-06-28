/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kobitxu.patroncommand.service.impl;

import com.kobitxu.patroncommand.service.IServer;

/**
 *
 * @author joseph
 */
public class PeruServer implements IServer {

    @Override
    public void apagar() {
        System.out.println("Apagando el servidor de Peru");
    }

    @Override
    public void encender() {
        System.out.println("Encendiendo el servidor de Peru");
    }

    @Override
    public void conectar() {
        System.out.println("Conectando con el servidor de Peru");
    }

    @Override
    public void validarConexion() {
        System.out.println("Validando la conexon con el servidor de Peru");
    }

    @Override
    public void guardarRegistro() {
        System.out.println("Guardando los logs en el servidor de Peru");
    }

    @Override
    public void cerrarConexion() {
        System.out.println("Cerrando la conexion con el servidor de Peru");
    }
}
