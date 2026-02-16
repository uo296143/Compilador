package ast.statement.expression;

import ast.type.Type;

public class Variable implements Expression{

    private String name;
    private Type type;
    private int line;

    public Variable(String name, Type type, int line){
        this.name = name;
        this.type = type;
        this.line = line;
    }

    public String getName() {
        return name;
    }

    public Type getType() {
        return type;
    }

    public int getLine() {
        return line;
    }

}
