/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kobitxu.patronobjectpool.impl;

import com.kobitxu.patronobjectpool.impl.factory.IPoolableObjectFactory;
import com.kobitxu.patronobjectpool.impl.poolable.ExecutorTask;

/**
 *
 * @author joseph
 */
public class ExecutorThreadPool extends AbstractObjectPool<ExecutorTask> {
    
    public ExecutorThreadPool(int minInstances, int maxInstances, int waitTime, IPoolableObjectFactory<ExecutorTask> poolableObjectFactory) {
        super(minInstances, maxInstances, waitTime, poolableObjectFactory);
    }
}
