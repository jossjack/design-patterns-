/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kobitxu.patronnullobject.dao;

import com.kobitxu.patronnullobject.domain.Address;
import com.kobitxu.patronnullobject.domain.Employee;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author joseph
 */
public class EmployeeDAOService {

    private List<Employee> EMPLOYEE_LIST = new ArrayList<>();

    public EmployeeDAOService() {
        Employee emp1 = new Employee(1L, "Oscar Blancarte",
                new Address("Reforma 150 int 20, Mexico D.F."));
        EMPLOYEE_LIST.add(emp1);
    }

    public Employee findEmployeeById(Long id) {
        for (Employee emp : EMPLOYEE_LIST) {
            if (emp.getId().longValue() == id.longValue()) {
                return emp;
            }
        }
        return Employee.NULL_EMPOYEE;
    }
}
