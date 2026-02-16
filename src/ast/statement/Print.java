package ast.statement;

import ast.statement.expression.Expression;

import java.util.List;

public class Print implements Statement{

    private List<Expression> expressions;

    public Print(List<Expression> expressions){
        this.expressions = expressions;
    }

}
