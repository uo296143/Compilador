package ast.statement.expression;

public class Point implements Expression{

    private String fieldName;
    private Expression leftExpression;

    public Point(String fieldName, Expression leftExpression){
        this.fieldName = fieldName;
        this.leftExpression = leftExpression;
    }
}
