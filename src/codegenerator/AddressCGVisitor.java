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
        this.codeGenerator = codeGenerator;
    }

    public void setValueCGVisitor(ValueCGVisitor visitor){
        this.value = visitor;
    }

    /**
     * [[Point: exp1 -> exp2 ID]] =
     *      address[[exp2]]
     *      <pushi> expression2.type.getField(expression1.fieldName).offset
     *      <addi>
     * @param point
     * @param o
     * @return
     */
    @Override
    public Void visit(Point point, Void o) {
        point.getLeftExpression().accept(this, o);
        codeGenerator.push('i', ((StructType)point.getLeftExpression().getType()).getField(point.getFieldName()).getOffset());
        codeGenerator.add('i');
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

    /**
     * [[ArrayAccess: exp1 -> exp2 exp3]]() =
     *      address[[expression2]]
     *      value[[expression3]]
     *      cg.convert(expression3.type, IntType)
     *      <pushi> expression1.type.numberOfBytes()
     *      <muli>
     *      <addi>
     * @param arrayAccess
     * @param o
     * @return
     */
    @Override
    public Void visit(ArrayAccess arrayAccess, Void o) {
        arrayAccess.getLeftExpression().accept(this, o);
        arrayAccess.getRightExpression().accept(value, o);
        codeGenerator.convert(arrayAccess.getRightExpression().getType(), new IntType());
        codeGenerator.push('i', arrayAccess.getType().numberOfBytes());
        codeGenerator.mul('i');
        codeGenerator.add('i');
        return null;
    }

}
