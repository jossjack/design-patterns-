/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kobitxu.patronobjectpool.impl;

import com.kobitxu.patronobjectpool.impl.factory.IPoolableObjectFactory;
import com.kobitxu.patronobjectpool.impl.poolable.IObjectPool;
import java.util.Calendar;
import java.util.Stack;
import java.util.UUID;

/**
 *
 * @author joseph
 * @param <T>
 */
public abstract class AbstractObjectPool<T extends IPooledObject> implements IObjectPool<T> {

    private final int minInstances;
    private final int maxInstances;
    private final int waitTime;

    private final IPoolableObjectFactory<T> poolableObjectFactory;

    private final Stack<PooledObjectStatus<T>> fullStack = new Stack();
    private final Stack<PooledObjectStatus<T>> useStack = new Stack();
    private final Stack<PooledObjectStatus<T>> freeStack = new Stack();

    public AbstractObjectPool(int minInstances, int maxInstances, int waitTime, IPoolableObjectFactory<T> poolableObjectFactory) {
        System.out.println("========== STARTING ==========");
        this.minInstances = minInstances;
        this.maxInstances = maxInstances;
        this.waitTime = waitTime;
        this.poolableObjectFactory = poolableObjectFactory;
        initPool();
        System.out.println("========== FINISH ==========");
        System.out.println("");
    }

    private void initPool() {
        for (int c = fullStack.size(); c < minInstances; c++) {
            PooledObjectStatus<T> createNewPooledObject = createNewPooledObject();
            freeStack.push(createNewPooledObject);
        }
    }

    @Override
    public void releaseObject(T pooledObject) {
        for (PooledObjectStatus<T> item : this.fullStack) {
            if (item.pooledObject == pooledObject) {
                if (pooledObject.validate()) {
                    freeStack.push(item);
                    useStack.remove(item);
                    item.used = Boolean.FALSE;
                    System.out.println("Object returned > " + item.uuid.toString());
                    return;
                } else {
                    System.out.println("Object invalidate ==> " + item.uuid.toString());
                    pooledObject.invalidate();
                    fullStack.remove(item);
                    useStack.remove(item);
                    synchronized (freeStack) {
                        initPool();
                    }
                    return;
                }
            }
        }
    }

    @Override
    public String toString() {
        return "AbstractObjectPool ==> currentSize > " + fullStack.size() + ", " + "free > " + freeStack.size() + ", used > " + useStack.size();
    }

    private T waitForResource() throws PoolException {
        Calendar future = Calendar.getInstance();
        future.add(Calendar.MILLISECOND, waitTime);
        do {
            PooledObjectStatus<T> returnObject = null;
            synchronized (freeStack) {
                if (!freeStack.isEmpty() && !freeStack.peek().used) {
                    returnObject = freeStack.pop();
                    returnObject.used = Boolean.TRUE;
                    useStack.push(returnObject);
                    System.out.println("Provisioning3 Object > " + returnObject.uuid.toString());
                    return returnObject.pooledObject;
                }
            }

            if (returnObject == null || returnObject.used) {
                if (waitTime != 0 && System.currentTimeMillis() >= future.getTimeInMillis()) {
                    throw new PoolException("Tiempo de espera agotado");
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                }
            }
        } while (true);
    }

    @Override
    public T getObject() throws PoolException {
        T internalObject = getInternalObject();
        if (internalObject != null) {
            return internalObject;
        }

        return waitForResource();
    }

    private T getInternalObject() throws PoolException {
        synchronized (freeStack) {
            if (!freeStack.isEmpty()) {
                PooledObjectStatus<T> first = this.freeStack.pop();
                first.used = Boolean.TRUE;
                System.out.println("Provisioning1 Object > " + first.uuid.toString());
                useStack.push(first);
                return first.pooledObject;
            }

            synchronized (fullStack) {
                if (fullStack.size() < maxInstances) {
                    PooledObjectStatus<T> returnObject = createNewPooledObject();
                    returnObject.used = Boolean.TRUE;
                    System.out.println("Provisioning2 Object > " + returnObject.uuid.toString());
                    useStack.push(returnObject);
                    return returnObject.pooledObject;
                } else {
                    return null;
                }
            }
        }
    }

    private PooledObjectStatus<T> createNewPooledObject() {
        T newObject = poolableObjectFactory.createNew();
        PooledObjectStatus<T> pooled = new PooledObjectStatus<>(newObject);
        fullStack.push(pooled);
        System.out.println("New PoolableObject{UUID=" + pooled.uuid.toString() + ", poolSize=" + fullStack.size() + "}");
        return pooled;
    }

    private static class PooledObjectStatus<T> {

        boolean used;
        UUID uuid;
        T pooledObject;

        public PooledObjectStatus(T pooledObject) {
            this.used = Boolean.FALSE;
            this.uuid = UUID.randomUUID();
            this.pooledObject = pooledObject;
        }

    }

}
