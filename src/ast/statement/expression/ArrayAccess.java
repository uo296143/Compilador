package ast.statement.expression;

import visitor.Visitor;

public class ArrayAccess extends AbstractExpression{

    private Expression leftExpression, rightExpression;
    private int line, column;
    private boolean lvalue;

    public ArrayAccess(Expression leftExpression, Expression rightExpression){
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
    }

    public ArrayAccess(Expression leftExpression, Expression rightExpression, int line, int column){
        this(leftExpression, rightExpression);
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

    public Expression getLeftExpression() {
        return leftExpression;
    }

    public Expression getRightExpression() {
        return rightExpression;
    }

}
