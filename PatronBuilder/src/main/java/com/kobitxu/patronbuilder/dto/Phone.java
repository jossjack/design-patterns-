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
public class Phone {

    private String phoneNumber;
    private String ext;
    private String phoneType;

    public Phone(String phoneNumber, String ext, String phoneType) {
        this.phoneNumber = phoneNumber;
        this.ext = ext;
        this.phoneType = phoneType;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getExt() {
        return ext;
    }

    public void setExt(String ext) {
        this.ext = ext;
    }

    public String getPhoneType() {
        return phoneType;
    }

    public void setPhoneType(String phoneType) {
        this.phoneType = phoneType;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Phone{phoneNumber=").append(phoneNumber);
        sb.append(", ext=").append(ext);
        sb.append(", phoneType=").append(phoneType);
        sb.append('}');
        return sb.toString();
    }
}
