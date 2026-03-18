package ast.definition;

import ast.statement.Statement;
import ast.type.Type;
import visitor.Visitor;

import java.util.List;

public class FunctionDefinition implements Definition {

    private List<Statement> statements;
    private String name;
    private Type type;
    private int line, column;
    private int scope;

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
    public int getScope() {
        return scope;
    }

    @Override
    public void setScope(int scope) {
        this.scope = scope;
    }

    @Override
    public int getLine() {
        return line;
    }

    public List<Statement> getStatements() {
        return statements;
    }

    @Override
    public int getColumn() {
        return column;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP parameter) {
        return visitor.visit(this, parameter);
    }

    @Override
    public String toString(){
        return name;
    }
}
