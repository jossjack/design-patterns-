/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kobitxu.patroniterator;

import com.kobitxu.patroniterator.impl.Employee;
import com.kobitxu.patroniterator.impl.IIterator;

/**
 *
 * @author joseph
 */
public class Aplicacion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Employee employee = new Employee("Juan", "CEO",
                new Employee("Pedro", "President",
                        new Employee("Liliana", "VP",
                                new Employee("Oscar", "Manager",
                                        new Employee("Mario", "Developer"),
                                        new Employee("Rodolfo", "Developer")),
                                new Employee("Sofia", "Manager",
                                        new Employee("Adrian", "Sr Developer"),
                                        new Employee("Rebeca", "Developer")
                                )
                        )
                )
        );

        IIterator<Employee> empIterator = employee.createIterator();
        while (empIterator.hasNext()) {
            Employee emp = empIterator.next();
            System.out.println("emp > " + emp.toString());
        }
    }
}
