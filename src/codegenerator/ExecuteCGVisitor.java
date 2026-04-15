package codegenerator;

import ast.definition.VariableDefinition;
import ast.statement.*;


public class ExecuteCGVisitor extends AbstractCGVisitor<Void, Void>{

    private CodeGenerator codeGenerator;
    private AddressCGVisitor address;
    private ValueCGVisitor value;

    public ExecuteCGVisitor(CodeGenerator codeGenerator) {
        this.codeGenerator = codeGenerator;
        address = new AddressCGVisitor(codeGenerator);
        value = new ValueCGVisitor(codeGenerator);
    }

    @Override
    public Void visit(VariableDefinition varDef, Void o) {

        return null;
    }

    @Override
    public Void visit(Assignment assignment, Void o) {
        return null;
    }

    @Override
    public Void visit(FunctionInvocation funcInvoc, Void o) {
        return null;
    }

    @Override
    public Void visit(IfElse ifElse, Void o) {
        return null;
    }

    @Override
    public Void visit(Input input, Void o) {
        return null;
    }

    @Override
    public Void visit(Print print, Void o) {
        return null;
    }

    @Override
    public Void visit(Return ret, Void o) {
        return null;
    }

    @Override
    public Void visit(While whileStatement, Void o) {
        return null;
    }

}
