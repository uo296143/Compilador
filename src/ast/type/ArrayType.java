package ast.type;

public class ArrayType implements Type{

    private Type of;
    private int size;

    public ArrayType(Type of, String size){
        this.of = of;
        this.size = Integer.parseInt(size);
    }
}
