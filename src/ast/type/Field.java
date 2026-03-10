package ast.type;

public class Field {

    private String name;
    private Type type;

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return ((Field) obj).getName().equals(this.name);
    }

    public Field(String name, Type type) {
        this.name = name;
        this.type = type;
    }

    public String getName(){return name;}
}
