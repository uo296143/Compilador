package ast.type;

import ast.Locatable;
import ast.definition.VariableDefinition;
import ast.statement.Statement;
import visitor.Visitor;

import java.util.List;

public class FunctionType extends AbstractType{

    private Type returnType;
    private List<Statement> statements;

    public FunctionType(Type returnType, List<Statement> statements) {
        this.returnType = returnType;
        this.statements = statements;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP parameter) {
        return visitor.visit(this, parameter);
    }

    public List<Statement> getStatements() {
        return statements;
    }

    public Type getReturnType() {
        return returnType;
    }

    public List<Statement> getParameters(){
        return List.copyOf(statements);
    }

    /**
     * Comprueba que los tipos de los argumentos con los que se invoca una función sean los mismos
     * que se definieron.
     * @param p
     * @param locatable
     * @return
     */
    @Override
    public Type parenthesis(List<Type> p, Locatable locatable) {
        int contador = 0;
        for(Statement statement : statements){
            if(p.size() != statements.size()){
                return new ErrorType("Se deberían haber pasado "+ statements.size() +" parámetros y se han pasado "+p.size()+" parámetros.", locatable);
            }
            if( ! ((VariableDefinition)statement).getType().equals(p.get(contador)) ){
                return new ErrorType("El tipo de los argumentos no coincide con el tipo de los parámetros", locatable);
            }
            contador++;
        }
        return null;
    }

    @Override
    public void mustPromoteTo(Type type, Locatable locatable) {
        if( ! type.equals(returnType) ){
            new ErrorType("El tipo de retorno " + returnType.toString() + " no coincide con el la variable", locatable);
        }
    }
}
