package ast.definition;

import ast.statement.Statement;
import ast.type.Type;

import java.util.List;

public class VariableDefinition implements Definition, Statement {

    private Type type;
    private String name;
    private int line, column;

    public VariableDefinition(Type type, String name) {
        this.type = type;
        this.name = name;
    }

    public VariableDefinition(Type type, String name, int line, int column) {
        this(type, name);
        this.line = line;
        this.column = column;
    }

    @Override
    public Type getType() {
        return type;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return ((VariableDefinition) obj).getName().equals(this.getName());
    }

    @Override
    public int getLine() {
        return line;
    }

    @Override
    public String toString() {
        return name + ", ";
    }

    @Override
    public int getColumn() {
        return column;
    }
}
