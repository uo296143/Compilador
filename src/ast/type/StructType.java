package ast.type;

import visitor.Visitor;

import java.util.List;

public class StructType implements Type{

    private List<Field> fields;

    public StructType(List<Field> fields){
        this.fields = fields;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP parameter) {
        return visitor.visit(this, parameter);
    }

}
