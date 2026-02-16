package ast.type;

public class Array implements Type{

    private Type of;

    public Array(Type of){
        this.of = of;
    }
}
