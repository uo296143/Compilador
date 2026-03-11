package ast.statement;

import ast.statement.expression.Expression;
import visitor.Visitor;

public class Assignment implements Statement{

    private Expression leftExpression;
    private Expression rightExpression;
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

    public Expression getLeftExpression() {
        return leftExpression;
    }

    public void setLeftExpression(Expression leftExpression) {
        this.leftExpression = leftExpression;
    }

    public Expression getRightExpression() {
        return rightExpression;
    }

    public void setRightExpression(Expression rightExpression) {
        this.rightExpression = rightExpression;
    }


    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP parameter) {
        return visitor.visit(this, parameter);
    }
}
