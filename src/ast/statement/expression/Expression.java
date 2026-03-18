package ast.statement.expression;

import ast.Locatable;

public interface Expression extends Locatable {

    public boolean getLvalue();
    public void setLvalue(boolean lvalue);

}
