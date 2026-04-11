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
    public void mustPromoteTo(Type type, Locatable locatable) {
        if(!(type instanceof DoubleType)){
            new ErrorType("El tipo double no puede promocionar a : "+type.toString(), locatable);
        }
    }
}
