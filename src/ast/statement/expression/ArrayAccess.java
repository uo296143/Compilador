package ast.statement.expression;

public class ArrayAccess implements Expression{

    private Expression expression;

    public ArrayAccess(Expression expression){
        this.expression = expression;
    }
    
}
