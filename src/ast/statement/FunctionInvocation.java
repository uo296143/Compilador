package ast.statement;

import ast.statement.expression.Expression;
import ast.statement.expression.Variable;
import visitor.Visitor;

import java.util.List;

public class FunctionInvocation implements Statement, Expression {

    private Variable function;
    private List<Expression> arguments;
    private int line, column;
    private boolean lvalue;

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

    @Override
    public boolean getLvalue() {
        return lvalue;
    }

    @Override
    public void setLvalue(boolean lvalue) {
        this.lvalue = lvalue;
    }
}
