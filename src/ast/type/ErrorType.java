package ast.type;

import ast.Locatable;

public class ErrorType {

    private String message;
    private Locatable locatable;

    public ErrorType(String message, Locatable locatable){
        this.message = message;
        this.locatable = locatable;
    }

    @Override
    public String toString(){
        return message + ". En la línea: " + locatable.getLine() + " y Columna: " + locatable.getColumn();
    }

}
