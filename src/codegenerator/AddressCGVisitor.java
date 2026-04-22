package codegenerator;

import ast.definition.VariableDefinition;
import ast.statement.*;
import ast.statement.expression.*;
import ast.type.*;
import semantic.AbstractVisitor;

public class AddressCGVisitor extends AbstractVisitor<Void, Void> {

    private CodeGenerator codeGenerator;
    private ValueCGVisitor value;

    public AddressCGVisitor(CodeGenerator codeGenerator){
        codeGenerator = codeGenerator;
        value = new ValueCGVisitor(codeGenerator);
    }

    // FIELD ACCESS NO HACER
    @Override
    public Void visit(Point point, Void o) {
        ;
        return null;
    }

    /**
     * address[[Variable: exp → ID]] =
     *      if (exp.definition.scope==0)
     *          pusha exp.definition.offset
     *      else {
     *          push bp
     *          pushi exp.definition.offset
     *          addi
     *      }
     * @param variable
     * @param o
     * @return
     */
    @Override
    public Void visit(Variable variable, Void o) {
        if(variable.getDefinition().getScope() == 0){
            codeGenerator.push('a', ((VariableDefinition)variable.getDefinition()).getOffset());
        }else{
            codeGenerator.pushbp();
            codeGenerator.push('i', ((VariableDefinition)variable.getDefinition()).getOffset());
            codeGenerator.add('i');
        }
        return null;
    }

    // INDEXING NO HACER
    @Override
    public Void visit(ArrayAccess arrayAccess, Void o) {
        return null;
    }

}
