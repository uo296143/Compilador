package semantic;

import ast.definition.FunctionDefinition;
import ast.definition.VariableDefinition;
import ast.statement.Statement;
import ast.statement.expression.Variable;
import ast.type.ErrorType;
import errorhandler.ErrorHandler;
import symboltable.SymbolTable;

public class IdentificationVisitor extends AbstractVisitor<Void, Void>{

    private SymbolTable table;

    public IdentificationVisitor(){
        table = new SymbolTable();
    }

    @Override
    public Void visit(FunctionDefinition funcDef, Void o) {
        table.set();
        for(Statement statement : funcDef.getStatements()){
            statement.accept(this, o);
        }
        table.reset();
        return null;
    }

    @Override
    public Void visit(VariableDefinition varDef, Void o) {
        varDef.getType().accept(this, o);
        if(!table.insert(varDef)){
            ErrorHandler.getInstance().addError(
                new ErrorType("Variable repetida: ", varDef));
        }
        return null;
    }

}
