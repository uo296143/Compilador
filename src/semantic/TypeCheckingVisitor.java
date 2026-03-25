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
import errorhandler.ErrorHandler;
import visitor.Visitor;

import java.util.ArrayList;

public class TypeCheckingVisitor extends AbstractVisitor<Void, Void> {

    @Override
    public Void visit(CharLiteral charLit, Void o) {
        charLit.setLvalue(false);
        return null;
    }

    @Override
    public Void visit(DoubleLiteral doubleLit, Void o) {
        doubleLit.setLvalue(false);
        return null;
    }

    @Override
    public Void visit(IntLiteral intLit, Void o) {
        intLit.setLvalue(false);
        return null;
    }

    @Override
    public Void visit(ArithmeticOperator arithOp, Void o) {
        // setType(tipo de la izquira.arithmetic()
        super.visit(arithOp, o);
        arithOp.setLvalue(false);
        return null;
    }

    @Override
    public Void visit(ArrayAccess arrayAccess, Void o) {
        super.visit(arrayAccess, o);
        arrayAccess.setLvalue(true);
        return null;
    }

    @Override
    public Void visit(Cast cast, Void o) {
        super.visit(cast, o);
        cast.setLvalue(false);
        return null;
    }

    @Override
    public Void visit(ComparativeOperator compOp, Void o) {
        super.visit(compOp, o);
        compOp.setLvalue(false);
        return null;
    }

    @Override
    public Void visit(LogicalOperator logicOp, Void o) {
        super.visit(logicOp, o);
        logicOp.setLvalue(false);
        return null;
    }

    @Override
    public Void visit(NotArithmetic notArith, Void o) {
        super.visit(notArith, o);
        notArith.setLvalue(false);
        return null;
    }

    @Override
    public Void visit(NotLogic notLogic, Void o) {
        notLogic.getExpression().accept(this, o);
        notLogic.setLvalue(false);
        return null;
    }

    @Override
    public Void visit(Point point, Void o) {
        point.getLeftExpression().accept(this, o);
        point.setLvalue(true);
        return null;
    }

    @Override
    public Void visit(Variable variable, Void o) {
        variable.setLvalue(true);
        return null;
    }

    @Override
    public Void visit(Assignment assignment, Void o) {

        assignment.getLeftExpression().accept(this, o);
        assignment.getRightExpression().accept(this, o);

        if (!assignment.getLeftExpression().getLvalue()) {
            new ErrorType("El lado izquierdo de la asignación no es un Lvalue: "
                , new Assignment(assignment.getLeftExpression(),  assignment.getRightExpression(),
                assignment.getLeftExpression().getLine(), assignment.getLeftExpression().getColumn()));
        }
        return null;
    }

    @Override
    public Void visit(FunctionInvocation funcInvoc, Void o) {
        for(Expression expression : funcInvoc.getArguments()){
            expression.accept(this, o);
        }
        funcInvoc.setLvalue(false);
        return null;
    }

    @Override
    public Void visit(IfElse ifElse, Void o) {
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
    public Void visit(Input input, Void o) {
        for(Expression e: input.getExpressions()) {
            e.accept(this, o);
        }
        for(Expression e : input.getExpressions()){
            if(!e.getLvalue()){
                new ErrorType("Alguna de los inputs no es un Lvalue: "
                    , new Input(new ArrayList<Expression>(),
                    e.getLine(), e.getColumn()));
            }
        }
        return null;
    }

    @Override
    public Void visit(Print print, Void o) {
        for(Expression expression : print.getExpressions()){
            expression.accept(this, o);
        }
        return null;
    }

    @Override
    public Void visit(Return ret, Void o) {
        ret.getReturnExpression().accept(this, o);
        return null;
    }

    @Override
    public Void visit(While whileStatement, Void o) {
        whileStatement.getExpression().accept(this, o);
        for(Statement statement : whileStatement.getStatements()){
            statement.accept(this, o);
        }
        return null;
    }

    @Override
    public Void visit(ArrayType arrayType, Void o) {
        return null;
    }

    @Override
    public Void visit(CharType charType, Void o) {
        return null;
    }

    @Override
    public Void visit(DoubleType doubleType, Void o) {
        return null;
    }

    @Override
    public Void visit(ErrorType errorType, Void o) {
        return null;
    }

    @Override
    public Void visit(Field field, Void o) {
        return null;
    }

    @Override
    public Void visit(FunctionType functionType, Void o) {
        for(Statement statement : functionType.getStatements()){
            statement.accept(this, o);
        }
        return null;
    }

    @Override
    public Void visit(IntType intType, Void o) {
        return null;
    }

    @Override
    public Void visit(None none, Void o) {
        return null;
    }

    @Override
    public Void visit(StructType structType, Void o) {
        return null;
    }

}
