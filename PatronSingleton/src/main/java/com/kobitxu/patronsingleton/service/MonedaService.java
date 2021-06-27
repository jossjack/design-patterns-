/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kobitxu.patronsingleton.service;

import com.kobitxu.patronsingleton.dao.MonedaDAO;
import com.kobitxu.patronsingleton.dao.impl.MonedaDAOImpl;
import com.kobitxu.patronsingleton.model.Moneda;
import java.util.List;

/**
 *
 * @author joseph
 */
public class MonedaService {

    //crear un objeto estatico de la instancia MonedaService
    private static MonedaService instance;
    
    //crear una lista privada de objetos moneda
    private final List<Moneda> lmoneda;

    //interfaz de acceso a datos
    private final MonedaDAO dao;

    //no permitir que la clase sea instanciada por el operador "new"
    private MonedaService() {
        dao = new MonedaDAOImpl();
        lmoneda = dao.getListadoMonedas();
    }

    //acceder a la instancia a traves del metodo getInstance
    public static MonedaService getInstance() {
        if (instance == null) {
            instance = new MonedaService();
        }
        return instance;
    }

    //Obtener la lista de monedas en una unica instancia
    public List<Moneda> listar() {
        return lmoneda;
    }
}
