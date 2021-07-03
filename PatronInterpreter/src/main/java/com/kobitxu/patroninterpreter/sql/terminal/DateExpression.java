/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kobitxu.patroninterpreter.sql.terminal;

import com.kobitxu.patroninterpreter.sql.Context;
import com.kobitxu.patroninterpreter.sql.InterpreteException;
import java.text.SimpleDateFormat;

/**
 *
 * @author joseph
 */
public class DateExpression extends LiteralExpression {

    public DateExpression(String literal) {
        super(literal);
    }

    @Override
    public Object interpret(Context context) throws InterpreteException {
        try {
            SimpleDateFormat dateFormat = context.getDateFormat();
            return dateFormat.parse(literal);
        } catch (Exception e) {
            throw new InterpreteException("Invalid date format '" + literal + "'");
        }
    }

    @Override
    public String toString() {
        return "'" + literal + "'";
    }
}
