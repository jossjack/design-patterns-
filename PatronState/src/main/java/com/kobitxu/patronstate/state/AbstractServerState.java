/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kobitxu.patronstate.state;

import com.kobitxu.patronstate.Server;

/**
 *
 * @author joseph
 */
public abstract class AbstractServerState {

    public AbstractServerState() {
    }

    public abstract void handleMessage(Server server, String message);
}