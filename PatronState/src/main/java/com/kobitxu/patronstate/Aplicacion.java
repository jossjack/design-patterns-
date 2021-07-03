/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kobitxu.patronstate;

import com.kobitxu.patronstate.gui.ServerPanel;
import javax.swing.JFrame;

/**
 *
 * @author joseph
 */
public class Aplicacion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setTitle("State pattern");
        frame.setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE);
        frame.add(new ServerPanel());
        frame.pack();
        frame.setVisible(true);
    }
}
