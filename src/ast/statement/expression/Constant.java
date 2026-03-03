package ast.statement.expression;

import ast.type.Type;

public abstract class Constant implements Expression {

    private String value;
    private int line, column;

    public Constant(String value, int line, int column) {
        this.value = value;
        this.line = line;
        this.column = column;
    }

    public Constant(String value) {
        this.value = value;
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
