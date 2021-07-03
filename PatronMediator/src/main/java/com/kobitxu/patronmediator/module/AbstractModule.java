/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kobitxu.patronmediator.module;

/**
 *
 * @author joseph
 */
public abstract class AbstractModule {

    protected ModuleMediator mediator;

    public abstract String getModulName();

    public void activate() {
        mediator = ModuleMediator.getInstance();
        mediator.registModule(this);
    }

    public abstract Object notifyMessage(ModuleMessage message);
}
