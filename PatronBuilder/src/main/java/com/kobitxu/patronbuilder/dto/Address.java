/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kobitxu.patronbuilder.dto;

/**
 *
 * @author joseph
 */
public class Address {

    private String address;
    private String city;
    private String country;
    private String cp;

    public Address(String address, String city, String country, String cp) {
        this.address = address;
        this.city = city;
        this.country = country;
        this.cp = cp;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Address{address=").append(address);
        sb.append(", city=").append(city);
        sb.append(", country=").append(country);
        sb.append(", cp=").append(cp);
        sb.append('}');
        return sb.toString();
    }
}
