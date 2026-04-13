package ast.statement;

import ast.statement.expression.AbstractExpression;
import ast.statement.expression.Expression;
import ast.statement.expression.Variable;
import ast.type.Type;
import visitor.Visitor;

import java.util.List;

public class FunctionInvocation extends AbstractExpression implements Statement {

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

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP parameter) {
        return visitor.visit(this, parameter);
    }

    public List<Expression> getArguments() {
        return arguments;
    }

    public Variable getFunction() {
        return function;
    }

    public void setFunction(Variable variable){
        this.function = variable;
    }

    @Override
    public String toString(){
        return function.getName();
    }
}
