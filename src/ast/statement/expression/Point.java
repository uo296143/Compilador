package ast.statement.expression;

import visitor.Visitor;

public class Point extends AbstractExpression{

    private String fieldName;
    private Expression leftExpression;
    private int line, column;
    private boolean lvalue;

    public Point(Expression leftExpression, String fieldName, int line, int column){
        this.fieldName = fieldName;
        this.leftExpression = leftExpression;
        this.line = line;
        this.column = column;
    }

    public Point(Expression leftExpression, String fieldName){
        this.fieldName = fieldName;
        this.leftExpression = leftExpression;
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

    public String getFieldName(){
        return fieldName;
    }
}
