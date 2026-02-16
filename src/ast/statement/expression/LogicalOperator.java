package ast.statement.expression;

public class LogicalOperator implements Expression {

    private Expression leftExpression;
    private Expression rightExpression;

    public LogicalOperator(Expression leftExpression, Expression rightExpression) {
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
    }

}
