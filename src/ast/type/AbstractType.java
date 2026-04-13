package ast.type;

import ast.Locatable;
import ast.statement.expression.Variable;
import visitor.Visitor;

import java.util.List;

public class AbstractType implements Type{

    @Override
    public Type arithmetic(Type t, Locatable locatable) {
        return new ErrorType("Ha entrado en AbstractType y no debería", locatable);
    }

    @Override
    public Type arithmetic(Locatable locatable) {
        return new ErrorType("Ha entrado en AbstractType y no debería", locatable);
    }

    @Override
    public Type logic(Type t, Locatable locatable) {
        return new ErrorType("Ha entrado en AbstractType y no debería", locatable);
    }

    @Override
    public Type logic(Locatable locatable) {
        return new ErrorType("Ha entrado en AbstractType y no debería", locatable);
    }

    @Override
    public void mustPromoteTo(Type type, Locatable locatable) {
        new ErrorType("Ha entrado en AbstractType y no debería", locatable);
    }

    @Override
    public Type squareBrackets(Type t, Locatable locatable) {
        return new ErrorType("Ha entrado en AbstractType y no debería", locatable);
    }

    @Override
    public Type parenthesis(List<Type> p, Locatable locatable) {
        return new ErrorType("Ha entrado en AbstractType y no debería", locatable);
    }

    @Override
    public Type dot(String c, Locatable locatable) {
        return new ErrorType("Ha entrado en AbstractType y no debería", locatable);
    }

    @Override
    public Type comparison(Type t, Locatable locatable) {
        return new ErrorType("Ha entrado en AbstractType y no debería", locatable);
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
        return new ErrorType("Ha entrado en AbstractType y no debería", locatable);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;

        return this.getClass() == obj.getClass();
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP parameter) {
        new ErrorType("Ha entrado en AbstractType y no debería", new Variable("name", 0, 0));
        return null;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}
