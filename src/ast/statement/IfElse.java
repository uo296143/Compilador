package ast.statement;

import ast.statement.expression.Expression;
import visitor.Visitor;

import java.util.List;

public class IfElse implements Statement{

    private List<Statement> ifBody;
    private List<Statement> elseBody;
    private Expression expression;
    private int line, column;

    public IfElse(List<Statement> ifBody, Expression expression, List<Statement> elseBody, int line, int column){
        this.ifBody = ifBody;
        this.expression = expression;
        this.elseBody = elseBody;
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
}
