package ast.type;

import visitor.Visitor;

public class None extends AbstractType{

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP parameter) {
        return visitor.visit(this, parameter);
    }

    @Override
    public int numberOfBytes() {
        return 0;
    }

}
