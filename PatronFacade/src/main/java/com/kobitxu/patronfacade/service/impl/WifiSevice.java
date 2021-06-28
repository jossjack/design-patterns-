/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kobitxu.patronfacade.service.impl;

import com.kobitxu.patronfacade.service.MobileService;

/**
 *
 * @author joseph
 */
public class WifiSevice implements MobileService {

    @Override
    public void start() {
        System.out.println("WIFI Service started");
    }

    @Override
    public void close() {
        System.out.println("WIFI Service started");
    }
}
