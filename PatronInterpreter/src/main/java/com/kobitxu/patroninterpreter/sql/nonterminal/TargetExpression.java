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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

/**
 *
 * @author joseph
 */
public class TargetExpression implements AbstractSQLExpression {

    private List<LiteralExpression> targets = new ArrayList<LiteralExpression>();

    public TargetExpression(LiteralExpression... expressions) {
        this.targets = Arrays.asList(expressions);
    }

    @Override
    public Void interpret(Context context) throws InterpreteException {
        context.createResultArray(targets.size());

        List<Row> resultRow = context.getResultRow();
        for (Row row : resultRow) {
            Object[] result = context.createRow();
            int col = 0;

            for (LiteralExpression literalExpression : targets) {
                String column = literalExpression.interpret(context).toString();
                context.tableColumn(column);
                int columnIndex = context.columnIndex(column);
                Cell cell = row.getCell(columnIndex);
                cell.setCellType(Cell.CELL_TYPE_STRING);
                String value = cell.getStringCellValue();
                result[col++] = value;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        String output = "";
        for (LiteralExpression literalExpression : targets) {
            output += ", " + literalExpression.toString();
        }
        return output.substring(2);
    }
}
