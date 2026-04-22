package ast.type;

import ast.Locatable;
import visitor.Visitor;

public class DoubleType extends AbstractType{

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP parameter) {
        return visitor.visit(this, parameter);
    }

    @Override
    public Type arithmetic(Type t, Locatable locatable){
        if(t instanceof ErrorType){
            return t;
        }
        return new DoubleType();

    }

    @Override
    public Type arithmetic(Locatable locatable) {
        return this;
    }

    @Override
    public void mustPromoteTo(Type type, Locatable locatable) {

        if(!(type instanceof DoubleType)){
            new ErrorType("El tipo double no puede promocionar a : "+type.toString(), locatable);
        }
    }

    @Override
    public Type comparison(Type t, Locatable locatable) {
        if(t instanceof ErrorType){
            return this;
        }
        t.mustBeBuiltIn(locatable);
        return t;
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
        return 4;
    }

    @Override
    public char suffix() {
        return 'f';
    }
}
