package ast.type;

import ast.statement.Statement;

import java.util.List;

public class FunctionType {

    private Type returnType;
    private List<Statement> statements;

    public FunctionType(Type returnType, List<Statement> statements) {
        this.returnType = returnType;
        this.statements = statements;
    }

}
