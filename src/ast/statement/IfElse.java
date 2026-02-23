package ast.statement;

import ast.statement.expression.Expression;

import java.util.List;

public class IfElse implements Statement{

    private List<Statement> ifStatements;
    private List<Statement> elseStatements;
    private Expression ifExpression;

    public IfElse(List<Statement> ifStatements, Expression ifExpression){
        this.ifStatements = ifStatements;
        this.ifExpression = ifExpression;
    }

    public IfElse(List<Statement> ifStatements, Expression ifExpression, List<Statement> elseStatements){
        this(ifStatements, ifExpression);
        this.elseStatements = elseStatements;
    }

}
