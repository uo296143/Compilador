package ast.statement;

import ast.statement.expression.Expression;

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
}
