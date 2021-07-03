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
public class Employee {

    public static final Employee NULL_EMPOYEE = new Employee() {

        public Long getId() {
            return 0L;
        }

        public String getName() {
            return "UNKNOW EMPLOYEE";
        }

        public Address getAddress() {
            return Address.NULL_ADDRESS;
        }
    };

    private Long id;
    private String name;
    private Address address;

    public Employee(Long id, String name, Address address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public Employee() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return this.address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
