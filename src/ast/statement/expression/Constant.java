package ast.statement.expression;

import ast.type.Type;

public class Constant implements Expression {

    private Type type;
    private String name;
    private String value;

    public Constant(Type type, String name, String value) {
        this.type = type;
        this.name = name;
        this.value = value;
    }

}
