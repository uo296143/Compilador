package ast.statement.expression.constants;

import ast.statement.expression.Expression;
import parser.LexerHelper;
import visitor.Visitor;

public class IntLiteral implements Expression {

    private int value;
    private int line, column;
    private boolean lvalue;

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

    @Override
    public boolean getLvalue() {
        return lvalue;
    }

    @Override
    public void setLvalue(boolean lvalue) {
        this.lvalue = lvalue;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP parameter) {
        return visitor.visit(this, parameter);
    }
}
