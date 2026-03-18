package ast.definition;

import ast.Locatable;
import ast.type.Type;

public interface Definition extends Locatable {

    public Type getType();
    public String getName();
    public int getScope();
    public void setScope(int scope);

}
