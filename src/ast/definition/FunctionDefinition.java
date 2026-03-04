package ast.definition;

import ast.statement.Statement;
import ast.type.Type;

import java.util.List;

public class FunctionDefinition implements Definition {

    private List<Statement> statements;
    private String name;
    private Type type;
    private int line, column;

    public FunctionDefinition(List<Statement> statements, String name, Type type, int line, int column) {
        this.statements = statements;
        this.name = name;
        this.type = type;
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
