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
public class AntivirusSimple extends AnalisisSimple {

    @Override
    void iniciar() {
        System.out.println("Antivirus Simple - Análisis iniciado");
    }

    @Override
    void saltarZip() {
        try {
            System.out.println("Analizando...");
            Thread.sleep(2500);
            System.out.println("No se pudo analizar archivos con extensión '.zip'");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    void detener() {
        System.out.println("Antivirus Simple - Análisis finalizado");
    }
}