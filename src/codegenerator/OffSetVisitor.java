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
        // Parámetros : 4 + tamaño de los argumentos a su derecha (sin incluirse)
        List<Statement> statements = ((FunctionType) funcDef.getType()).getParameters();
        int currentParamOffset = 4;
        int totalParamsSize = 0;

        for (Statement st : statements.reversed()) {
            VariableDefinition param = (VariableDefinition) st;
            param.setOffset(currentParamOffset);

            int size = param.getType().numberOfBytes();
            currentParamOffset += size;
            totalParamsSize += size;
        }
        // Guardamos el total de la memoria de las variables locales para la instrucción 'ret'
        ((FunctionType)funcDef.getType()).setNumberOfBytesOfParameters(totalParamsSize);
        int numberOfBytes = 0;
        int totalLocalsSize = 0;
        for(Statement statement : funcDef.getStatements()){
            statement.accept(this, o);
            if(statement instanceof VariableDefinition varDef){
                // Variables Locales : el tamaño de las anteriores + el de ellas mismas.
                int size = varDef.getType().numberOfBytes();
                numberOfBytes += size;
                totalLocalsSize += size;
                varDef.setOffset(-numberOfBytes);
            }
        }
        // Guardamos el total para la instrucción 'enter'
        funcDef.setNumberOfBytesOfLocalVariables(totalLocalsSize);
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
