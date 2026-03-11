package ast.statement;

import ast.statement.expression.Expression;
import visitor.Visitor;

import java.util.List;

public class Input implements Statement{

    private List<Expression> expressions;
    private int line, column;

    public Input(List<Expression> expressions){
        this.expressions = expressions;
    }

    public Input(List<Expression> expressions, int line, int column){
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

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP parameter) {
        return visitor.visit(this, parameter);
    }

    public List<Expression> getExpressions() {
        return expressions;
    }

    public void setExpressions(List<Expression> expressions) {
        this.expressions = expressions;
    }
}
