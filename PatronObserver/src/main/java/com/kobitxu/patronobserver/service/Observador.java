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
public abstract class Observador {

    protected Subject sujeto;

    public abstract void actualizar();
}
