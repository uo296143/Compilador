package ast.type;

import ast.Locatable;
import ast.statement.expression.Variable;
import visitor.Visitor;

public class ArrayType extends AbstractType{

    private Type of;
    private int size;

    public ArrayType(Type of, String size){
        this.of = of;
        this.size = Integer.parseInt(size);
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP parameter) {
        return visitor.visit(this, parameter);
    }

    @Override
    public Type squareBrackets(Type t, Locatable locatable) {
        if(t instanceof ErrorType){
            return this;
        }
        return ( t.equals(new IntType()) || t.equals(new CharType()) ) ? of : new ErrorType("El tipo para acceder al array no es válido", locatable);
    }

    public Type getOf(){
        return of;
    }

    @Override
    public int numberOfBytes() {
        return of.numberOfBytes()*size;
    }
}
