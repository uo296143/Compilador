package ast.type;

import java.util.List;

public class StructType implements Type{

    private List<Field> fields;

    public StructType(List<Field> fields){
        this.fields = fields;
    }

}
