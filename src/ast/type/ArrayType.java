package ast.type;

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
    public String typeExpression() {
        return of.toString();
    }

    @Override
    public Type squareBrackets(Type t) {
        return t.equals(new IntType()) ? of : new ErrorType("El tipo para acceder al array no es válido", new Variable("fake", 0,0));
    }

    @Override
    public boolean equivalent(Type t) {
        return ;
    }

    public Type getOf(){
        return of;
    }
}
