/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kobitxu.patronnullobject.domain;

/**
 *
 * @author joseph
 */
public class Address {

    public static final Address NULL_ADDRESS = new Address() {
        public String getFullAddress() {
            return "NOT ADDRESS";
        }
    };

    public String fullAddress;

    public Address(String fullAddress) {
        this.fullAddress = fullAddress;
    }

    public Address() {
        this.fullAddress = fullAddress;
    }

    public String getFullAddress() {
        return fullAddress;
    }

    public void setFullAddress(String fullAddress) {
        this.fullAddress = fullAddress;
    }
}
