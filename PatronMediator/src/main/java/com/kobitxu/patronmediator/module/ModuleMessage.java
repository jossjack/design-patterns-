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
public class ModuleMessage {

    private String source;
    private String target;
    private String messageType;
    private Object payload;

    public ModuleMessage(String source, String target, String messageType,
            Object payload) {
        this.source = source;
        this.target = target;
        this.messageType = messageType;
        this.payload = payload;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public Object getPayload() {
        return payload;
    }

    public void setPayload(Object payload) {
        this.payload = payload;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}
