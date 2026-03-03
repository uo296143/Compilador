package ast.statement.expression;

public class ArithmeticOperator implements Expression {

    private Expression leftExpression;
    private Expression rightExpression;
    private String operator;
    private int line, column;

    public ArithmeticOperator(String operator, Expression leftExpression, Expression rightExpression, int line, int column) {
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
        this.operator = operator;
        this.line = line;
        this.column = column;
    }

    public ArithmeticOperator(String operator, Expression leftExpression, Expression rightExpression) {
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
        this.operator = operator;
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
