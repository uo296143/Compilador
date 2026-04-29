package ast.type;

import ast.Locatable;
import ast.statement.expression.Variable;
import visitor.Visitor;

public class IntType extends AbstractType{

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP parameter) {
        return visitor.visit(this, parameter);
    }

    public Type arithmetic(Type t, Locatable locatable){
        if(t instanceof CharType || t instanceof IntType){
            return new IntType();
        }else{
            if(t instanceof DoubleType){
                return new DoubleType();
            }else{
                if(!(t instanceof ErrorType)){
                    return new ErrorType("No se pudo llevar a cabo la operación aritmética",
                            locatable);
                }

            }
        }
        return t; // Sino se propaga el error.
    }

    @Override
    public Type arithmetic(Locatable locatable) {
        return this;
    }

    @Override
    public void mustPromoteTo(Type type, Locatable locatable) {
        if(!(type instanceof IntType || type instanceof DoubleType)){
            new ErrorType("El tipo int no puede promocionar a : "+type.toString(), locatable);
        }
    }

    @Override
    public Type logic(Type t, Locatable locatable) {
        if(t instanceof ErrorType){
            return this;
        }
        if(t instanceof CharType || t instanceof IntType)
            return new IntType();
        return new ErrorType("No se puede hacer una operación lógica con "+t.toString(),locatable);
    }

    @Override
    public Type logic(Locatable locatable) {
        return this;
    }

    @Override
    public Type comparison(Type t, Locatable locatable) {
        if(t instanceof ErrorType){
            return this;
        }
        t.mustBeBuiltIn(locatable);
        return new IntType();
    }

    @Override
    public void mustBeLogical(Locatable locatable) {
    }

    @Override
    public Type canBeCastTo(Type type, Locatable locatable) {
        if(type instanceof ErrorType){
            return this;
        }
        if(type instanceof CharType){
            return type;
        }else{
            if(type instanceof IntType){
                return type;
            }else{
                if(type instanceof DoubleType){
                    return type;
                }else{
                    return new ErrorType("El tipo al que se quiere castear no es un tipo simple", locatable);
                }
            }
        }
    }

    @Override
    public void mustBeBuiltIn(Locatable locatable) {
    }

    @Override
    public int numberOfBytes() {
        return 2;
    }

    @Override
    public char suffix() {
        return 'i';
    }

    @Override
    public Type superType(Type type){
        if(type.equals(new IntType()) || type.equals(new CharType())){
            return this;
        }
        if(type.equals(new DoubleType())){
            return new DoubleType();
        }
        return new ErrorType("Error en superType, el tipo no es un tipo simple", new Variable("", 0, 0));
    }
}
