package ast.type;

import ast.Locatable;
import ast.statement.expression.Variable;
import visitor.Visitor;

import java.util.List;

public class AbstractType implements Type{

    @Override
    public Type arithmetic(Type t, Locatable locatable) {
        new ErrorType("Ha entrado en AbstractType y no debería", locatable);
        return null;
    }

    @Override
    public Type arithmetic(Locatable locatable) {
        new ErrorType("Ha entrado en AbstractType y no debería", locatable);
        return null;
    }

    @Override
    public Type logic(Type t, Locatable locatable) {
        new ErrorType("Ha entrado en AbstractType y no debería", locatable);
        return null;
    }

    @Override
    public Type logic(Locatable locatable) {
        new ErrorType("Ha entrado en AbstractType y no debería", locatable);
        return null;
    }

    @Override
    public void mustPromoteTo(Type type, Locatable locatable) {
        new ErrorType("Ha entrado en AbstractType y no debería", locatable);
    }

    @Override
    public Type squareBrackets(Type t, Locatable locatable) {
        new ErrorType("Ha entrado en AbstractType y no debería", locatable);
        return null;
    }

    @Override
    public Type parenthesis(List<Type> p, Locatable locatable) {
        new ErrorType("Ha entrado en AbstractType y no debería", locatable);
        return null;
    }

    @Override
    public Type dot(String c, Locatable locatable) {
        new ErrorType("Ha entrado en AbstractType y no debería", locatable);
        return null;
    }

    @Override
    public Type comparison(Type t, Locatable locatable) {
        new ErrorType("Ha entrado en AbstractType y no debería", locatable);
        return null;
    }

    @Override
    public void mustBeLogical(Locatable locatable) {
        new ErrorType("Ha entrado en AbstractType y no debería", locatable);
    }

    @Override
    public void mustBeBuiltIn(Locatable locatable) {
        new ErrorType("Ha entrado en AbstractType y no debería", locatable);
    }

    @Override
    public Type canBeCastTo(Type type, Locatable locatable) {
        new ErrorType("Ha entrado en AbstractType y no debería", locatable);
        return null;
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
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP parameter) {
        new ErrorType("Ha entrado en AbstractType y no debería", new Variable("name", 0, 0));
        return null;
    }
}
