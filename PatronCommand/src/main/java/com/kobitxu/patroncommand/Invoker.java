/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kobitxu.patroncommand;

import com.kobitxu.patroncommand.command.Command;

/**
 *
 * @author joseph
 */
public class Invoker {

    private Command command;

    public Invoker(Command command) {
        this.command = command;
    }

    public void run() {
        command.execute();
    }
}
