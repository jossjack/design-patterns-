/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kobitxu.patroninterpreter.sql.terminal;

import com.kobitxu.patroninterpreter.sql.AbstractSQLExpression;
import com.kobitxu.patroninterpreter.sql.Context;
import com.kobitxu.patroninterpreter.sql.InterpreteException;

/**
 *
 * @author joseph
 */
public class LiteralExpression implements AbstractSQLExpression {

    protected String literal;

    public LiteralExpression(String literal) {
        this.literal = literal;
    }

    @Override
    public Object interpret(Context context) throws InterpreteException {
        return literal;
    }

    @Override
    public String toString() {
        return literal;
    }
}
