package ast.statement;

import ast.statement.expression.Expression;

public class Assignment implements Statement{

    private Expression rightExpression;
    private Expression leftExpression;

    public Assignment(Expression rightExpression, Expression leftExpression){
        this.rightExpression = rightExpression;
        this.leftExpression = leftExpression;
    }

}
