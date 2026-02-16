package ast.statement.expression;

import java.util.List;

public class FunctionInvocation implements Expression{

    private Variable function;
    private List<Expression> arguments;

    public FunctionInvocation(Variable function, List<Expression> arguments){
        this.function = function;
        this.arguments = arguments;
    }
    
}
