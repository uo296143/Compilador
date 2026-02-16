package ast.statement.expression;

public class ArithmeticOperator implements Expression {

    private Expression leftExpression;
    private Expression rightExpression;

    public ArithmeticOperator(Expression leftExpression, Expression rightExpression) {
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
    }

}
