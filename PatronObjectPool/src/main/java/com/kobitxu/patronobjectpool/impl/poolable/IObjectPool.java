/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kobitxu.patronobjectpool.impl.poolable;

import com.kobitxu.patronobjectpool.impl.IPooledObject;
import com.kobitxu.patronobjectpool.impl.PoolException;

/**
 *
 * @author joseph
 * @param <T>
 */
public interface IObjectPool<T extends IPooledObject> {

    public T getObject() throws PoolException;

    public void releaseObject(T pooledObject);
}
