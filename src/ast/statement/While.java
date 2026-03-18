package ast.statement;

import ast.statement.expression.Expression;
import visitor.Visitor;

import java.util.List;

public class While implements Statement{

    private List<Statement> statements;
    private Expression expression;
    private int line, column;

    public While(List<Statement> statements, Expression expression, int line, int column){
        this.statements = statements;
        this.expression = expression;
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

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP parameter) {
        return visitor.visit(this, parameter);
    }

    public List<Statement> getStatements() {
        return statements;
    }

    public Expression getExpression() {
        return expression;
    }
}
