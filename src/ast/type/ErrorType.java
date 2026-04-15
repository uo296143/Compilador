package ast.type;

import ast.Locatable;
import ast.statement.expression.Variable;
import errorhandler.ErrorHandler;
import visitor.Visitor;

import java.util.List;

public class ErrorType extends AbstractType {

    private String message;
    private Locatable locatable;

    public ErrorType(String message, Locatable locatable) {
        this.message = message;
        this.locatable = locatable;
        ErrorHandler.getInstance().addError(this);
    }

    @Override
    public String toString() {
        return message + " (" + locatable.toString() + ") . En la línea: " + locatable.getLine() + " y Columna: " + locatable.getColumn();
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP parameter) {
        return visitor.visit(this, parameter);
    }

    @Override
    public Type arithmetic(Type t, Locatable locatable) {
        return this;
    }

    @Override
    public Type arithmetic(Locatable locatable) {
        return this;
    }

    @Override
    public Type logic(Type t, Locatable locatable) {
        return this;
    }

    @Override
    public Type logic(Locatable locatable) {
        return this;
    }

    @Override
    public Type squareBrackets(Type t, Locatable locatable) {
        return this;
    }

    @Override
    public Type parenthesis(List<Type> p, Locatable locatable) {
        return this;
    }

    @Override
    public Type dot(String c, Locatable locatable) {
        return this;
    }

    @Override
    public Type comparison(Type t, Locatable locatable) {
        return this;
    }

    @Override
    public Type canBeCastTo(Type type, Locatable locatable) {
        return this;
    }


}
