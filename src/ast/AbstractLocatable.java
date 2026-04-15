package ast;

import visitor.Visitor;

public class AbstractLocatable implements Locatable{

    private int line, column;

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
        return null;
    }
}
