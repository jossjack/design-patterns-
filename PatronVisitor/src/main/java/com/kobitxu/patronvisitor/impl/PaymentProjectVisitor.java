/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kobitxu.patronvisitor.impl;

import com.kobitxu.patronvisitor.domain.Activitie;
import com.kobitxu.patronvisitor.domain.Employee;
import com.kobitxu.patronvisitor.domain.EmployeePay;
import com.kobitxu.patronvisitor.domain.Project;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author joseph
 */
public class PaymentProjectVisitor implements IVisitor<List<EmployeePay>> {

    private final Map<String, Number> employeePayment = new HashMap<>();

    @Override
    public void project(Project project) {
        project.getActivities().forEach((act) -> {
            act.accept(this);
        });
    }

    @Override
    public void activitie(Activitie activitie) {
        activitie.getResponsible().accept(this);
        activitie.getActivities().forEach((act) -> {
            act.accept(this);
        });
    }

    @Override
    public void employee(Employee employee) {
        String resp = employee.getName();
        if (employeePayment.containsKey(resp)) {
            employeePayment.put(resp, employeePayment.get(resp).doubleValue() + employee.getPrice());
        } else {
            employeePayment.put(resp, employee.getPrice());
        }
    }

    @Override
    public List<EmployeePay> getResult() {
        List<EmployeePay> response = new ArrayList<>();

        Set<String> keys = employeePayment.keySet();
        keys.forEach((key) -> {
            response.add(new EmployeePay(key, employeePayment.get(key).doubleValue()));
        });

        return response;
    }
}