package ast.type;

import ast.Locatable;
import visitor.Visitor;

public class CharType extends AbstractType{

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP parameter) {
        return visitor.visit(this, parameter);
    }

    @Override
    public Type arithmetic(Type t, Locatable locatable){
        return null;
    }
}
