package ast.statement;

import ast.statement.expression.Expression;

public class Return implements Statement {

    private Expression returnExpression;

    public Return(Expression returnExpression) {
        this.returnExpression = returnExpression;
    }

}
