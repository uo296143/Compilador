package ast.statement.expression.constants;

import ast.statement.expression.AbstractExpression;
import ast.statement.expression.Expression;
import ast.type.Type;
import parser.LexerHelper;
import visitor.Visitor;

public class CharLiteral extends AbstractExpression {

    private char value;
    private int line, column;

    public CharLiteral(String value, int line, int column) {
        this.value = LexerHelper.lexemeToChar(value);
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
