package ast.statement;

import ast.statement.expression.Expression;
import visitor.Visitor;

import java.util.List;

public class Print implements Statement{

    private List<Expression> expressions;
    private int line, column;

    public Print(List<Expression> expressions){
        this.expressions = expressions;
    }

    public Print(List<Expression> expressions, int line, int column){
        this(expressions);
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

    public List<Expression> getExpressions() {
        return expressions;
    }

    public void setExpressions(List<Expression> expressions) {
        this.expressions = expressions;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP parameter) {
        return visitor.visit(this, parameter);
    }
}
