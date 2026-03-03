package ast.statement.expression;

import ast.type.Type;

public class Variable implements Expression{

    private String name;
    private Type type;
    private int line;
    private int column;

    public Variable(String name, Type type, int line, int column){
        this.name = name;
        this.type = type;
        this.line = line;
        this.column = column;
    }

    public Variable(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Type getType() {
        return type;
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
