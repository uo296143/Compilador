package codegenerator;

import ast.Program;
import ast.definition.Definition;
import ast.definition.FunctionDefinition;
import ast.definition.VariableDefinition;
import ast.statement.Statement;
import ast.type.Field;
import ast.type.FunctionType;
import ast.type.StructType;
import semantic.AbstractVisitor;

import java.util.List;

public class OffSetVisitor extends AbstractVisitor<Void, Void> {

    @Override
    public Void visit(Program program, Void o) {
        int numberOfBytes = 0;
        for(Definition definition : program.getDefinitions()){
            definition.accept(this, o);
            if(definition instanceof VariableDefinition varDef){
                varDef.setOffset(numberOfBytes);
                numberOfBytes += varDef.getType().numberOfBytes();
            }
        }
        return null;
    }

    @Override
    public Void visit(FunctionDefinition funcDef, Void o) {
        funcDef.getType().accept(this, o);

        // Parámetros : 4 + tamaño de los argumentos a su derecha (sin incluirse)
        List<Statement> statements = ((FunctionType) funcDef.getType()).getParameters();
        int currentOffset = 4;
        for (Statement st : statements.reversed()) {
            VariableDefinition varDef = (VariableDefinition) st;
            varDef.setOffset(currentOffset);
            currentOffset += varDef.getType().numberOfBytes();
        }
        int numberOfBytes = 0;
        for(Statement statement : funcDef.getStatements()){
            statement.accept(this, o);
            if(statement instanceof VariableDefinition varDef){
                // Variables Locales : el tamaño de las anteriores + el de ellas mismas.
                numberOfBytes += varDef.getType().numberOfBytes();
                varDef.setOffset(-numberOfBytes);
            }
        }
        return null;
    }

    @Override
    public Void visit(StructType structType, Void o) {
        int currentOffSet = 0;
        for(Field field : structType.getFields()){
            field.accept(this, o);
            field.setOffset(currentOffSet);
            currentOffSet += field.getType().numberOfBytes();
        }
        return null;
    }

}
