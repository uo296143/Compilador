package ast.statement.expression.constants;

import ast.statement.expression.Expression;
import parser.LexerHelper;

public class CharLiteral implements Expression {

    private char value;
    private int line, column;

    public CharLiteral(String value, int line, int column) {
        this.value = LexerHelper.lexemeToChar(value);
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
