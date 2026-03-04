package ast.statement.expression.constants;

import ast.statement.expression.Expression;
import parser.LexerHelper;

public class DoubleLiteral implements Expression {

    private double value;
    private int line, column;

    public DoubleLiteral(String value, int line, int column) {
        this.value = LexerHelper.lexemeToReal(value);
        this.line = line;
        this.column = column;
    }

    @Override
    public int getLine() {
        return line;
    }

    @Override
    public int getColumn() {
        return column;
    }
}
