/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kobitxu.patroncommand.service;

/**
 *
 * @author joseph
 */
public interface IServer {

    public void apagar();

    public void encender();

    public void conectar();

    public void validarConexion();

    public void guardarRegistro();

    public void cerrarConexion();
}
