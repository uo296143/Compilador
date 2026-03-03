package ast.statement;

import ast.statement.expression.Expression;
import ast.statement.expression.Variable;

import java.util.List;

public class FunctionInvocation implements Statement {

    private Variable function;
    private List<Expression> arguments;
    private int line, column;

    public FunctionInvocation(Variable function, List<Expression> arguments, int line, int column){
        this.function = function;
        this.arguments = arguments;
        this.line = line;
        this.column = column;
    }

    public FunctionInvocation(Variable function, List<Expression> arguments){
        this.function = function;
        this.arguments = arguments;
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
