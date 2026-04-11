package ast.type;

import ast.Locatable;
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
    public void mustPromoteTo(Type type, Locatable locatable) {
        if(!(type instanceof IntType || type instanceof DoubleType)){
            new ErrorType("El tipo int no puede promocionar a : "+type.toString(), locatable);
        }
    }
}
