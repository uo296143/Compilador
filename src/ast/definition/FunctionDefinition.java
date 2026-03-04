package ast.definition;

import ast.statement.Statement;
import ast.type.Type;

import java.util.List;

public class FunctionDefinition implements Definition {

    private List<Statement> statements;
    private VariableDefinition variable;
    private int line, column;

    public FunctionDefinition(List<Statement> statements, VariableDefinition variable, int line, int column) {
        this.statements = statements;
        this.variable = variable;
        this.line = line;
        this.column = column;
    }

    @Override
    public Type getType() {
        return variable.getType();
    }

    @Override
    public String getName() {
        return variable.getName();
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
