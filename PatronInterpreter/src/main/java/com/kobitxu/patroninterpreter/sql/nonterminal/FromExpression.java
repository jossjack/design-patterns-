/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kobitxu.patroninterpreter.sql.nonterminal;

import com.kobitxu.patroninterpreter.sql.AbstractSQLExpression;
import com.kobitxu.patroninterpreter.sql.Context;
import com.kobitxu.patroninterpreter.sql.InterpreteException;
import com.kobitxu.patroninterpreter.sql.terminal.LiteralExpression;

/**
 *
 * @author joseph
 */
public class FromExpression implements AbstractSQLExpression {

    private LiteralExpression table;

    public FromExpression(LiteralExpression from) {
        this.table = from;
    }

    @Override
    public Object interpret(Context context)
            throws InterpreteException {
        String tableName
                = table.interpret(context).toString();
        if (!context.tableExist(tableName)) {
            throw new InterpreteException(
                    "The table '" + tableName + "' not exist");
        }
        return null;
    }

    @Override
    public String toString() {
        return "FROM " + table.toString();
    }
}
