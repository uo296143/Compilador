package ast.statement.expression;

import ast.definition.Definition;
import ast.type.Type;
import visitor.Visitor;

public class Variable extends AbstractExpression{

    private String name;
    private int line;
    private int column;
    private boolean lvalue;
    private Definition definition;

    public Variable(String name) {
        this.name = name;
    }

    public Variable(String name, int line, int column){
        this.name=name;
        this.line = line;
        this.column = column;
    }

    public String getName() {
        return name;
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

    @Override
    public boolean getLvalue() {
        return lvalue;
    }

    @Override
    public void setLvalue(boolean lvalue) {
        this.lvalue = lvalue;
    }

    public Definition getDefinition() {
        return definition;
    }

    public void setDefinition(Definition definition){
        this.definition = definition;
    }

    @Override
    public String toString(){
        return name;
    }

}
