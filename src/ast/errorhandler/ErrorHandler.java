package ast.errorhandler;

import ast.type.ErrorType;

import java.io.PrintStream;

public class ErrorHandler {

    public void addError(ErrorType errorType){

    }

    public void showErrors(PrintStream stream){

    }

    public boolean anyError(){
        return true;
    }

    public static ErrorHandler getInstance(){
        return null;
    }
}
