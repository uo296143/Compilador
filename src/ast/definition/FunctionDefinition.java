package ast.definition;

import ast.statement.Statement;
import ast.statement.expression.Variable;
import ast.type.Type;

import java.util.List;

public class FunctionDefinition implements Definition {

    private List<Statement> statements;
    private Variable variable;

    public FunctionDefinition(List<Statement> statements, Variable variable) {
        this.statements = statements;
        this.variable = variable;
    }

    @Override
    public Type getType() {
        return variable.getType();
    }

    @Override
    public String getName() {
        return variable.getName();
    }

}
