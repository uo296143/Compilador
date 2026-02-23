package ast.statement;

import ast.statement.expression.Expression;
import ast.statement.expression.Variable;

import java.util.List;

public class FunctionInvocation implements Statement {

    private Variable function;
    private List<Expression> arguments;

    public FunctionInvocation(Variable function, List<Expression> arguments){
        this.function = function;
        this.arguments = arguments;
    }
    
}
