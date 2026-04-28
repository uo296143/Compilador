package ast.type;

import ast.Locatable;
import ast.definition.VariableDefinition;
import ast.statement.Statement;
import visitor.Visitor;

import java.util.List;

public class FunctionType extends AbstractType{

    private Type returnType;
    private List<VariableDefinition> parameters;
    private int numberOfBytesOfParameters;

    public FunctionType(Type returnType, List<VariableDefinition> statements) {
        this.returnType = returnType;
        this.parameters = statements;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP parameter) {
        return visitor.visit(this, parameter);
    }

    public List<VariableDefinition> getParameters() {
        return parameters;
    }

    public Type getReturnType() {
        return returnType;
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
        if (p.size() != parameters.size()) {
            return new ErrorType("Esperados " + parameters.size() + " parámetros, recibidos " + p.size(), locatable);
        }
        for (int i = 0; i < parameters.size(); i++) {
            Type paramType = ((VariableDefinition) parameters.get(i)).getType();
            Type argType = p.get(i);

            try {
                argType.mustPromoteTo(paramType, locatable);
            } catch (Exception e) {
                return new ErrorType("El argumento " + i + " no es compatible", locatable);
            }
        }
        return this.returnType;
    }

    @Override
    public void mustPromoteTo(Type type, Locatable locatable) {

        if( ! type.equals(returnType) ){
            new ErrorType("El tipo de retorno " + returnType.toString() + " no coincide con el la variable", locatable);
        }
    }

    public int getNumberOfBytesOfParameters() {
        return numberOfBytesOfParameters;
    }

    public void setNumberOfBytesOfParameters(int numberOfBytesOfParameters) {
        this.numberOfBytesOfParameters = numberOfBytesOfParameters;
    }

}
