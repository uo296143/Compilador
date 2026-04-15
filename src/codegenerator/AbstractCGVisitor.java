package codegenerator;

import ast.Program;
import ast.definition.FunctionDefinition;
import ast.definition.VariableDefinition;
import ast.statement.*;
import ast.statement.expression.*;
import ast.statement.expression.constants.CharLiteral;
import ast.statement.expression.constants.DoubleLiteral;
import ast.statement.expression.constants.IntLiteral;
import ast.type.*;
import visitor.Visitor;

/**
 * AbstractCGVisitor. Todos los métodos lanzan excepción por defecto.
 * Las clases que hereden de esta (Execute, Address, Value) sobrescribirán
 * solo los métodos que necesiten.
 */
public abstract class AbstractCGVisitor<TP, TR> implements Visitor<TP, TR> {

    protected void error() {
        throw new IllegalStateException("Code Generator: Método del visitor no implementado para esta fase");
    }

    @Override
    public TR visit(Program program, TP o) {
        error();
        return null;
    }

    @Override
    public TR visit(FunctionDefinition funcDef, TP o) {
        error();
        return null;
    }

    @Override
    public TR visit(VariableDefinition varDef, TP o) {
        error();
        return null;
    }

    @Override
    public TR visit(CharLiteral charLit, TP o) {
        error();
        return null;
    }

    @Override
    public TR visit(DoubleLiteral doubleLit, TP o) {
        error();
        return null;
    }

    @Override
    public TR visit(IntLiteral intLit, TP o) {
        error();
        return null;
    }

    @Override
    public TR visit(ArithmeticOperator arithOp, TP o) {
        error();
        return null;
    }

    @Override
    public TR visit(ArrayAccess arrayAccess, TP o) {
        error();
        return null;
    }

    @Override
    public TR visit(Cast cast, TP o) {
        error();
        return null;
    }

    @Override
    public TR visit(ComparativeOperator compOp, TP o) {
        error();
        return null;
    }

    @Override
    public TR visit(LogicalOperator logicOp, TP o) {
        error();
        return null;
    }

    @Override
    public TR visit(NotArithmetic notArith, TP o) {
        error();
        return null;
    }

    @Override
    public TR visit(NotLogic notLogic, TP o) {
        error();
        return null;
    }

    @Override
    public TR visit(Point point, TP o) {
        error();
        return null;
    }

    @Override
    public TR visit(Variable variable, TP o) {
        error();
        return null;
    }

    @Override
    public TR visit(Assignment assignment, TP o) {
        error();
        return null;
    }

    @Override
    public TR visit(FunctionInvocation funcInvoc, TP o) {
        error();
        return null;
    }

    @Override
    public TR visit(IfElse ifElse, TP o) {
        error();
        return null;
    }

    @Override
    public TR visit(Input input, TP o) {
        error();
        return null;
    }

    @Override
    public TR visit(Print print, TP o) {
        error();
        return null;
    }

    @Override
    public TR visit(Return ret, TP o) {
        error();
        return null;
    }

    @Override
    public TR visit(While whileStatement, TP o) {
        error();
        return null;
    }

    @Override
    public TR visit(ArrayType arrayType, TP o) {
        error();
        return null;
    }

    @Override
    public TR visit(CharType charType, TP o) {
        error();
        return null;
    }

    @Override
    public TR visit(DoubleType doubleType, TP o) {
        error();
        return null;
    }

    @Override
    public TR visit(ErrorType errorType, TP o) {
        error();
        return null;
    }

    @Override
    public TR visit(Field field, TP o) {
        error();
        return null;
    }

    @Override
    public TR visit(FunctionType functionType, TP o) {
        error();
        return null;
    }

    @Override
    public TR visit(IntType intType, TP o) {
        error();
        return null;
    }

    @Override
    public TR visit(None none, TP o) {
        error();
        return null;
    }

    @Override
    public TR visit(StructType structType, TP o) {
        error();
        return null;
    }
}