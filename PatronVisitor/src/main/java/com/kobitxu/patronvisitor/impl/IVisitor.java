/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kobitxu.patronvisitor.impl;

import com.kobitxu.patronvisitor.domain.Activitie;
import com.kobitxu.patronvisitor.domain.Employee;
import com.kobitxu.patronvisitor.domain.Project;

/**
 *
 * @author joseph
 * @param <T>
 */
public interface IVisitor<T> {

    public void project(Project project);

    public void activitie(Activitie activitie);

    public void employee(Employee employee);

    public T getResult();
}
