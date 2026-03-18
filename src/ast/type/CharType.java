package ast.type;

import visitor.Visitor;

public class CharType implements Type{

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP parameter) {
        return visitor.visit(this, parameter);
    }

}
