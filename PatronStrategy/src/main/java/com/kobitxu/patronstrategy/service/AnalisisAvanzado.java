/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kobitxu.patronstrategy.service;

/**
 *
 * @author joseph
 */
public abstract class AnalisisAvanzado implements IEstrategia {

    @Override
    public void analizar() {
        iniciar();
        analizarMemoria();
        analizarKeyloggers();
        analizarRootKits();
        descomprimirZip();
        detener();
    }

    abstract void iniciar();

    abstract void analizarMemoria();

    abstract void analizarKeyloggers();

    abstract void analizarRootKits();

    abstract void descomprimirZip();

    abstract void detener();
}
