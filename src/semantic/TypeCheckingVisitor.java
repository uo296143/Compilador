package semantic;

import ast.statement.*;
import ast.statement.expression.*;
import ast.statement.expression.constants.CharLiteral;
import ast.statement.expression.constants.DoubleLiteral;
import ast.statement.expression.constants.IntLiteral;
import ast.type.*;

public class TypeCheckingVisitor extends AbstractVisitor<Void, Void> {

    @Override
    public Void visit(CharLiteral charLit, Void o) {
        charLit.setLvalue(false);
        charLit.setType(new CharType());
        return null;
    }

    @Override
    public Void visit(DoubleLiteral doubleLit, Void o) {
        doubleLit.setLvalue(false);
        doubleLit.setType(new DoubleType());
        return null;
    }

    @Override
    public Void visit(IntLiteral intLit, Void o) {
        intLit.setLvalue(false);
        intLit.setType(new IntType());
        return null;
    }

    @Override
    public Void visit(ArithmeticOperator arithOp, Void o) {
        super.visit(arithOp, o);
        arithOp.setType(arithOp.getLeftExpression().getType().arithmetic(arithOp.getRightExpression().getType()));
        arithOp.setLvalue(false);
        return null;
    }

    @Override
    public Void visit(ArrayAccess arrayAccess, Void o) {
        super.visit(arrayAccess, o);
        // El tipo de la izquierda siempre va a ser ArrayType sino salta error.
        arrayAccess.setType(arrayAccess.getType().squareBrackets(arrayAccess.getRightExpression().getType()));
        arrayAccess.setLvalue(true);
        return null;
    }

    @Override
    public Void visit(ComparativeOperator compOp, Void o) {
        super.visit(compOp, o);
        compOp.setType(compOp.getLeftExpression().getType().comparison(compOp.getRightExpression().getType()));
        compOp.setLvalue(false);
        return null;
    }

    @Override
    public Void visit(Cast cast, Void o) {
        cast.getExpression().accept(this, o);
        cast.setType(cast.getExpression().getType());
        return null;
    }

    @Override
    public Void visit(LogicalOperator logicOp, Void o) {
        super.visit(logicOp, o);
        logicOp.setType(logicOp.getLeftExpression().getType().comparison(logicOp.getRightExpression().getType()));
        logicOp.setLvalue(false);
        return null;
    }

    @Override
    public Void visit(NotArithmetic notArith, Void o) {
        super.visit(notArith, o);
        notArith.setType(notArith.getExpression().getType());
        notArith.setLvalue(false);
        return null;
    }

    @Override
    public Void visit(NotLogic notLogic, Void o) {
        notLogic.getExpression().accept(this, o);
        notLogic.setType(notLogic.getExpression().getType());
        notLogic.setLvalue(false);
        return null;
    }

    @Override
    public Void visit(Point point, Void o) {
        point.getLeftExpression().accept(this, o);
        point.setType(point.getLeftExpression().getType().dot(point.getFieldName()));
        point.setLvalue(true);
        return null;
    }

    @Override
    public Void visit(Variable variable, Void o) {
        variable.setLvalue(true);
        variable.setType(variable.getDefinition().getType());
        return null;
    }

    @Override
    public Void visit(FunctionInvocation funcInvoc, Void o) {
        for(Expression expression : funcInvoc.getArguments()){
            expression.accept(this, o);
        }
        funcInvoc.setLvalue(false);
        funcInvoc.setType(funcInvoc.getFunction().getType());
        return null;
    }

}
