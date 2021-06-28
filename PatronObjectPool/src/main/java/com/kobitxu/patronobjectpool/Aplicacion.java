/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kobitxu.patronobjectpool;

import com.kobitxu.patronobjectpool.impl.ExecutorThreadPool;
import com.kobitxu.patronobjectpool.impl.PoolException;
import com.kobitxu.patronobjectpool.impl.factory.ExecutorTaskFactory;
import com.kobitxu.patronobjectpool.impl.poolable.ExecutorTask;
import java.io.IOException;

/**
 *
 * @author joseph
 */
public class Aplicacion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        final ExecutorThreadPool pool = new ExecutorThreadPool(2, 6, 1000 + 100, new ExecutorTaskFactory());
        for (int c = 0; c < 10; c++) {
            new Thread(() -> {
                try {
                    ExecutorTask task = pool.getObject();
                    task.execute();
                    pool.releaseObject(task);
                } catch (PoolException e) {
                    System.out.println("Error ==> " + e.getMessage());
                }
            }).start();
        }

        try {
            System.in.read();
            System.out.println(pool);
        } catch (IOException e) {
            System.out.println("Out disponible");
        }
    }
}
