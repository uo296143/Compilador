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

    /**
     * Creo que solo comprueba que los campos a los que se intenta acceder existen.
     * @param c
     * @param locatable
     * @return
     */
    @Override
    public Type dot(String c, Locatable locatable) {
        for(Field field : fields){
            if(field.getName().equals(c)){
                return field.getType();
            }
        }
        return new ErrorType("El campo : "+c+" no está en el struct", locatable);
    }

    public Field getField(String name){
        for(Field field : fields){
            if(field.getName().equals(name)){
                return field;
            }
        }
        return null;
    }

    public List<Field> getFields() {
        return fields;
    }
}
