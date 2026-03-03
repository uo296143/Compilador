package ast.statement;

import ast.statement.expression.Expression;

public class Assignment implements Statement{

    private Expression rightExpression;
    private Expression leftExpression;
    private int line, column;

    public Assignment(Expression leftExpression, Expression rightExpression, int line, int column){
        this.rightExpression = rightExpression;
        this.leftExpression = leftExpression;
        this.line = line;
        this.column = column;
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
