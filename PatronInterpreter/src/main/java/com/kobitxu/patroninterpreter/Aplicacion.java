/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kobitxu.patroninterpreter;

import com.kobitxu.patroninterpreter.sql.Context;
import com.kobitxu.patroninterpreter.sql.InterpreteException;
import com.kobitxu.patroninterpreter.sql.nonterminal.AndExpression;
import com.kobitxu.patroninterpreter.sql.nonterminal.BooleanExpression;
import com.kobitxu.patroninterpreter.sql.nonterminal.FromExpression;
import com.kobitxu.patroninterpreter.sql.nonterminal.OrExpression;
import com.kobitxu.patroninterpreter.sql.nonterminal.SelectExpression;
import com.kobitxu.patroninterpreter.sql.nonterminal.TargetExpression;
import com.kobitxu.patroninterpreter.sql.nonterminal.WhereExpression;
import com.kobitxu.patroninterpreter.sql.terminal.DateExpression;
import com.kobitxu.patroninterpreter.sql.terminal.LiteralExpression;
import com.kobitxu.patroninterpreter.sql.terminal.NumericExpression;
import com.kobitxu.patroninterpreter.sql.terminal.TextExpression;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author joseph
 */
public class Aplicacion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Abstract Syntactic Tree
        SelectExpression select = getById();
        System.out.println(select.toString());
        Context context = new Context("META-INF/Employee.xls");
        context.setDateFormat(new SimpleDateFormat("dd/MM/yyyy"));
        try {
            List<Object[]> output = select.interpret(context);
            for (Object[] object : output) {
                System.out.println(Arrays.toString(object));
            }
        } catch (InterpreteException e) {
            e.printStackTrace();
        } finally {
            context.destroy();
        }
    }

    public static SelectExpression getById() {
        SelectExpression select = new SelectExpression(
                new TargetExpression(
                        new LiteralExpression("FIRST_NAME"),
                        new LiteralExpression("LAST_NAME")
                ),
                new FromExpression(
                        new LiteralExpression("EMPLOYEES")),
                new WhereExpression(
                        new BooleanExpression(
                                new LiteralExpression("ID"),
                                new LiteralExpression("="),
                                new NumericExpression(10)
                        )
                )
        );
        return select;
    }

    public static SelectExpression findByDate() {
        SelectExpression select = new SelectExpression(
                new TargetExpression(
                        new LiteralExpression("ID"),
                        new LiteralExpression("BORN_DATE"),
                        new LiteralExpression("DEPARTMENT"),
                        new LiteralExpression("FIRST_NAME"),
                        new LiteralExpression("LAST_NAME")
                ),
                new FromExpression(
                        new LiteralExpression("EMPLOYEES")),
                new WhereExpression(
                        new BooleanExpression(
                                new LiteralExpression("BORN_DATE"),
                                new LiteralExpression(">"),
                                new DateExpression("01/01/1990")
                        )
                )
        );
        return select;
    }

    public static SelectExpression findByTwoID() {
        SelectExpression select = new SelectExpression(
                new TargetExpression(
                        new LiteralExpression("FIRST_NAME"),
                        new LiteralExpression("DEPARTMENT"),
                        new LiteralExpression("ID")
                ),
                new FromExpression(
                        new LiteralExpression("EMPLOYEES")),
                new WhereExpression(
                        new OrExpression(
                                new BooleanExpression(
                                        new LiteralExpression("ID"),
                                        new LiteralExpression("="),
                                        new NumericExpression(5)
                                ),
                                new BooleanExpression(
                                        new LiteralExpression("ID"),
                                        new LiteralExpression("="),
                                        new NumericExpression(14)
                                )
                        )
                )
        );
        return select;
    }

    public static SelectExpression complexQuery() {
        SelectExpression select = new SelectExpression(
                new TargetExpression(
                        new LiteralExpression("FIRST_NAME"),
                        new LiteralExpression("LAST_NAME")
                ),
                new FromExpression(
                        new LiteralExpression("EMPLOYEES")),
                new WhereExpression(
                        new AndExpression(
                                new BooleanExpression(
                                        new LiteralExpression("STATUS"),
                                        new LiteralExpression("="),
                                        new TextExpression("Active")
                                ),
                                new AndExpression(
                                        new BooleanExpression(
                                                new LiteralExpression("BORN_DATE"),
                                                new LiteralExpression("<="),
                                                new DateExpression("01/01/1981")
                                        ),
                                        new OrExpression(
                                                new BooleanExpression(
                                                        new LiteralExpression("DEPARTMENT"),
                                                        new LiteralExpression("="),
                                                        new TextExpression("IT")
                                                ),
                                                new BooleanExpression(
                                                        new LiteralExpression("DEPARTMENT"),
                                                        new LiteralExpression("="),
                                                        new TextExpression("Accounting")
                                                )
                                        )
                                )
                        )
                )
        );
        return select;
    }
}
