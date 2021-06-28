/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kobitxu.patronobserver.service;

import com.kobitxu.patronobserver.model.Subject;

/**
 *
 * @author joseph
 */
public class SolObservador extends Observador {

    private double valorCambio = 3.25;

    public SolObservador(Subject sujeto) {
        this.sujeto = sujeto;
        this.sujeto.agregar(this);
    }

    @Override
    public void actualizar() {
        System.out.println("PEN: " + (sujeto.getEstado() * valorCambio));
    }
}
