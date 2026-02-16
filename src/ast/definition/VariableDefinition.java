package ast.definition;

import ast.statement.Statement;
import ast.type.Type;

import java.util.List;

public class VariableDefinition implements Definition, Statement {

    private List<Statement> statements;
    private Type type;
    private String name;

    public VariableDefinition(List<Statement> statements, Type type, String name) {
        this.statements = statements;
        this.type = type;
        this.name = name;
    }

    @Override
    public Type getType() {
        return type;
    }

    @Override
    public String getName() {
        return name;
    }

}
