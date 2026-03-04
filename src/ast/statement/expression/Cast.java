package ast.statement.expression;

import ast.statement.Assignment;
import ast.type.Type;

public class Cast implements Expression {

    private Expression expression;
    private Type castType;
    private int line, column;

    public Cast(Expression expression,Type castType, int line, int column) {
        this.expression = expression;
        this.castType = castType;
        this.line = line;
        this.column = column;
    }

    public Cast(Expression expression, Type castType) {
        this.expression = expression;
        this.castType = castType;
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
