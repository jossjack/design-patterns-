/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kobitxu.patronnullobject;

import com.kobitxu.patronnullobject.dao.EmployeeDAOService;
import com.kobitxu.patronnullobject.domain.Employee;

/**
 *
 * @author joseph
 */
public class Aplicacion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EmployeeDAOService service = new EmployeeDAOService();
        Employee emp1 = service.findEmployeeById(1L);
        System.out.println(emp1.getAddress().getFullAddress());

        Employee emp2 = service.findEmployeeById(2L);
        System.out.println(emp2.getAddress().getFullAddress());
    }
}
