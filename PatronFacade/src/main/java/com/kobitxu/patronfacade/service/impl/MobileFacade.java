/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kobitxu.patronfacade.service.impl;

import com.kobitxu.patronfacade.model.Battery;
import com.kobitxu.patronfacade.model.CPU;
import com.kobitxu.patronfacade.service.MobileService;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author joseph
 */
public class MobileFacade {

    public Mobile on() {

        Battery battery = new Battery();
        battery.on();

        CPU cpu = new CPU();
        cpu.bootLoad();

        MobileService gps = new GPSService();
        gps.start();

        MobileService wifi = new WifiSevice();
        wifi.start();

        List<MobileService> mobileServices = Arrays.asList(gps, wifi);

        Mobile mobile = new Mobile(battery, cpu, mobileServices);

        return mobile;
    }

    public void off(Mobile mobile) {

        mobile.getMobileServices().forEach((service) -> {
            service.close();
        });
        mobile.getCpu().shutDown();
        mobile.getBattery().off();
    }
}
