package visitor;

import ast.Program;
import ast.definition.FunctionDefinition;
import ast.definition.VariableDefinition;
import ast.statement.*;
import ast.statement.expression.*;
import ast.statement.expression.constants.CharLiteral;
import ast.statement.expression.constants.DoubleLiteral;
import ast.statement.expression.constants.IntLiteral;
import ast.type.*;

public interface Visitor<TP, TR>{

    public TR visit(FunctionDefinition funcDef, TP tp);
    public TR visit(VariableDefinition varDef, TP tp);
    public TR visit(CharLiteral charLit, TP tp);
    public TR visit(DoubleLiteral doubleLit, TP tp);
    public TR visit(IntLiteral intLit, TP tp);
    public TR visit(ArithmeticOperator arithOp, TP tp);
    public TR visit(ArrayAccess arrayAccess, TP tp);
    public TR visit(Cast cast, TP tp);
    public TR visit(ComparativeOperator compOp, TP tp);
    public TR visit(LogicalOperator logicOp, TP tp);
    public TR visit(NotArithmetic notArith, TP tp);
    public TR visit(NotLogic notLogic, TP tp);
    public TR visit(Point point, TP tp);
    public TR visit(Variable variable, TP tp);
    public TR visit(Assignment assignment, TP tp);
    public TR visit(FunctionInvocation funcInvoc, TP tp);
    public TR visit(IfElse ifElse, TP tp);
    public TR visit(Input input, TP tp);
    public TR visit(Print print, TP tp);
    public TR visit(Return ret, TP tp);
    public TR visit(While whileStatement, TP tp);
    public TR visit(ArrayType arrayType, TP tp);
    public TR visit(CharType charType, TP tp);
    public TR visit(DoubleType doubleType, TP tp);
    public TR visit(ErrorType errorType, TP tp);
    public TR visit(Field field, TP tp);
    public TR visit(FunctionType functionType, TP tp);
    public TR visit(IntType intType, TP tp);
    public TR visit(None none, TP tp);
    public TR visit(StructType structType, TP tp);
    public TR visit(Program program, TP tp);





}
