package ast.type;

import ast.Locatable;

public class ErrorType {

    private String message;
    private Locatable locatable;

    public ErrorType(String message, Locatable locatable){
        this.message = message;
        this.locatable = locatable;
    }

    // Línea y columna del error
    public String toString(){
        return "";
    }
}
