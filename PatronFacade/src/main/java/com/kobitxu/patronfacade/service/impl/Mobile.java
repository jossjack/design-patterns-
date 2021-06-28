/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kobitxu.patronfacade.service.impl;

import com.kobitxu.patronfacade.model.Battery;
import com.kobitxu.patronfacade.model.CPU;
import com.kobitxu.patronfacade.service.MobileService;
import java.util.List;

/**
 *
 * @author joseph
 */
public class Mobile {

    private final Battery battery;
    private final CPU cpu;
    private final List<MobileService> mobileServices;

    public Mobile(Battery battery, CPU cpu, List<MobileService> mobileServices) {
        this.battery = battery;
        this.cpu = cpu;
        this.mobileServices = mobileServices;
    }

    public CPU getCpu() {
        return cpu;
    }

    public Battery getBattery() {
        return battery;
    }

    public List<MobileService> getMobileServices() {
        return mobileServices;
    }
}
