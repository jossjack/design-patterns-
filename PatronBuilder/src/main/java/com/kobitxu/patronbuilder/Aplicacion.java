/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kobitxu.patronbuilder;

import com.kobitxu.patronbuilder.dto.Employee;

/**
 *
 * @author joseph
 */
public class Aplicacion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Employee emp = new Employee.EmployeeBuilder()
                .setName("Joseph")
                .setGender("M")
                .setAge(30)
                .setAddress("Urbanor", "Guayaqui", "Ecuador", "09510")
                .addContacts("Jack", "0969168108", "123", "celular")
                .addContacts("Khriz", "0978569423", "456", "celular")
                .addPhones("042886801", null, "casa1")
                .addPhones("042335892", null, "casa2")
                .build();

        System.out.println(emp);
    }
}
