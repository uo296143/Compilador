package ast.statement.expression.constants;

import ast.statement.expression.Constant;

public class IntLiteral extends Constant {

    public IntLiteral(String value, int line, int column) {
        super(value, line, column);
    }
}
