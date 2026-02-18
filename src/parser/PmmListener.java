// Generated from C:/Users/uo296143/IdeaProjects/Compilador/src/parser/Pmm.g4 by ANTLR 4.13.2
package parser;
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
	 * Enter a parse tree produced by {@link PmmParser#function_invocation}.
	 * @param ctx the parse tree
	 */
	void enterFunction_invocation(PmmParser.Function_invocationContext ctx);
	/**
	 * Exit a parse tree produced by {@link PmmParser#function_invocation}.
	 * @param ctx the parse tree
	 */
	void exitFunction_invocation(PmmParser.Function_invocationContext ctx);
}