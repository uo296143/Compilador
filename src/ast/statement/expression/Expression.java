package ast.statement.expression;

import ast.Locatable;
import ast.type.Type;

public interface Expression extends Locatable {

    public boolean getLvalue();
    public void setLvalue(boolean lvalue);
    public Type getType();
    public void setType(Type type);

}
