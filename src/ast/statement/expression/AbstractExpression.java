package ast.statement.expression;

import ast.type.Type;
import visitor.Visitor;

public class AbstractExpression implements Expression{

    private boolean lvalue;
    private Type type;

    @Override
    public boolean getLvalue() {
        return lvalue;
    }

    @Override
    public void setLvalue(boolean lvalue) {
        this.lvalue = lvalue;
    }

    @Override
    public Type getType() {
        return type;
    }

    @Override
    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP parameter) {
        return null;
    }

    @Override
    public int getLine() {
        return 0;
    }

    @Override
    public int getColumn() {
        return 0;
    }
}
