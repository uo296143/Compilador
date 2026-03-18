package ast.statement.expression;

import visitor.Visitor;

public class NotLogic implements Expression{

    private Expression expression;
    private int line, column;
    private boolean lvalue;

    public NotLogic(Expression expression, int line, int column) {
        this.expression = expression;
        this.line = line;
        this.column = column;
    }

    public NotLogic(Expression expression) {
        this.expression = expression;
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

    public Expression getExpression() {
        return expression;
    }
}
