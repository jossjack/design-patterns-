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
public class PriceProjectVisitor implements IVisitor<Number> {

    private double totalPrice;

    @Override
    public void project(Project project) {
        project.getActivities().forEach((act) -> {
            act.accept(this);
        });
    }

    @Override
    public void activitie(com.kobitxu.patronvisitor.domain.Activitie activitie) {
        totalPrice += activitie.getPrice();
        activitie.getActivities().forEach((act) -> {
            act.accept(this);
        });
    }

    @Override
    public void employee(Employee employee) {
        // Not Interesting for this Visitor  
    }

    @Override
    public Number getResult() {
        return totalPrice;
    }
}
