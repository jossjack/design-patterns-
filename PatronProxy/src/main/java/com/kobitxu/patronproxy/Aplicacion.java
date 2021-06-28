/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kobitxu.patronproxy;

import com.kobitxu.patronproxy.process.BatchProcess;
import com.kobitxu.patronproxy.proxy.ProxyBatchProcess;

/**
 *
 * @author joseph
 */
public class Aplicacion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        BatchProcess batchProcess = new ProxyBatchProcess("big_file.txt");

        //batchProcess will be loaded from disk
        System.out.println("BatchProcess will be loaded from disk");
        batchProcess.process();

        System.out.println("-----------------");

        //batchProcess will not be loaded from disk
        System.out.println("BatchProcess will not be loaded from disk");
        batchProcess.process();
    }

}
