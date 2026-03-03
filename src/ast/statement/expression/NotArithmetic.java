package ast.statement.expression;

public class NotArithmetic implements Expression{

    private Expression expression;
    private int line, column;

    public NotArithmetic(Expression expression, int line, int column){
        this.expression = expression;
        this.line = line;
        this.column = column;
    }


    public NotArithmetic(Expression expression){
        this.expression = expression;
    }

    @Override
    public int getLine() {
        return 0;
    }

    @Override
    public int getColumn() {
        return 0;
    }
}
