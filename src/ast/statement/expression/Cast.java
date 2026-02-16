package ast.statement.expression;

import ast.statement.Assignment;
import ast.type.Type;

public class Cast implements Expression {

    private Assignment assignment;
    private Type castType;

    public Cast(Assignment assignment, Type castType) {
        this.assignment = assignment;
        this.castType = castType;
    }

}
