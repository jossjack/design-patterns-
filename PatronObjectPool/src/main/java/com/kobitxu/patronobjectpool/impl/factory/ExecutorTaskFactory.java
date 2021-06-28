/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kobitxu.patronobjectpool.impl.factory;

import com.kobitxu.patronobjectpool.impl.poolable.ExecutorTask;

/**
 *
 * @author joseph
 */
public class ExecutorTaskFactory implements IPoolableObjectFactory<ExecutorTask> {

    @Override
    public ExecutorTask createNew() {
        return new ExecutorTask();
    }
}
