package ast.statement.expression;

public class ComparativeOperator implements Expression {

    private Expression leftExpression;
    private Expression rightExpression;

    public ComparativeOperator(Expression leftExpression, Expression rightExpression) {
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
    }

}
