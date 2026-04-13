package ast.type;

import ast.Locatable;
import visitor.Visitor;

public class CharType extends AbstractType{

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP parameter) {
        return visitor.visit(this, parameter);
    }

    /**
     * Un char puede hacer operaciones aritméticas con un char y resultará un INT,
     * si las hace con un INT resultará un INT y con un DOUBLE otro DOUBLE.
     * @param t
     * @param locatable
     * @return
     */
    @Override
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

    /**
     * El tipo CHAR debe promocionar a : DOUBLE e INT
     * @param type
     * @param locatable
     */
    @Override
    public void mustPromoteTo(Type type, Locatable locatable) {
        if(!(type instanceof CharType || type instanceof IntType || type instanceof DoubleType)){
            new ErrorType("El tipo char no puede promocionar a : "+type.toString(), locatable);
        }
    }

    @Override
    public Type logic(Type t, Locatable locatable) {
        if(t instanceof CharType || t instanceof IntType)
            return t;
        return new ErrorType("No se puede hacer una operación lógica con "+t.toString(),locatable);
    }

    @Override
    public Type comparison(Type t, Locatable locatable) {
        t.mustBeBuiltIn(locatable);
        return t;
    }

    @Override
    public void mustBeLogical(Locatable locatable) {

    }
}
