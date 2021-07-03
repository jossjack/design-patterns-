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
public class TextExpression extends LiteralExpression {

    public TextExpression(String literal) {
        super(literal);
    }

    @Override
    public String interpret(Context context) {
        return literal;
    }

    @Override
    public String toString() {
        return "'" + literal + "'";
    }
}
