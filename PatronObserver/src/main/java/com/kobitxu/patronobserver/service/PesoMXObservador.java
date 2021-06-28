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
public class PesoMXObservador extends Observador {

    private double valorCambio = 19.07;

    public PesoMXObservador(Subject sujeto) {
        this.sujeto = sujeto;
        this.sujeto.agregar(this);
    }

    @Override
    public void actualizar() {
        System.out.println("MX: " + (sujeto.getEstado() * valorCambio));
    }

}
