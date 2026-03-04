// Generated from C:/Users/uo296143/IdeaProjects/Compilador/src/parser/Pmm.g4 by ANTLR 4.13.2
package parser;

    import ast.*;
    import ast.definition.*;
    import ast.statement.*;
    import ast.type.*;
    import ast.statement.expression.*;
    import ast.statement.expression.constants.*;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link PmmParser}.
 */
public interface PmmListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link PmmParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(PmmParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link PmmParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(PmmParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link PmmParser#mainFunction}.
	 * @param ctx the parse tree
	 */
	void enterMainFunction(PmmParser.MainFunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PmmParser#mainFunction}.
	 * @param ctx the parse tree
	 */
	void exitMainFunction(PmmParser.MainFunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PmmParser#definition}.
	 * @param ctx the parse tree
	 */
	void enterDefinition(PmmParser.DefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PmmParser#definition}.
	 * @param ctx the parse tree
	 */
	void exitDefinition(PmmParser.DefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PmmParser#variableDefinition}.
	 * @param ctx the parse tree
	 */
	void enterVariableDefinition(PmmParser.VariableDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PmmParser#variableDefinition}.
	 * @param ctx the parse tree
	 */
	void exitVariableDefinition(PmmParser.VariableDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PmmParser#functionDefinition}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDefinition(PmmParser.FunctionDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PmmParser#functionDefinition}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDefinition(PmmParser.FunctionDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PmmParser#parameters}.
	 * @param ctx the parse tree
	 */
	void enterParameters(PmmParser.ParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link PmmParser#parameters}.
	 * @param ctx the parse tree
	 */
	void exitParameters(PmmParser.ParametersContext ctx);
	/**
	 * Enter a parse tree produced by {@link PmmParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(PmmParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link PmmParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(PmmParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link PmmParser#fields}.
	 * @param ctx the parse tree
	 */
	void enterFields(PmmParser.FieldsContext ctx);
	/**
	 * Exit a parse tree produced by {@link PmmParser#fields}.
	 * @param ctx the parse tree
	 */
	void exitFields(PmmParser.FieldsContext ctx);
	/**
	 * Enter a parse tree produced by {@link PmmParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(PmmParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link PmmParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(PmmParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link PmmParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(PmmParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link PmmParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(PmmParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link PmmParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(PmmParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PmmParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(PmmParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PmmParser#simple_type}.
	 * @param ctx the parse tree
	 */
	void enterSimple_type(PmmParser.Simple_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link PmmParser#simple_type}.
	 * @param ctx the parse tree
	 */
	void exitSimple_type(PmmParser.Simple_typeContext ctx);
	/**
	 * Enter a parse tree produced by {@link PmmParser#expressions}.
	 * @param ctx the parse tree
	 */
	void enterExpressions(PmmParser.ExpressionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link PmmParser#expressions}.
	 * @param ctx the parse tree
	 */
	void exitExpressions(PmmParser.ExpressionsContext ctx);
}