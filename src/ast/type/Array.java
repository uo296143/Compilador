package ast.type;

public class Array implements Type{

    private Type of;
    private int size;

    public Array(Type of, String size){
        this.of = of;
        this.size = Integer.parseInt(size);
    }
}
