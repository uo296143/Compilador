package semantic;

import ast.definition.Definition;
import ast.definition.FunctionDefinition;
import ast.definition.VariableDefinition;
import ast.statement.FunctionInvocation;
import ast.statement.Input;
import ast.statement.Statement;
import ast.statement.expression.Expression;
import ast.statement.expression.Variable;
import ast.type.ErrorType;
import symboltable.SymbolTable;

public class IdentificationVisitor extends AbstractVisitor<Void, Void>{

    private SymbolTable table;

    public IdentificationVisitor(){
        table = new SymbolTable();
    }

    @Override
    public Void visit(FunctionDefinition funcDef, Void o) {
        table.set();
        if(!table.insert(funcDef)){
            new ErrorType("Funcion repetida : ", funcDef);
        }
        funcDef.getType().accept(this, o);
        for(Statement statement : funcDef.getStatements()){
            statement.accept(this, o);
        }
        table.reset();
        return null;
    }

    @Override
    public Void visit(VariableDefinition varDef, Void o) {
        varDef.getType().accept(this, o);
        System.out.println("NOmbre de la variable ->"+varDef.getName()+"  -> tipo - "+varDef.getType());
        if(!table.insert(varDef)){
            new ErrorType("Variable_e repetida: ", varDef);
        }
        return null;
    }

    @Override
    public Void visit(Input input, Void o) {
        for(Expression e: input.getExpressions()) {
            e.accept(this, o);
            if(table.find(((Variable)e).getName()) == null){
                new ErrorType("Variable no definida: ", e);
            }
        }
        return null;
    }

    @Override
    public Void visit(FunctionInvocation funcInvoc, Void o) {
        funcInvoc.getFunction().accept(this, o);
        for(Expression expression : funcInvoc.getArguments()){
            expression.accept(this, o);
        }
        if(table.find(funcInvoc.getFunction().getName()) == null){
            new ErrorType("Funcion no definida: ", funcInvoc);
        }
        return null;
    }

}
