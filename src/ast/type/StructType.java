package ast.type;

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
    public String typeExpression() {
        return super.typeExpression();
    }

    @Override
    public Type dot(String c) {
        return super.dot(c);
    }

    @Override
    public boolean equivalent(Type t) {
        return super.equivalent(t);
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
