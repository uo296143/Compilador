package ast.type;

import java.util.List;

public class Struct implements Type{

    private List<Field> fields;

    public Struct(List<Field> fields){
        this.fields = fields;
    }

}
