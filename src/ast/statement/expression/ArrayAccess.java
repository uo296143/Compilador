package ast.statement.expression;

public class ArrayAccess implements Expression{

    private Expression leftExpression, rightExpression;
    private int line, column;

    public ArrayAccess(Expression leftExpression, Expression rightExpression){
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
    }

    public ArrayAccess(Expression leftExpression, Expression rightExpression, int line, int column){
        this(leftExpression, rightExpression);
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
