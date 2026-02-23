package ast.statement.expression;

import ast.statement.Assignment;
import ast.type.Type;

public class Cast implements Expression {

    private Type castType;

    public Cast(Type castType) {
        this.castType = castType;
    }

}
