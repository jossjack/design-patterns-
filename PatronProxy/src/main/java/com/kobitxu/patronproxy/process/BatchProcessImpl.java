/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kobitxu.patronproxy.process;

/**
 *
 * @author joseph
 */
public class BatchProcessImpl implements BatchProcess {

    private final String fileName;

    public BatchProcessImpl(String fileName) {
        this.fileName = fileName;
        loadFromDisk(fileName);
    }

    @Override
    public void process() {
        System.out.println("Processing file " + fileName);
    }

    private void loadFromDisk(String fileName) {
        System.out.println("Expensive and hard process...");

        for (int i = 0; i < 10; i++) {
            System.out.println("Loading " + fileName + " " + i * 10 + "%");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {

                System.out.println("Loaded " + fileName);

            }

        }
    }
}
