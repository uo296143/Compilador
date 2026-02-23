package ast.statement.expression;

import ast.type.Type;

public abstract class Constant implements Expression {

    private String value;

    public Constant( String value) {
        this.value = value;
    }

}
