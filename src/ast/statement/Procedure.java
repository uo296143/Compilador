package ast.statement;

import ast.statement.expression.Expression;
import ast.statement.expression.Variable;

import java.util.List;

public class Procedure implements Statement{

    private Variable variable;
    private List<Expression> parameters;

    public Procedure(Variable variable, List<Expression> parameters){
        this.variable = variable;
        this.parameters = parameters;
    }
}
