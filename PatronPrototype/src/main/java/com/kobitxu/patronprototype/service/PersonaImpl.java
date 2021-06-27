/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kobitxu.patronprototype.service;

import com.kobitxu.patronprototype.model.IPersona;

/**
 *
 * @author joseph
 */
public class PersonaImpl implements IPersona {

    private String nombre;
    private Integer edad;

    @Override
    public IPersona clonar() {
        PersonaImpl persona = null;
        try {
            persona = (PersonaImpl) clone();
        } catch (CloneNotSupportedException e) {
        }
        return persona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PersonaImpl{nombre=").append(nombre);
        sb.append(", edad=").append(edad);
        sb.append('}');
        return sb.toString();
    }
}
