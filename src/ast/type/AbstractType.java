package ast.type;

import ast.statement.expression.Variable;
import visitor.Visitor;

import java.util.List;

public class AbstractType implements Type{
    @Override
    public String typeExpression() {
        new ErrorType("Ha entrado en AbstractType y no debería", new Variable("name", 0, 0));
        return "";
    }

    @Override
    public Type arithmetic(Type t) {
        new ErrorType("Ha entrado en AbstractType y no debería", new Variable("name", 0, 0));
        return null;
    }

    @Override
    public Type squareBrackets(Type t) {
        new ErrorType("Ha entrado en AbstractType y no debería", new Variable("name", 0, 0));
        return null;
    }

    @Override
    public Type parenthesis(List<Type> p) {
        new ErrorType("Ha entrado en AbstractType y no debería", new Variable("name", 0, 0));
        return null;
    }

    @Override
    public Type dot(String c) {
        new ErrorType("Ha entrado en AbstractType y no debería", new Variable("name", 0, 0));
        return null;
    }

    @Override
    public boolean equivalent(Type t) {
        new ErrorType("Ha entrado en AbstractType y no debería", new Variable("name", 0, 0));
        return false;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public Type comparison(Type t) {
        new ErrorType("Ha entrado en AbstractType y no debería", new Variable("name", 0, 0));
        return null;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP parameter) {
        new ErrorType("Ha entrado en AbstractType y no debería", new Variable("name", 0, 0));
        return null;
    }
}
