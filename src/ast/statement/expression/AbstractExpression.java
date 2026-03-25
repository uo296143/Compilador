package ast.statement.expression;

import ast.type.Type;
import visitor.Visitor;

public class AbstractExpression implements Expression{
    @Override
    public boolean getLvalue() {
        return false;
    }

    @Override
    public void setLvalue(boolean lvalue) {

    }

    @Override
    public Type getType() {
        return null;
    }

    @Override
    public void setType(Type type) {

    }

    @Override
    public int getLine() {
        return 0;
    }

    @Override
    public int getColumn() {
        return 0;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP parameter) {
        return null;
    }
}
