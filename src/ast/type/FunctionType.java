package ast.type;

import ast.Locatable;
import ast.statement.Statement;
import visitor.Visitor;

import java.util.List;

public class FunctionType extends AbstractType{

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

    @Override
    public Type parenthesis(List<Type> p, Locatable locatable) {
        return null;
    }

    public Type getReturnType() {
        return returnType;
    }

    public List<Statement> getParameters(){
        return List.copyOf(statements);
    }
}
