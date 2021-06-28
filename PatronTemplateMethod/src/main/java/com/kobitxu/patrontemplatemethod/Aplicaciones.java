/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kobitxu.patrontemplatemethod;

import com.kobitxu.patrontemplatemethod.impl.DrugstoreFileProcess;
import com.kobitxu.patrontemplatemethod.impl.GroceryFileProcess;
import java.io.File;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author joseph
 */
public class Aplicaciones extends TimerTask {

    private static final String[] PATHS = new String[]{"C:/files/drugstore", "C:/files/grocery"};
    private static final String LOG_DIR = "C:/files/logs";
    private static final String PROCESS_DIR = "C:/files/process";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new Aplicaciones().start();
    }

    public void start() {
        try {
            Timer timer = new Timer();
            timer.schedule(this, new Date(), (long) 1000 * 10);
            System.in.read();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        System.out.println("> Monitoring start");
        File f = new File(PATHS[0]);
        if (!f.exists()) {
            throw new RuntimeException("El path '" + PATHS[0] + "' no existe");
        }
        File[] drugstoreFiles = f.listFiles();
        for (File file : drugstoreFiles) {
            try {
                System.out.println("> File found > " + file.getName());
                new DrugstoreFileProcess(file, LOG_DIR, PROCESS_DIR).execute();
                System.out.println("Processed file > " + file.getName());
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }

        f = new File(PATHS[1]);
        if (!f.exists()) {
            throw new RuntimeException("El path '" + PATHS[1] + "' no existe");
        }
        System.out.println("> Read Path " + PATHS[1]);
        File[] groceryFiles = f.listFiles();
        for (File file : groceryFiles) {
            try {
                System.out.println("> File found > " + file.getName());
                new GroceryFileProcess(file, LOG_DIR, PROCESS_DIR).execute();
                System.out.println("Processed file > " + file.getName());
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
    }
}
