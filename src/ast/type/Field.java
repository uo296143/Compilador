package ast.type;

public class Field {

    private String name;
    private Type type;

    public Field(String name, Type type) {
        this.name = name;
        this.type = type;
    }
}
