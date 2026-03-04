package ast.statement.expression.constants;

import ast.statement.expression.Expression;
import parser.LexerHelper;

public class IntLiteral implements Expression {

    private int value;
    private int line, column;

    public IntLiteral(String value, int line, int column) {
        this.value = LexerHelper.lexemeToInt(value);
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
