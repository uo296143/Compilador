package errorhandler;

import ast.type.ErrorType;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class ErrorHandler {

    private static final ErrorHandler errorHandler = new ErrorHandler();

    private List<ErrorType> errors;

    private ErrorHandler() {
        this.errors = new ArrayList<>();
    }

    public void addError(ErrorType errorType){
        if (errorType != null) {
            this.errors.add(errorType);
        }
    }

    public void showErrors(PrintStream stream){
        for (ErrorType error : errors) {
            stream.println(error.toString());
        }
    }

    public boolean anyError(){
        return !errors.isEmpty();
    }

    public static ErrorHandler getInstance(){
        return errorHandler;
    }
}
