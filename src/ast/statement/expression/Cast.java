package ast.statement.expression;

import ast.statement.Assignment;
import ast.type.Type;
import visitor.Visitor;

public class Cast extends AbstractExpression {

    private Expression expression;
    private Type castType;
    private int line, column;

    public Cast(Expression expression,Type castType, int line, int column) {
        this.expression = expression;
        this.castType = castType;
        this.line = line;
        this.column = column;
    }

    public Cast(Expression expression, Type castType) {
        this.expression = expression;
        this.castType = castType;
    }

    @Override
    public int getLine() {
        return line;
    }

    @Override
    public int getColumn() {
        return column;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP parameter) {
        return visitor.visit(this, parameter);
    }

    public Expression getExpression() {
        return expression;
    }
}
