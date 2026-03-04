package ast.statement.expression;

import ast.type.Type;

public class Variable implements Expression{

    private String name;
    private int line;
    private int column;

    public Variable(String name) {
        this.name = name;
    }

    public Variable(String name, int line, int column){
        this.line = line;
        this.column = column;
    }

    public String getName() {
        return name;
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
