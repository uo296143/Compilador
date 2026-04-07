package ast.type;

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
    public String typeExpression() {
        return super.typeExpression();
    }

    @Override
    public Type parenthesis(List<Type> p) {
        return super.parenthesis(p);
    }

    public Type getReturnType() {
        return returnType;
    }

    @Override
    public boolean equivalent(Type t) {
        return super.equivalent(t);
    }

    public List<Statement> getParameters(){
        return List.copyOf(statements);
    }
}
