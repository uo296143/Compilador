package ast.type;

import ast.Locatable;
import visitor.Visitor;

import java.util.List;

public class StructType extends AbstractType{

    private List<Field> fields;

    public StructType(List<Field> fields){
        this.fields = fields;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP parameter) {
        return visitor.visit(this, parameter);
    }


    @Override
    public Type dot(String c, Locatable locatable) {
        return null;
    }

    public Field getField(String name){
        for(Field field : fields){
            if(field.getName().equals(name)){
                return field;
            }
        }
        return null;
    }
}
