/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kobitxu.patroninterpreter.sql.nonterminal;

import com.kobitxu.patroninterpreter.sql.AbstractSQLExpression;
import com.kobitxu.patroninterpreter.sql.Context;
import com.kobitxu.patroninterpreter.sql.InterpreteException;
import java.util.List;

/**
 *
 * @author joseph
 */
public class SelectExpression implements AbstractSQLExpression {

    private final TargetExpression target;
    private final FromExpression from;
    private final WhereExpression where;

    public SelectExpression(TargetExpression columns,
            FromExpression table, WhereExpression where) {
        this.target = columns;
        this.from = table;
        this.where = where;
    }

    public SelectExpression(TargetExpression columns,
            FromExpression table) {
        this.target = columns;
        this.from = table;
        this.where = new WhereExpression(null);
    }

    @Override
    public List<Object[]> interpret(Context context)
            throws InterpreteException {
        from.interpret(context);
        where.interpret(context);
        target.interpret(context);
        return context.getResultArray();
    }

    @Override
    public String toString() {
        return "SELECT " + target.toString() + " "
                + from.toString() + " " + where.toString();
    }
}
