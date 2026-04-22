package codegenerator;

import ast.statement.*;
import ast.statement.expression.*;
import ast.statement.expression.constants.CharLiteral;
import ast.statement.expression.constants.DoubleLiteral;
import ast.statement.expression.constants.IntLiteral;
import ast.type.*;

public class ValueCGVisitor extends AbstractCGVisitor<Void, Void>{

    private CodeGenerator codeGenerator;
    private AddressCGVisitor address;

    public ValueCGVisitor(CodeGenerator codeGenerator){
        this.codeGenerator = codeGenerator;
        address = new AddressCGVisitor(codeGenerator);
    }

    /**
     * value[[CharLiteral: exp → CHAR_CONSTANT]] = pushf exp.value
     * @param charLit
     * @param o
     * @return
     */
    @Override
    public Void visit(CharLiteral charLit, Void o) {
        codeGenerator.push('b', charLit.getValue());
        return null;
    }

    /**
     * value[[RealLiteral: exp → REAL_CONSTANT]] = pushf exp.value
     * @param doubleLit
     * @param o
     * @return
     */
    @Override
    public Void visit(DoubleLiteral doubleLit, Void o) {
        codeGenerator.push('f',doubleLit.getValue());
        return null;
    }

    /**
     * value[[IntLiteral: exp → INT_CONSTANT]] = pushi exp.value
     * @param intLit
     * @param o
     * @return
     */
    @Override
    public Void visit(IntLiteral intLit, Void o) {
        codeGenerator.push('i', intLit.getValue());
        return null;
    }

    /**
     * value[[ArithmeticOperator:exp1 → exp2 (+|-|*|/) exp3]] =
     *      value[[exp2]]
     *      exp2.type.convertTo(exp1.type)
     *      value[[exp3]]
     *      exp3.type.convertTo(exp1.type)
     *      switch (exp1.operator) {
     *          case "+": add exp1.type.suffix() break;
     *          case "-": sub exp1. type.suffix() break;
     *          case "*": div exp1. type.suffix() break;
     *          case "/": mul exp1. type.suffix() break;
     *          case "%": mod exp1. type.suffix() break;
     *      }
     * @param arithOp
     * @param o
     * @return
     */
    @Override
    public Void visit(ArithmeticOperator arithOp, Void o) {
        arithOp.getLeftExpression().accept(this, o);
        codeGenerator.convert(arithOp.getLeftExpression().getType(), arithOp.getType());
        arithOp.getRightExpression().accept(this, o);
        codeGenerator.convert(arithOp.getRightExpression().getType(), arithOp.getType());
        char suffix = arithOp.getType().suffix();
        switch(arithOp.getOperator()){
            case "+": codeGenerator.add(suffix); break;
            case "-": codeGenerator.sub(suffix); break;
            case "*": codeGenerator.mul(suffix); break;
            case "/": codeGenerator.div(suffix); break;
            case "%": codeGenerator.mod(suffix); break;
        }
        return null;
    }

    // INDEXING NO HACER
    @Override
    public Void visit(ArrayAccess arrayAccess, Void o) {
        ;
        return null;
    }

    /**
     * value[[Cast:exp1 → exp2]] =
     *      value[[exp2]]
     *      exp2.type.convertTo(exp1.type)
     */
    @Override
    public Void visit(Cast cast, Void o) {
        cast.getExpression().accept(this, o);
        codeGenerator.convert(cast.getExpression().getType(), cast.getCastType());
        return null;
    }

    /**
     * value[[ComparativeOperator:exp1 → exp2 (>|>=|<|<=|!=|==) exp3]] =
     *      value[[exp2]]
     *      exp2.type.convertTo(exp1.type)
     *      value[[exp3]]
     *      exp3.type.convertTo(exp1.type)
     *      switch (exp1.operator) {
     *          case ">": gt exp1.type.suffix() break;
     *          case ">=": ge exp1. type.suffix() break;
     *          case "<": lt exp1. type.suffix() break;
     *          case "<=": le exp1. type.suffix() break;
     *          case "!=": ne exp1. type.suffix() break;
     *          case "==": eq exp1. type.suffix() break;
     *       }
     * @param compOp
     * @param o
     * @return
     */
    @Override
    public Void visit(ComparativeOperator compOp, Void o) {
        compOp.getLeftExpression().accept(this, o);
        codeGenerator.convert(compOp.getLeftExpression().getType(), compOp.getType());
        compOp.getRightExpression().accept(this, o);
        codeGenerator.convert(compOp.getRightExpression().getType(), compOp.getType());
        char suffix = compOp.getType().suffix();
        switch (compOp.getOperator()) {
            case ">":  codeGenerator.gt(suffix); break;
            case ">=": codeGenerator.ge(suffix); break;
            case "<":  codeGenerator.lt(suffix); break;
            case "<=": codeGenerator.le(suffix); break;
            case "!=": codeGenerator.ne(suffix); break;
            case "==": codeGenerator.eq(suffix); break;
        }
        return null;
    }

    /**
     * value[[LogicalOperator:exp1 → exp2 (&& , ||) exp3]] =
     *      value[[exp2]]
     *      exp2.type.convertTo(exp1.type)
     *      value[[exp3]]
     *      exp3.type.convertTo(exp1.type)
     *      switch (exp1.operator) {*
     *          case "&&": and break;
     *          case "||": or break;
     */
    @Override
    public Void visit(LogicalOperator logicOp, Void o) {
        logicOp.getLeftExpression().accept(this, o);
        codeGenerator.convert(logicOp.getLeftExpression().getType(), logicOp.getType());
        logicOp.getRightExpression().accept(this, o);
        codeGenerator.convert(logicOp.getRightExpression().getType(), logicOp.getType());
        switch (logicOp.getOperator()) {
            case "&&":  codeGenerator.and(); break;
            case "||": codeGenerator.or(); break;
        }
        return null;
    }

    /**
     * value[[NotArithmetic:exp1 → exp2]] =
     *      value[[exp2]]
     *      exp2.type.convertTo(exp1.type)
     *      push -1
     *      mul ex1.type.suffix()
     */
    @Override
    public Void visit(NotArithmetic notArith, Void o) {
        notArith.getExpression().accept(this, o);
        codeGenerator.convert(notArith.getExpression().getType(), notArith.getType());
        char suffix = notArith.getType().suffix();
        codeGenerator.push(suffix, -1);
        codeGenerator.mul(suffix);
        return null;
    }

    /**
     * value[[NotLogic:exp1 → exp2]] =
     *      value[[exp2]]
     *      exp2.type.convertTo(exp1.type)
     *      not
     */
    @Override
    public Void visit(NotLogic notLogic, Void o) {
        notLogic.getExpression().accept(this, o);
        codeGenerator.convert(notLogic.getExpression().getType(), notLogic.getType());
        codeGenerator.not();
        return null;
    }

    // FIELD ACCESS NO HACER
    @Override
    public Void visit(Point point, Void o) {
        ;
        return null;
    }

    /**
     * value[[Variable:exp1 → ID]] =
     *      address[[exp1]]
     *      load exp1.type.suffix()
     */
    @Override
    public Void visit(Variable variable, Void o) {
        variable.accept(address, o);
        codeGenerator.load(variable.getType().suffix());
        return null;
    }

    // NO HACER
    @Override
    public Void visit(FunctionInvocation funcInvoc, Void o) {
        ;
        return null;
    }

}
