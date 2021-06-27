/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kobitxu.patronsingleton;

import com.kobitxu.patronsingleton.model.Moneda;
import com.kobitxu.patronsingleton.service.MonedaService;
import java.util.List;

/**
 *
 * @author joseph
 */
public class Aplicacion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MonedaService service = MonedaService.getInstance();
        List<Moneda> lMoneda = service.listar();

        lMoneda.stream()
                .forEach(System.out::println);
    }
}
