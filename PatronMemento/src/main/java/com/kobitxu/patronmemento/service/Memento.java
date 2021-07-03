/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kobitxu.patronmemento.service;

import com.kobitxu.patronmemento.model.Juego;

/**
 *
 * @author joseph
 */
public class Memento {

    private Juego estado;

    public Memento(Juego estado) {
        this.estado = estado;
    }

    public Juego getEstado() {
        return estado;
    }
}
