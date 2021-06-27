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
public class Contact {

    private String name;
    private Phone phone;
    private Address address;

    public Contact(String name, Phone phone) {
        this.name = name;
        this.phone = phone;
    }

    public Contact(String name, Phone phone, Address address) {
        this.name = name;
        this.phone = phone;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Contact{name=").append(name);
        sb.append(", phone=").append(phone);
        sb.append(", address=").append(address);
        sb.append('}');
        return sb.toString();
    }
}
