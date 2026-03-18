package ast.statement.expression;


import visitor.Visitor;

public class ComparativeOperator implements Expression {

    private Expression leftExpression;
    private Expression rightExpression;
    private String operator;
    private int line, column;
    private boolean lvalue;

    public ComparativeOperator(String operator, Expression leftExpression, Expression rightExpression, int line, int column) {
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
        this.operator = operator;
        this.line = line;
        this.column = column;
    }

    public ComparativeOperator(String operator, Expression leftExpression, Expression rightExpression) {
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
        this.operator = operator;
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
