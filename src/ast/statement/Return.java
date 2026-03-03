package ast.statement;

import ast.statement.expression.Expression;

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
}
