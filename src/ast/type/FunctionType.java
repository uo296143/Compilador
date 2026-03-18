package ast.type;

import ast.statement.Statement;
import visitor.Visitor;

import java.util.List;

public class FunctionType implements Type{

    private Type returnType;
    private List<Statement> statements;

    public FunctionType(Type returnType, List<Statement> statements) {
        this.returnType = returnType;
        this.statements = statements;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP parameter) {
        return visitor.visit(this, parameter);
    }

    public List<Statement> getStatements() {
        return statements;
    }
}
