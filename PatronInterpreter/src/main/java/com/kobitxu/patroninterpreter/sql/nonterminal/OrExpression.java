/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kobitxu.patroninterpreter.sql.nonterminal;

import com.kobitxu.patroninterpreter.sql.Context;
import com.kobitxu.patroninterpreter.sql.InterpreteException;

/**
 *
 * @author joseph
 */
public class OrExpression implements StatementExpression {

    private StatementExpression leftStatement;
    private StatementExpression rightStatement;

    public OrExpression(StatementExpression leftStatement,
            StatementExpression rightStatement) {
        this.leftStatement = leftStatement;
        this.rightStatement = rightStatement;
    }

    @Override
    public Object interpret(Context context) throws InterpreteException {
        Boolean leftReslt = (Boolean) leftStatement.interpret(context);
        Boolean rightReslt = (Boolean) rightStatement.interpret(context);
        return leftReslt || rightReslt;
    }

    @Override
    public String toString() {
        return "( " + leftStatement.toString()
                + " OR " + rightStatement.toString() + " )";
    }
}
