package semantic;

import ast.Program;
import ast.definition.Definition;
import ast.definition.FunctionDefinition;
import ast.definition.VariableDefinition;
import ast.statement.*;
import ast.statement.expression.*;
import ast.statement.expression.constants.CharLiteral;
import ast.statement.expression.constants.DoubleLiteral;
import ast.statement.expression.constants.IntLiteral;
import ast.type.*;
import visitor.Visitor;


public class AbstractVisitor<TP, TR> implements Visitor<TP, TR> {

    @Override
    public TR visit(Program program, TP o) {
        for(Definition definition : program.getDefinitions()){
            definition.accept(this, o);
        }
        return null;
    }

    @Override
    public TR visit(FunctionDefinition funcDef, TP o) {
        funcDef.getType().accept(this, o);
        for(Statement statement : funcDef.getStatements()){
            statement.accept(this, o);
        }
        return null;
    }

    @Override
    public TR visit(VariableDefinition varDef, TP o) {
        varDef.getType().accept(this, o);
        return null;
    }

    @Override
    public TR visit(CharLiteral charLit, TP o) {
        charLit.setLvalue(false);
        return null;
    }

    @Override
    public TR visit(DoubleLiteral doubleLit, TP o) {
        doubleLit.setLvalue(false);
        return null;
    }

    @Override
    public TR visit(IntLiteral intLit, TP o) {
        intLit.setLvalue(false);
        return null;
    }

    @Override
    public TR visit(ArithmeticOperator arithOp, TP o) {
        arithOp.getLeftExpression().accept(this, o);
        arithOp.getRightExpression().accept(this, o);
        return null;
    }

    @Override
    public TR visit(ArrayAccess arrayAccess, TP o) {
        arrayAccess.getLeftExpression().accept(this, o);
        arrayAccess.getRightExpression().accept(this, o);
        return null;
    }

    @Override
    public TR visit(Cast cast, TP o) {
        cast.getExpression().accept(this, o);
        return null;
    }

    @Override
    public TR visit(ComparativeOperator compOp, TP o) {
        compOp.getLeftExpression().accept(this, o);
        compOp.getRightExpression().accept(this, o);
        return null;
    }

    @Override
    public TR visit(LogicalOperator logicOp, TP o) {
        logicOp.getLeftExpression().accept(this, o);
        logicOp.getRightExpression().accept(this, o);
        return null;
    }

    @Override
    public TR visit(NotArithmetic notArith, TP o) {
        notArith.getExpression().accept(this, o);
        return null;
    }

    @Override
    public TR visit(NotLogic notLogic, TP o) {
        notLogic.getExpression().accept(this, o);
        return null;
    }

    @Override
    public TR visit(Point point, TP o) {
        point.getLeftExpression().accept(this, o);
        return null;
    }

    @Override
    public TR visit(Variable variable, TP o) {
        return null;
    }

    @Override
    public TR visit(Assignment assignment, TP o) {
        assignment.getLeftExpression().accept(this, o);
        assignment.getRightExpression().accept(this, o);
        return null;
    }

    @Override
    public TR visit(FunctionInvocation funcInvoc, TP o) {
        funcInvoc.getFunction().accept(this, o);
        for(Expression expression : funcInvoc.getArguments()){
            expression.accept(this, o);
        }
        return null;
    }

    @Override
    public TR visit(IfElse ifElse, TP o) {
        ifElse.getExpression().accept(this, o);
        for(Statement statement : ifElse.getIfBody()){
            statement.accept(this, o);
        }
        for(Statement statement : ifElse.getElseBody()){
            statement.accept(this, o);
        }
        return null;
    }

    @Override
    public TR visit(Input input, TP o) {
        for(Expression e: input.getExpressions()) {
            e.accept(this, o);
        }
        return null;
    }

    @Override
    public TR visit(Print print, TP o) {
        for(Expression expression : print.getExpressions()){
            expression.accept(this, o);
        }
        return null;
    }

    @Override
    public TR visit(Return ret, TP o) {
        ret.getReturnExpression().accept(this, o);
        return null;
    }

    @Override
    public TR visit(While whileStatement, TP o) {
        whileStatement.getExpression().accept(this, o);
        for(Statement statement : whileStatement.getStatements()){
            statement.accept(this, o);
        }
        return null;
    }

    @Override
    public TR visit(ArrayType arrayType, TP o) {
        return null;
    }

    @Override
    public TR visit(CharType charType, TP o) {
        return null;
    }

    @Override
    public TR visit(DoubleType doubleType, TP o) {
        return null;
    }

    @Override
    public TR visit(ErrorType errorType, TP o) {
        return null;
    }

    @Override
    public TR visit(Field field, TP o) {
        field.getType().accept(this, o);
        return null;
    }

    @Override
    public TR visit(FunctionType functionType, TP o) {
        for(Statement statement : functionType.getStatements()){
            statement.accept(this, o);
        }
        return null;
    }

    @Override
    public TR visit(IntType intType, TP o) {
        return null;
    }

    @Override
    public TR visit(None none, TP o) {
        return null;
    }

    @Override
    public TR visit(StructType structType, TP o) {
        for(Field field : structType.getFields()){
            field.accept(this, o);
        }
        return null;
    }
}
