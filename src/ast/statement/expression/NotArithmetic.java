package ast.statement.expression;

public class NotArithmetic implements Expression{

    private Expression expression;

    public NotArithmetic(Expression expression){
        this.expression = expression;
    }
}
