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
import ast.type.Type;
import symboltable.SymbolTable;
import visitor.Visitor;

public class IdentificationVisitor extends AbstractVisitor<Void, Void>{

    private SymbolTable table;

    public IdentificationVisitor(){
        table = new SymbolTable();
    }

    @Override
    public Void visit(FunctionDefinition funcDef, Void o) {
        if(!table.insert(funcDef)){
            new ErrorType("Funcion repetida : ", funcDef);
        }
        table.set();
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
        if(!table.insert(varDef)){
            new ErrorType("Variable_e repetida: ", varDef);
        }
        return null;
    }

    @Override
    public Void visit(Variable var, Void o) {
        Definition def = table.find(var.getName());
        if(def == null){
            var.setType(new ErrorType("Variable no definida: ", var));
        }
        var.setDefinition(def);
        return null;
    }

    @Override
    public Void visit(FunctionInvocation funcInvoc, Void o) {
        funcInvoc.getFunction().accept(this, o);
        for(Expression expression : funcInvoc.getArguments()){
            expression.accept(this, o);
        }
        /*Definition def = table.find(funcInvoc.getFunction().getName());
        if(def == null){
            new ErrorType("Funcion no definida: ", funcInvoc);
        }*/
        return null;
    }

}
