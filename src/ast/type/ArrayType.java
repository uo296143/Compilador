package ast.type;

import visitor.Visitor;

public class ArrayType implements Type{

    private Type of;
    private int size;

    public ArrayType(Type of, String size){
        this.of = of;
        this.size = Integer.parseInt(size);
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP parameter) {
        return visitor.visit(this, parameter);
    }
}
