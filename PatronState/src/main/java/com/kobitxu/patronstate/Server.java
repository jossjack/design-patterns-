/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kobitxu.patronstate;

import com.kobitxu.patronstate.state.AbstractServerState;
import com.kobitxu.patronstate.state.StartingServerState;
import com.kobitxu.patronstate.state.StopServerState;

/**
 *
 * @author joseph
 */
public class Server {

    private static final int maxRequest = 5;
    private final MessageProcess messageProcess = new MessageProcess(this);
    private AbstractServerState state;

    public Server() {
        setState(new StopServerState(this));
    }

    public void handleMessage(String message) {
        state.handleMessage(this, message);
    }

    public int getMaxRequest() {
        return maxRequest;
    }

    public MessageProcess getMessageProcess() {
        return messageProcess;
    }

    public AbstractServerState getState() {
        return state;
    }

    public void setState(AbstractServerState state) {
        if (this.state instanceof StartingServerState
                && state instanceof StopServerState) {
            System.out.println("Server is starting, " + "cannot change state");
            return;
        }
        this.state = state;
        System.out.println("Server change state > " + this.state.getClass().getSimpleName());
    }
}
