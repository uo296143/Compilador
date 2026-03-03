package ast.statement.expression;

public class NotLogic implements Expression{

    private Expression expression;
    private int line, column;

    public NotLogic(Expression expression, int line, int column) {
        this.expression = expression;
        this.line = line;
        this.column = column;
    }

    public NotLogic(Expression expression) {
        this.expression = expression;
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
