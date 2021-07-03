/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kobitxu.patroncommand;

import com.kobitxu.patroncommand.command.Command;
import com.kobitxu.patroncommand.command.impl.PrenderServer;
import com.kobitxu.patroncommand.service.impl.ColombiaServer;
import com.kobitxu.patroncommand.service.impl.EcuadorServer;
import com.kobitxu.patroncommand.service.impl.PeruServer;

/**
 *
 * @author joseph
 */
public class Aplicacion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Command command = new PrenderServer(new ColombiaServer());
        Invoker serverAdmin = new Invoker(command);
        serverAdmin.run();
    }
}
