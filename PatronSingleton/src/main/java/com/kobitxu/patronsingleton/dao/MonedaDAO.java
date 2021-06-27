/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kobitxu.patronsingleton.dao;

import com.kobitxu.patronsingleton.model.Moneda;
import java.util.List;

/**
 *
 * @author joseph
 */
public interface MonedaDAO {

    public List<Moneda> getListadoMonedas();
}
