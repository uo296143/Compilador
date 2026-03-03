package ast.statement.expression;

public class Point implements Expression{

    private String fieldName;
    private Expression leftExpression;
    private int line, column;

    public Point(Expression leftExpression, String fieldName, int line, int column){
        this.fieldName = fieldName;
        this.leftExpression = leftExpression;
        this.line = line;
        this.column = column;
    }

    public Point(Expression leftExpression, String fieldName){
        this.fieldName = fieldName;
        this.leftExpression = leftExpression;
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
