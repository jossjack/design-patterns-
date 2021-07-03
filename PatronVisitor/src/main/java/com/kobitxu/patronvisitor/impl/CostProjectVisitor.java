/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kobitxu.patronvisitor.impl;

import com.kobitxu.patronvisitor.domain.Employee;
import com.kobitxu.patronvisitor.domain.Project;

/**
 *
 * @author joseph
 */
public class CostProjectVisitor implements IVisitor<Number> {

    private double totalCost;

    @Override
    public void project(Project project) {
        project.getActivities().forEach((act) -> {
            act.accept(this);
        });
    }

    @Override
    public void activitie(com.kobitxu.patronvisitor.domain.Activitie activitie) {
        activitie.getResponsible().accept(this);
        activitie.getActivities().forEach((act) -> {
            act.accept(this);
        });
    }

    @Override
    public void employee(Employee employee) {
        totalCost += employee.getPrice();
    }

    @Override
    public Number getResult() {
        return totalCost;
    }
}
