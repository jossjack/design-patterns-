/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kobitxu.patronproxy.proxy;

import com.kobitxu.patronproxy.process.BatchProcess;
import com.kobitxu.patronproxy.process.BatchProcessImpl;

/**
 *
 * @author joseph
 */
public class ProxyBatchProcess implements BatchProcess {

    private BatchProcessImpl batchProcess;
    private String fileName;

    public ProxyBatchProcess(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void process() {
        if (batchProcess == null) {
            batchProcess = new BatchProcessImpl(fileName);

            batchProcess.process();
        }
    }
}
