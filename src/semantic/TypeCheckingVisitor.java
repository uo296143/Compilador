package semantic;

import ast.definition.FunctionDefinition;
import ast.statement.*;
import ast.statement.expression.*;
import ast.statement.expression.constants.CharLiteral;
import ast.statement.expression.constants.DoubleLiteral;
import ast.statement.expression.constants.IntLiteral;
import ast.type.*;

import java.util.List;

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
        arithOp.getLeftExpression().accept(this, o);
        arithOp.getRightExpression().accept(this, o);
        arithOp.setType(arithOp.getLeftExpression().getType().arithmetic(arithOp.getRightExpression().getType(), arithOp));
        arithOp.setLvalue(false);
        return null;
    }

    @Override
    public Void visit(ArrayAccess arrayAccess, Void o) {
        arrayAccess.getLeftExpression().accept(this, o);
        arrayAccess.getRightExpression().accept(this, o);
        arrayAccess.setType(arrayAccess.getLeftExpression().getType().squareBrackets(arrayAccess.getRightExpression().getType(), arrayAccess));
        arrayAccess.setLvalue(true);
        return null;
    }

    @Override
    public Void visit(ComparativeOperator compOp, Void o) {
        compOp.getLeftExpression().accept(this, o);
        compOp.getRightExpression().accept(this, o);
        compOp.setType(compOp.getLeftExpression().getType().comparison(compOp.getRightExpression().getType(), compOp));
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
        Expression leftExpression = logicOp.getLeftExpression();
        Expression rightExpression = logicOp.getRightExpression();
        leftExpression.accept(this, o);
        rightExpression.accept(this, o);
        leftExpression.getType().logic(rightExpression.getType(), logicOp);
        logicOp.setLvalue(false);
        return null;
    }

    @Override
    public Void visit(NotArithmetic notArith, Void o) {
        notArith.getExpression().accept(this, o);
        notArith.setType(notArith.getExpression().getType());
        notArith.setLvalue(false);
        notArith.getType().arithmetic(notArith);
        return null;
    }

    @Override
    public Void visit(NotLogic notLogic, Void o) {
        notLogic.getExpression().accept(this, o);
        notLogic.getExpression().getType().mustBeLogical(notLogic);
        notLogic.setType(notLogic.getExpression().getType());
        notLogic.setLvalue(false);
        notLogic.getType().mustBeLogical(notLogic);
        return null;
    }

    @Override
    public Void visit(Point point, Void o) {
        point.getLeftExpression().accept(this, o);
        point.setType(point.getLeftExpression().getType().dot(point.getFieldName(), point));
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
    public Void visit(Assignment assignment, Void o) {
        Expression leftExpression = assignment.getLeftExpression();
        Expression rightExpression = assignment.getRightExpression();
        leftExpression.accept(this, o);
        rightExpression.accept(this, o);
        if(!leftExpression.getLvalue()){
            new ErrorType("La expresión de la izquierda no es un Lvalue", assignment);
        }
        rightExpression.getType().mustPromoteTo(leftExpression.getType(), assignment);
        return null;
    }

    @Override
    public Void visit(Input input, Void o) {
        for(Expression e: input.getExpressions()) {
            e.accept(this, o);
            if(!e.getLvalue()){
                new ErrorType("La expresión no es un Lvalue", input);
            }
        }
        return null;
    }

    @Override
    public Void visit(While whileStatement, Void o) {
        whileStatement.getExpression().accept(this, o);
        whileStatement.getExpression().getType().mustBeLogical(whileStatement);
        for(Statement statement : whileStatement.getStatements()){
            statement.accept(this, o);
        }
        return null;
    }

    @Override
    public Void visit(IfElse ifElse, Void o) {
        ifElse.getExpression().accept(this, o);
        ifElse.getExpression().getType().mustBeLogical(ifElse);
        for(Statement statement : ifElse.getIfBody()){
            statement.accept(this, o);
        }
        for(Statement statement : ifElse.getElseBody()){
            statement.accept(this, o);
        }
        return null;
    }

    @Override
    public Void visit(FunctionInvocation funcInvoc, Void o) {
        funcInvoc.getFunction().accept(this, o);
        for(Expression expression : funcInvoc.getArguments()){
            expression.accept(this, o);
        }
        funcInvoc.setType(funcInvoc.getFunction().getType());
        List<Type> types = funcInvoc.getArguments().stream()
                .map(Expression::getType)
                .toList();
        funcInvoc.getFunction().getType().parenthesis(types, funcInvoc);
        return null;
    }

    @Override
    public Void visit(FunctionDefinition funcDef, Void o) {
        funcDef.getType().accept(this, o);
        for(Statement statement : funcDef.getStatements()){
            statement.accept(this, o);
            if(statement instanceof Return){
                Return return_statement = (Return)statement;
                return_statement.getReturnExpression().getType().mustPromoteTo(((FunctionType)funcDef.getType()).getReturnType(), funcDef);
            }
        }
        return null;
    }

}