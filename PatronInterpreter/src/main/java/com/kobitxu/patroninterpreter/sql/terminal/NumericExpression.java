/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kobitxu.patroninterpreter.sql.terminal;

import com.kobitxu.patroninterpreter.sql.Context;

/**
 *
 * @author joseph
 */
public class NumericExpression extends LiteralExpression {

    private final Number number;

    public NumericExpression(Number num) {
        super(null);
        this.number = num;
    }

    @Override
    public Object interpret(Context context) {
        return number;
    }

    @Override
    public String toString() {
        return number.toString();
    }
}
