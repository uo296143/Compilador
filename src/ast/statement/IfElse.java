package ast.statement;

import ast.statement.expression.Expression;

import java.util.List;

public class IfElse implements Statement{

    private List<Statement> ifStatements;
    private List<Statement> elseStatements;
    private Expression ifExpression;
    private int line, column;

    public IfElse(List<Statement> ifStatements, Expression ifExpression, int line, int column){
        this.ifStatements = ifStatements;
        this.ifExpression = ifExpression;
        this.line = line;
        this.column = column;
    }

    public IfElse(List<Statement> ifStatements, Expression ifExpression, List<Statement> elseStatements, int line, int column){
        this(ifStatements, ifExpression, line, column);
        this.elseStatements = elseStatements;
        this.line = line;
        this.column = column;
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
