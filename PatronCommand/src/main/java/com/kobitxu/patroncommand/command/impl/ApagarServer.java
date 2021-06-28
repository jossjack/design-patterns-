/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kobitxu.patroncommand.command.impl;

import com.kobitxu.patroncommand.command.Command;
import com.kobitxu.patroncommand.service.IServer;

/**
 *
 * @author joseph
 */
public class ApagarServer implements Command {

    private IServer servidor;

    public ApagarServer(IServer servidor) {
        this.servidor = servidor;
    }

    @Override
    public void execute() {
        servidor.conectar();
        servidor.validarConexion();
        servidor.guardarRegistro();
        servidor.apagar();
        servidor.cerrarConexion();
    }
}
