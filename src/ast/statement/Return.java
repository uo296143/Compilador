package ast.statement;

import ast.statement.expression.Expression;
import visitor.Visitor;

public class Return implements Statement {

    private Expression returnExpression;
    private int line, column;

    public Return(Expression returnExpression, int line, int column) {
        this.returnExpression = returnExpression;
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

    public Expression getReturnExpression() {
        return returnExpression;
    }
}
