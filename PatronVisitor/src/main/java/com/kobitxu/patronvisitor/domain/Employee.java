/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kobitxu.patronvisitor.domain;

import com.kobitxu.patronvisitor.impl.IVisitable;
import com.kobitxu.patronvisitor.impl.IVisitor;
import java.util.Objects;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author joseph
 */
@XmlRootElement(name = "Responsible")
@XmlAccessorType(XmlAccessType.FIELD)
public class Employee implements IVisitable {

    @XmlAttribute(name = "name")
    private String name;
    @XmlAttribute(name = "price")
    private double price;// for Hour  

    public Employee() {
    }

    public Employee(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public void accept(IVisitor visitor) {
        visitor.employee(this);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.name);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Employee other = (Employee) obj;
        return Objects.equals(this.name, other.name);
    }
}
