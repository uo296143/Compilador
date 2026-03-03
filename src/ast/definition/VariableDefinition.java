package ast.definition;

import ast.statement.Statement;
import ast.type.Type;

import java.util.List;

public class VariableDefinition implements Definition, Statement {

    // private List<Statement> statements;
    private Type type; // Será siempre un FunctionType
    private String name;
    private int line, column;

    public VariableDefinition(Type type, String name, int line, int column) {
        this.type = type;
        this.name = name;
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
    public int getLine() {
        return line;
    }

    @Override
    public int getColumn() {
        return column;
    }
}
