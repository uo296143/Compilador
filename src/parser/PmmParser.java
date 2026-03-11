// Generated from C:/Users/uo296143/IdeaProjects/Compilador/src/parser/Pmm.g4 by ANTLR 4.13.2
package parser;

    import ast.*;
    import ast.definition.*;
    import ast.statement.*;
    import ast.type.*;
    import ast.statement.expression.*;
    import ast.statement.expression.constants.*;
    import errorhandler.*;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class PmmParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, T__37=38, 
		T__38=39, INT_CONSTANT=40, LINE_COMMENT=41, WHITE_SPACE=42, BLOCK_COMMENT=43, 
		ID=44, REAL_CONSTANT=45, CHAR_CONSTANT=46;
	public static final int
		RULE_program = 0, RULE_mainFunction = 1, RULE_definition = 2, RULE_variableDefinitions = 3, 
		RULE_varDefinition = 4, RULE_functionDefinition = 5, RULE_parameters = 6, 
		RULE_type = 7, RULE_fields = 8, RULE_statement = 9, RULE_block = 10, RULE_expression = 11, 
		RULE_simple_type = 12, RULE_expressions = 13;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "mainFunction", "definition", "variableDefinitions", "varDefinition", 
			"functionDefinition", "parameters", "type", "fields", "statement", "block", 
			"expression", "simple_type", "expressions"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'def'", "'main'", "'('", "')'", "'->'", "'None'", "':'", "'{'", 
			"'}'", "';'", "','", "'struct'", "'['", "']'", "'print'", "'input'", 
			"'='", "'if'", "'else'", "'while'", "'return'", "'.'", "'-'", "'!'", 
			"'*'", "'/'", "'%'", "'+'", "'>'", "'>='", "'<'", "'<='", "'!='", "'=='", 
			"'&&'", "'||'", "'char'", "'double'", "'int'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, "INT_CONSTANT", "LINE_COMMENT", "WHITE_SPACE", 
			"BLOCK_COMMENT", "ID", "REAL_CONSTANT", "CHAR_CONSTANT"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Pmm.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public PmmParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public Program ast;
		public List<Definition> definitions = new ArrayList<Definition>();
		public DefinitionContext definition;
		public MainFunctionContext mainFunction;
		public MainFunctionContext mainFunction() {
			return getRuleContext(MainFunctionContext.class,0);
		}
		public TerminalNode EOF() { return getToken(PmmParser.EOF, 0); }
		public List<DefinitionContext> definition() {
			return getRuleContexts(DefinitionContext.class);
		}
		public DefinitionContext definition(int i) {
			return getRuleContext(DefinitionContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PmmListener ) ((PmmListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PmmListener ) ((PmmListener)listener).exitProgram(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(33);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(28);
					((ProgramContext)_localctx).definition = definition();
					_localctx.definitions.addAll(((ProgramContext)_localctx).definition.ast);
					}
					} 
				}
				setState(35);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			setState(36);
			((ProgramContext)_localctx).mainFunction = mainFunction();
			setState(37);
			match(EOF);
			_localctx.definitions.add(((ProgramContext)_localctx).mainFunction.ast);
			((ProgramContext)_localctx).ast =  new Program(_localctx.definitions);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MainFunctionContext extends ParserRuleContext {
		public FunctionDefinition ast;
		public List<Statement> statements = new ArrayList<Statement>();
		public Token MAIN;
		public VariableDefinitionsContext variableDefinitions;
		public StatementContext statement;
		public VariableDefinitionsContext variableDefinitions() {
			return getRuleContext(VariableDefinitionsContext.class,0);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public MainFunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mainFunction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PmmListener ) ((PmmListener)listener).enterMainFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PmmListener ) ((PmmListener)listener).exitMainFunction(this);
		}
	}

	public final MainFunctionContext mainFunction() throws RecognitionException {
		MainFunctionContext _localctx = new MainFunctionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_mainFunction);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(41);
			match(T__0);
			setState(42);
			((MainFunctionContext)_localctx).MAIN = match(T__1);
			setState(43);
			match(T__2);
			setState(44);
			match(T__3);
			setState(45);
			match(T__4);
			setState(46);
			match(T__5);
			setState(47);
			match(T__6);
			setState(48);
			match(T__7);
			setState(52);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				{
				setState(49);
				((MainFunctionContext)_localctx).variableDefinitions = variableDefinitions();
				_localctx.statements.addAll(((MainFunctionContext)_localctx).variableDefinitions.ast);
				}
				break;
			}
			setState(59);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 124244842610696L) != 0)) {
				{
				{
				setState(54);
				((MainFunctionContext)_localctx).statement = statement();
				_localctx.statements.add(((MainFunctionContext)_localctx).statement.ast);
				}
				}
				setState(61);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(62);
			match(T__8);
			((MainFunctionContext)_localctx).ast =  new FunctionDefinition(_localctx.statements, "main", new FunctionType(new None(), new ArrayList<Statement>()), ((MainFunctionContext)_localctx).MAIN.getLine(), ((MainFunctionContext)_localctx).MAIN.getCharPositionInLine()+1);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DefinitionContext extends ParserRuleContext {
		public List<Definition> ast = new ArrayList<Definition>();
		public VariableDefinitionsContext variableDefinitions;
		public FunctionDefinitionContext functionDefinition;
		public VariableDefinitionsContext variableDefinitions() {
			return getRuleContext(VariableDefinitionsContext.class,0);
		}
		public FunctionDefinitionContext functionDefinition() {
			return getRuleContext(FunctionDefinitionContext.class,0);
		}
		public DefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_definition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PmmListener ) ((PmmListener)listener).enterDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PmmListener ) ((PmmListener)listener).exitDefinition(this);
		}
	}

	public final DefinitionContext definition() throws RecognitionException {
		DefinitionContext _localctx = new DefinitionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_definition);
		try {
			setState(71);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(65);
				((DefinitionContext)_localctx).variableDefinitions = variableDefinitions();
				_localctx.ast.addAll(((DefinitionContext)_localctx).variableDefinitions.ast);
				}
				break;
			case T__0:
				enterOuterAlt(_localctx, 2);
				{
				setState(68);
				((DefinitionContext)_localctx).functionDefinition = functionDefinition();
				_localctx.ast.add(((DefinitionContext)_localctx).functionDefinition.ast);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class VariableDefinitionsContext extends ParserRuleContext {
		public List<VariableDefinition> ast = new ArrayList<VariableDefinition>();
		public VarDefinitionContext varDefinition;
		public Token COMA;
		public List<VarDefinitionContext> varDefinition() {
			return getRuleContexts(VarDefinitionContext.class);
		}
		public VarDefinitionContext varDefinition(int i) {
			return getRuleContext(VarDefinitionContext.class,i);
		}
		public VariableDefinitionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableDefinitions; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PmmListener ) ((PmmListener)listener).enterVariableDefinitions(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PmmListener ) ((PmmListener)listener).exitVariableDefinitions(this);
		}
	}

	public final VariableDefinitionsContext variableDefinitions() throws RecognitionException {
		VariableDefinitionsContext _localctx = new VariableDefinitionsContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_variableDefinitions);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(77); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(73);
					((VariableDefinitionsContext)_localctx).varDefinition = varDefinition();
					setState(74);
					((VariableDefinitionsContext)_localctx).COMA = match(T__9);
					for(VariableDefinition variable : ((VariableDefinitionsContext)_localctx).varDefinition.ast)
					                                                       {
					                                                           if(_localctx.ast.contains(variable)){
					                                                               ErrorHandler.getInstance().addError(new ErrorType("Variable repetida: " + variable.getName(), new CharLiteral("'h'", ((VariableDefinitionsContext)_localctx).COMA.getLine(), ((VariableDefinitionsContext)_localctx).COMA.getCharPositionInLine() + 1)));
					                                                           }else{
					                                                               _localctx.ast.add(variable);
					                                                           }
					                                                       }
					                                                    ;
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(79); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class VarDefinitionContext extends ParserRuleContext {
		public List<VariableDefinition> ast = new ArrayList<VariableDefinition>();
		public List<String> names = new ArrayList<String>();
		public Token ID;
		public TypeContext type;
		public List<TerminalNode> ID() { return getTokens(PmmParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(PmmParser.ID, i);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public VarDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PmmListener ) ((PmmListener)listener).enterVarDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PmmListener ) ((PmmListener)listener).exitVarDefinition(this);
		}
	}

	public final VarDefinitionContext varDefinition() throws RecognitionException {
		VarDefinitionContext _localctx = new VarDefinitionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_varDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(81);
			((VarDefinitionContext)_localctx).ID = match(ID);
			_localctx.names.add((((VarDefinitionContext)_localctx).ID!=null?((VarDefinitionContext)_localctx).ID.getText():null));
			setState(88);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__10) {
				{
				{
				setState(83);
				match(T__10);
				setState(84);
				((VarDefinitionContext)_localctx).ID = match(ID);

				                           if (_localctx.names.contains((((VarDefinitionContext)_localctx).ID!=null?((VarDefinitionContext)_localctx).ID.getText():null))) {
				                                ErrorHandler.getInstance().addError(new ErrorType("Variable repetida: " + (((VarDefinitionContext)_localctx).ID!=null?((VarDefinitionContext)_localctx).ID.getText():null), new CharLiteral("'h'", ((VarDefinitionContext)_localctx).ID.getLine(), ((VarDefinitionContext)_localctx).ID.getCharPositionInLine() + 1)));
				                           } else {
				                                {_localctx.names.add((((VarDefinitionContext)_localctx).ID!=null?((VarDefinitionContext)_localctx).ID.getText():null));}
				                           }
				                         ;
				}
				}
				setState(90);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(91);
			match(T__6);
			setState(92);
			((VarDefinitionContext)_localctx).type = type();
			 for(String n : _localctx.names) {
			                                        _localctx.ast.add(new VariableDefinition(((VarDefinitionContext)_localctx).type.ast, n, ((VarDefinitionContext)_localctx).ID.getLine(), ((VarDefinitionContext)_localctx).ID.getCharPositionInLine()));
			                                    };
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FunctionDefinitionContext extends ParserRuleContext {
		public FunctionDefinition ast;
		public List<Statement> statements = new ArrayList<Statement>();
		public Type returnType = new None();
		public List<Statement> functionParameters = new ArrayList<Statement>();
		public Token ID;
		public ParametersContext parameters;
		public Simple_typeContext simple_type;
		public VariableDefinitionsContext variableDefinitions;
		public StatementContext statement;
		public TerminalNode ID() { return getToken(PmmParser.ID, 0); }
		public Simple_typeContext simple_type() {
			return getRuleContext(Simple_typeContext.class,0);
		}
		public ParametersContext parameters() {
			return getRuleContext(ParametersContext.class,0);
		}
		public VariableDefinitionsContext variableDefinitions() {
			return getRuleContext(VariableDefinitionsContext.class,0);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public FunctionDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PmmListener ) ((PmmListener)listener).enterFunctionDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PmmListener ) ((PmmListener)listener).exitFunctionDefinition(this);
		}
	}

	public final FunctionDefinitionContext functionDefinition() throws RecognitionException {
		FunctionDefinitionContext _localctx = new FunctionDefinitionContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_functionDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(95);
			match(T__0);
			setState(96);
			((FunctionDefinitionContext)_localctx).ID = match(ID);
			setState(97);
			match(T__2);
			setState(101);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(98);
				((FunctionDefinitionContext)_localctx).parameters = parameters();
				((FunctionDefinitionContext)_localctx).functionParameters =  ((FunctionDefinitionContext)_localctx).parameters.ast;
				}
			}

			setState(103);
			match(T__3);
			setState(104);
			match(T__4);
			setState(109);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__36:
			case T__37:
			case T__38:
				{
				setState(105);
				((FunctionDefinitionContext)_localctx).simple_type = simple_type();
				((FunctionDefinitionContext)_localctx).returnType =  ((FunctionDefinitionContext)_localctx).simple_type.ast;
				}
				break;
			case T__5:
				{
				setState(108);
				match(T__5);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(111);
			match(T__6);
			setState(112);
			match(T__7);
			setState(116);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				{
				setState(113);
				((FunctionDefinitionContext)_localctx).variableDefinitions = variableDefinitions();
				_localctx.statements.addAll(((FunctionDefinitionContext)_localctx).variableDefinitions.ast);
				}
				break;
			}
			setState(123);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 124244842610696L) != 0)) {
				{
				{
				setState(118);
				((FunctionDefinitionContext)_localctx).statement = statement();
				_localctx.statements.add(((FunctionDefinitionContext)_localctx).statement.ast);
				}
				}
				setState(125);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(126);
			match(T__8);
			((FunctionDefinitionContext)_localctx).ast =  new FunctionDefinition(_localctx.statements, (((FunctionDefinitionContext)_localctx).ID!=null?((FunctionDefinitionContext)_localctx).ID.getText():null), new FunctionType(_localctx.returnType, _localctx.functionParameters), ((FunctionDefinitionContext)_localctx).ID.getLine(), ((FunctionDefinitionContext)_localctx).ID.getCharPositionInLine() + 1);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ParametersContext extends ParserRuleContext {
		public List<Statement> ast = new ArrayList<Statement>();
		public Token ID;
		public Simple_typeContext st1;
		public Simple_typeContext st2;
		public List<TerminalNode> ID() { return getTokens(PmmParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(PmmParser.ID, i);
		}
		public List<Simple_typeContext> simple_type() {
			return getRuleContexts(Simple_typeContext.class);
		}
		public Simple_typeContext simple_type(int i) {
			return getRuleContext(Simple_typeContext.class,i);
		}
		public ParametersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameters; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PmmListener ) ((PmmListener)listener).enterParameters(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PmmListener ) ((PmmListener)listener).exitParameters(this);
		}
	}

	public final ParametersContext parameters() throws RecognitionException {
		ParametersContext _localctx = new ParametersContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_parameters);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(129);
			((ParametersContext)_localctx).ID = match(ID);
			setState(130);
			match(T__6);
			setState(131);
			((ParametersContext)_localctx).st1 = simple_type();
			}
			_localctx.ast.add(new VariableDefinition(((ParametersContext)_localctx).st1.ast, (((ParametersContext)_localctx).ID!=null?((ParametersContext)_localctx).ID.getText():null),  ((ParametersContext)_localctx).ID.getLine(), ((ParametersContext)_localctx).ID.getCharPositionInLine() + 1));
			setState(142);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__10) {
				{
				{
				setState(134);
				match(T__10);
				setState(135);
				((ParametersContext)_localctx).ID = match(ID);
				setState(136);
				match(T__6);
				setState(137);
				((ParametersContext)_localctx).st2 = simple_type();
				_localctx.ast.add(new VariableDefinition(((ParametersContext)_localctx).st2.ast, (((ParametersContext)_localctx).ID!=null?((ParametersContext)_localctx).ID.getText():null), ((ParametersContext)_localctx).ID.getLine(), ((ParametersContext)_localctx).ID.getCharPositionInLine() + 1));
				}
				}
				setState(144);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TypeContext extends ParserRuleContext {
		public Type ast;
		public List<Field> sFields = new ArrayList<Field>();
		public Simple_typeContext st1;
		public FieldsContext fields;
		public Token COMA;
		public Token INT_CONSTANT;
		public TypeContext t1;
		public Simple_typeContext simple_type() {
			return getRuleContext(Simple_typeContext.class,0);
		}
		public List<FieldsContext> fields() {
			return getRuleContexts(FieldsContext.class);
		}
		public FieldsContext fields(int i) {
			return getRuleContext(FieldsContext.class,i);
		}
		public TerminalNode INT_CONSTANT() { return getToken(PmmParser.INT_CONSTANT, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PmmListener ) ((PmmListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PmmListener ) ((PmmListener)listener).exitType(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_type);
		int _la;
		try {
			setState(167);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__36:
			case T__37:
			case T__38:
				enterOuterAlt(_localctx, 1);
				{
				setState(145);
				((TypeContext)_localctx).st1 = simple_type();
				((TypeContext)_localctx).ast =  ((TypeContext)_localctx).st1.ast;
				}
				break;
			case T__11:
				enterOuterAlt(_localctx, 2);
				{
				setState(148);
				match(T__11);
				setState(149);
				match(T__7);
				setState(156);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==ID) {
					{
					{
					setState(150);
					((TypeContext)_localctx).fields = fields();
					setState(151);
					((TypeContext)_localctx).COMA = match(T__9);
					 for(Field field : ((TypeContext)_localctx).fields.ast)
					                                                   {
					                                                       if(_localctx.sFields.contains(field))
					                                                           ErrorHandler.getInstance().addError(new ErrorType("Variable repetida: " + field.getName(), new CharLiteral("'h'", ((TypeContext)_localctx).COMA.getLine(), ((TypeContext)_localctx).COMA.getCharPositionInLine() + 1)));
					                                                       else
					                                                           _localctx.sFields.add(field);
					                                                   }
					                                              ;
					}
					}
					setState(158);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(159);
				match(T__8);
				((TypeContext)_localctx).ast =  new StructType(_localctx.sFields);
				}
				break;
			case T__12:
				enterOuterAlt(_localctx, 3);
				{
				setState(161);
				match(T__12);
				setState(162);
				((TypeContext)_localctx).INT_CONSTANT = match(INT_CONSTANT);
				setState(163);
				match(T__13);
				setState(164);
				((TypeContext)_localctx).t1 = type();
				((TypeContext)_localctx).ast =  new ArrayType(((TypeContext)_localctx).t1.ast, (((TypeContext)_localctx).INT_CONSTANT!=null?((TypeContext)_localctx).INT_CONSTANT.getText():null));
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FieldsContext extends ParserRuleContext {
		public List<Field> ast = new ArrayList<Field>();
		public List<String> fieldNames = new ArrayList<String>();
		public Token ID1;
		public Token ID2;
		public Token DP;
		public TypeContext t1;
		public List<TerminalNode> ID() { return getTokens(PmmParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(PmmParser.ID, i);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public FieldsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fields; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PmmListener ) ((PmmListener)listener).enterFields(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PmmListener ) ((PmmListener)listener).exitFields(this);
		}
	}

	public final FieldsContext fields() throws RecognitionException {
		FieldsContext _localctx = new FieldsContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_fields);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(169);
			((FieldsContext)_localctx).ID1 = match(ID);
			 _localctx.fieldNames.add((((FieldsContext)_localctx).ID1!=null?((FieldsContext)_localctx).ID1.getText():null)) ;
			setState(176);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__10) {
				{
				{
				setState(171);
				match(T__10);
				setState(172);
				((FieldsContext)_localctx).ID2 = match(ID);

				                         if (_localctx.fieldNames.contains((((FieldsContext)_localctx).ID2!=null?((FieldsContext)_localctx).ID2.getText():null))) {
				                            ErrorHandler.getInstance().addError(new ErrorType("Variable repetida: " + (((FieldsContext)_localctx).ID2!=null?((FieldsContext)_localctx).ID2.getText():null), new CharLiteral("'h'", ((FieldsContext)_localctx).ID2.getLine(), ((FieldsContext)_localctx).ID2.getCharPositionInLine() + 1)));
				                         } else {
				                            _localctx.fieldNames.add((((FieldsContext)_localctx).ID2!=null?((FieldsContext)_localctx).ID2.getText():null));
				                         }
				                     ;
				}
				}
				setState(178);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(179);
			((FieldsContext)_localctx).DP = match(T__6);
			setState(180);
			((FieldsContext)_localctx).t1 = type();
			for(String name : _localctx.fieldNames)
			                                      {
			                                           _localctx.ast.add(new Field(name, ((FieldsContext)_localctx).t1.ast, ((FieldsContext)_localctx).DP.getLine(), ((FieldsContext)_localctx).DP.getCharPositionInLine() + 1));
			                                      }
			                                   ;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StatementContext extends ParserRuleContext {
		public Statement ast;
		public List<Expression> exp = new ArrayList<Expression>();
		public List<Statement> elseBody = new ArrayList<Statement>();
		public Token PRINT;
		public ExpressionsContext expressions;
		public Token INPUT;
		public ExpressionContext ex1;
		public ExpressionContext ex2;
		public BlockContext b1;
		public BlockContext b2;
		public Token ID;
		public ExpressionsContext expressions() {
			return getRuleContext(ExpressionsContext.class,0);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<BlockContext> block() {
			return getRuleContexts(BlockContext.class);
		}
		public BlockContext block(int i) {
			return getRuleContext(BlockContext.class,i);
		}
		public TerminalNode ID() { return getToken(PmmParser.ID, 0); }
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PmmListener ) ((PmmListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PmmListener ) ((PmmListener)listener).exitStatement(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_statement);
		int _la;
		try {
			setState(235);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(183);
				((StatementContext)_localctx).PRINT = match(T__14);
				setState(185);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 124244839104520L) != 0)) {
					{
					setState(184);
					((StatementContext)_localctx).expressions = expressions();
					}
				}

				setState(187);
				match(T__9);
				((StatementContext)_localctx).ast =  new Print(((StatementContext)_localctx).expressions.ast, ((StatementContext)_localctx).PRINT.getLine(), ((StatementContext)_localctx).PRINT.getCharPositionInLine()+1);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(189);
				((StatementContext)_localctx).INPUT = match(T__15);
				setState(191);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 124244839104520L) != 0)) {
					{
					setState(190);
					((StatementContext)_localctx).expressions = expressions();
					}
				}

				setState(193);
				match(T__9);
				((StatementContext)_localctx).ast =  new Input(((StatementContext)_localctx).expressions.ast, ((StatementContext)_localctx).INPUT.getLine(), ((StatementContext)_localctx).INPUT.getCharPositionInLine()+1);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(195);
				((StatementContext)_localctx).ex1 = expression(0);
				setState(196);
				match(T__16);
				setState(197);
				((StatementContext)_localctx).ex2 = expression(0);
				setState(198);
				match(T__9);
				((StatementContext)_localctx).ast =  new Assignment(((StatementContext)_localctx).ex1.ast, ((StatementContext)_localctx).ex2.ast, ((StatementContext)_localctx).ex1.ast.getLine(), ((StatementContext)_localctx).ex1.ast.getColumn());
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(201);
				match(T__17);
				setState(202);
				((StatementContext)_localctx).ex1 = expression(0);
				setState(203);
				match(T__6);
				setState(204);
				((StatementContext)_localctx).b1 = block();
				setState(210);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
				case 1:
					{
					setState(205);
					match(T__18);
					setState(206);
					match(T__6);
					setState(207);
					((StatementContext)_localctx).b2 = block();
					((StatementContext)_localctx).elseBody =  ((StatementContext)_localctx).b2.ast;
					}
					break;
				}
				((StatementContext)_localctx).ast =  new IfElse(((StatementContext)_localctx).b1.ast, ((StatementContext)_localctx).ex1.ast, _localctx.elseBody, ((StatementContext)_localctx).ex1.ast.getLine(), ((StatementContext)_localctx).ex1.ast.getColumn());
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(214);
				match(T__19);
				setState(215);
				((StatementContext)_localctx).ex1 = expression(0);
				setState(216);
				match(T__6);
				setState(217);
				((StatementContext)_localctx).b1 = block();
				((StatementContext)_localctx).ast =  new While(((StatementContext)_localctx).b1.ast, ((StatementContext)_localctx).ex1.ast, ((StatementContext)_localctx).ex1.ast.getLine(), ((StatementContext)_localctx).ex1.ast.getColumn());
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(220);
				match(T__20);
				setState(221);
				((StatementContext)_localctx).ex1 = expression(0);
				setState(222);
				match(T__9);
				((StatementContext)_localctx).ast =  new Return(((StatementContext)_localctx).ex1.ast, ((StatementContext)_localctx).ex1.ast.getLine(), ((StatementContext)_localctx).ex1.ast.getColumn());
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(225);
				((StatementContext)_localctx).ID = match(ID);
				setState(226);
				match(T__2);
				setState(230);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 124244839104520L) != 0)) {
					{
					setState(227);
					((StatementContext)_localctx).expressions = expressions();
					((StatementContext)_localctx).exp =  ((StatementContext)_localctx).expressions.ast;
					}
				}

				setState(232);
				match(T__3);
				setState(233);
				match(T__9);
				((StatementContext)_localctx).ast =  new FunctionInvocation(new Variable((((StatementContext)_localctx).ID!=null?((StatementContext)_localctx).ID.getText():null), ((StatementContext)_localctx).ID.getLine(), ((StatementContext)_localctx).ID.getCharPositionInLine()+1), _localctx.exp, ((StatementContext)_localctx).ID.getLine(), ((StatementContext)_localctx).ID.getCharPositionInLine()+1);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BlockContext extends ParserRuleContext {
		public List<Statement> ast = new ArrayList<Statement>();
		public StatementContext statement;
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PmmListener ) ((PmmListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PmmListener ) ((PmmListener)listener).exitBlock(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_block);
		int _la;
		try {
			setState(250);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__2:
			case T__14:
			case T__15:
			case T__17:
			case T__19:
			case T__20:
			case T__22:
			case T__23:
			case INT_CONSTANT:
			case ID:
			case REAL_CONSTANT:
			case CHAR_CONSTANT:
				enterOuterAlt(_localctx, 1);
				{
				setState(237);
				((BlockContext)_localctx).statement = statement();
				_localctx.ast.add(((BlockContext)_localctx).statement.ast);
				}
				break;
			case T__7:
				enterOuterAlt(_localctx, 2);
				{
				setState(240);
				match(T__7);
				setState(246);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 124244842610696L) != 0)) {
					{
					{
					setState(241);
					((BlockContext)_localctx).statement = statement();
					_localctx.ast.add(((BlockContext)_localctx).statement.ast);
					}
					}
					setState(248);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(249);
				match(T__8);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionContext extends ParserRuleContext {
		public Expression ast;
		public List<Expression> exp = new ArrayList<Expression>();
		public ExpressionContext ex1;
		public ExpressionContext expression;
		public Simple_typeContext simple_type;
		public Token ID;
		public ExpressionsContext expressions;
		public Token INT_CONSTANT;
		public Token CHAR_CONSTANT;
		public Token REAL_CONSTANT;
		public Token OP;
		public ExpressionContext ex2;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public Simple_typeContext simple_type() {
			return getRuleContext(Simple_typeContext.class,0);
		}
		public TerminalNode ID() { return getToken(PmmParser.ID, 0); }
		public ExpressionsContext expressions() {
			return getRuleContext(ExpressionsContext.class,0);
		}
		public TerminalNode INT_CONSTANT() { return getToken(PmmParser.INT_CONSTANT, 0); }
		public TerminalNode CHAR_CONSTANT() { return getToken(PmmParser.CHAR_CONSTANT, 0); }
		public TerminalNode REAL_CONSTANT() { return getToken(PmmParser.REAL_CONSTANT, 0); }
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PmmListener ) ((PmmListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PmmListener ) ((PmmListener)listener).exitExpression(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 22;
		enterRecursionRule(_localctx, 22, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(289);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				{
				setState(253);
				match(T__2);
				setState(254);
				((ExpressionContext)_localctx).ex1 = ((ExpressionContext)_localctx).expression = expression(0);
				setState(255);
				match(T__3);
				((ExpressionContext)_localctx).ast =  ((ExpressionContext)_localctx).ex1.ast;
				}
				break;
			case 2:
				{
				setState(258);
				match(T__2);
				setState(259);
				((ExpressionContext)_localctx).simple_type = simple_type();
				setState(260);
				match(T__3);
				setState(261);
				((ExpressionContext)_localctx).ex1 = ((ExpressionContext)_localctx).expression = expression(12);
				((ExpressionContext)_localctx).ast =  new Cast(((ExpressionContext)_localctx).expression.ast, ((ExpressionContext)_localctx).simple_type.ast, ((ExpressionContext)_localctx).ex1.ast.getLine(), ((ExpressionContext)_localctx).ex1.ast.getColumn());
				}
				break;
			case 3:
				{
				setState(264);
				match(T__22);
				setState(265);
				((ExpressionContext)_localctx).ex1 = ((ExpressionContext)_localctx).expression = expression(11);
				((ExpressionContext)_localctx).ast =  new NotArithmetic(((ExpressionContext)_localctx).ex1.ast, ((ExpressionContext)_localctx).ex1.ast.getLine(), ((ExpressionContext)_localctx).ex1.ast.getColumn());
				}
				break;
			case 4:
				{
				setState(268);
				match(T__23);
				setState(269);
				((ExpressionContext)_localctx).ex1 = ((ExpressionContext)_localctx).expression = expression(10);
				((ExpressionContext)_localctx).ast =  new NotLogic(((ExpressionContext)_localctx).expression.ast, ((ExpressionContext)_localctx).ex1.ast.getLine(), ((ExpressionContext)_localctx).ex1.ast.getColumn());
				}
				break;
			case 5:
				{
				setState(272);
				((ExpressionContext)_localctx).ID = match(ID);
				setState(273);
				match(T__2);
				setState(277);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 124244839104520L) != 0)) {
					{
					setState(274);
					((ExpressionContext)_localctx).expressions = expressions();
					((ExpressionContext)_localctx).exp =  ((ExpressionContext)_localctx).expressions.ast;
					}
				}

				setState(279);
				match(T__3);
				((ExpressionContext)_localctx).ast =  new FunctionInvocation(new Variable((((ExpressionContext)_localctx).ID!=null?((ExpressionContext)_localctx).ID.getText():null), ((ExpressionContext)_localctx).ID.getLine(), ((ExpressionContext)_localctx).ID.getCharPositionInLine()+1), _localctx.exp);
				}
				break;
			case 6:
				{
				setState(281);
				((ExpressionContext)_localctx).INT_CONSTANT = match(INT_CONSTANT);
				((ExpressionContext)_localctx).ast =  new IntLiteral((((ExpressionContext)_localctx).INT_CONSTANT!=null?((ExpressionContext)_localctx).INT_CONSTANT.getText():null), ((ExpressionContext)_localctx).INT_CONSTANT.getLine(), ((ExpressionContext)_localctx).INT_CONSTANT.getCharPositionInLine()+1);
				}
				break;
			case 7:
				{
				setState(283);
				((ExpressionContext)_localctx).CHAR_CONSTANT = match(CHAR_CONSTANT);
				((ExpressionContext)_localctx).ast =  new CharLiteral((((ExpressionContext)_localctx).CHAR_CONSTANT!=null?((ExpressionContext)_localctx).CHAR_CONSTANT.getText():null), ((ExpressionContext)_localctx).CHAR_CONSTANT.getLine(), ((ExpressionContext)_localctx).CHAR_CONSTANT.getCharPositionInLine()+1);
				}
				break;
			case 8:
				{
				setState(285);
				((ExpressionContext)_localctx).REAL_CONSTANT = match(REAL_CONSTANT);
				((ExpressionContext)_localctx).ast =  new DoubleLiteral((((ExpressionContext)_localctx).REAL_CONSTANT!=null?((ExpressionContext)_localctx).REAL_CONSTANT.getText():null), ((ExpressionContext)_localctx).REAL_CONSTANT.getLine(), ((ExpressionContext)_localctx).REAL_CONSTANT.getCharPositionInLine()+1);
				}
				break;
			case 9:
				{
				setState(287);
				((ExpressionContext)_localctx).ID = match(ID);
				((ExpressionContext)_localctx).ast =  new Variable((((ExpressionContext)_localctx).ID!=null?((ExpressionContext)_localctx).ID.getText():null), ((ExpressionContext)_localctx).ID.getLine(), ((ExpressionContext)_localctx).ID.getCharPositionInLine()+1);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(323);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(321);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.ex1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(291);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(292);
						((ExpressionContext)_localctx).OP = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 234881024L) != 0)) ) {
							((ExpressionContext)_localctx).OP = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(293);
						((ExpressionContext)_localctx).ex2 = ((ExpressionContext)_localctx).expression = expression(10);
						((ExpressionContext)_localctx).ast =  new ArithmeticOperator((((ExpressionContext)_localctx).OP!=null?((ExpressionContext)_localctx).OP.getText():null), ((ExpressionContext)_localctx).ex1.ast, ((ExpressionContext)_localctx).ex2.ast, ((ExpressionContext)_localctx).ex1.ast.getLine(), ((ExpressionContext)_localctx).ex1.ast.getColumn());
						}
						break;
					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.ex1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(296);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(297);
						((ExpressionContext)_localctx).OP = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__22 || _la==T__27) ) {
							((ExpressionContext)_localctx).OP = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(298);
						((ExpressionContext)_localctx).ex2 = ((ExpressionContext)_localctx).expression = expression(9);
						((ExpressionContext)_localctx).ast =  new ArithmeticOperator((((ExpressionContext)_localctx).OP!=null?((ExpressionContext)_localctx).OP.getText():null), ((ExpressionContext)_localctx).ex1.ast, ((ExpressionContext)_localctx).ex2.ast, ((ExpressionContext)_localctx).ex1.ast.getLine(), ((ExpressionContext)_localctx).ex1.ast.getColumn());
						}
						break;
					case 3:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.ex1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(301);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(302);
						((ExpressionContext)_localctx).OP = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 33822867456L) != 0)) ) {
							((ExpressionContext)_localctx).OP = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(303);
						((ExpressionContext)_localctx).ex2 = ((ExpressionContext)_localctx).expression = expression(8);
						((ExpressionContext)_localctx).ast =  new ComparativeOperator((((ExpressionContext)_localctx).OP!=null?((ExpressionContext)_localctx).OP.getText():null), ((ExpressionContext)_localctx).ex1.ast, ((ExpressionContext)_localctx).ex2.ast, ((ExpressionContext)_localctx).ex1.ast.getLine(), ((ExpressionContext)_localctx).ex1.ast.getColumn());
						}
						break;
					case 4:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.ex1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(306);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(307);
						((ExpressionContext)_localctx).OP = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__34 || _la==T__35) ) {
							((ExpressionContext)_localctx).OP = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(308);
						((ExpressionContext)_localctx).ex2 = ((ExpressionContext)_localctx).expression = expression(7);
						((ExpressionContext)_localctx).ast =  new LogicalOperator((((ExpressionContext)_localctx).OP!=null?((ExpressionContext)_localctx).OP.getText():null), ((ExpressionContext)_localctx).ex1.ast, ((ExpressionContext)_localctx).ex2.ast, ((ExpressionContext)_localctx).ex1.ast.getLine(), ((ExpressionContext)_localctx).ex1.ast.getColumn());
						}
						break;
					case 5:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.ex1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(311);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(312);
						match(T__12);
						setState(313);
						((ExpressionContext)_localctx).ex2 = ((ExpressionContext)_localctx).expression = expression(0);
						setState(314);
						match(T__13);
						((ExpressionContext)_localctx).ast =  new ArrayAccess(((ExpressionContext)_localctx).ex1.ast, ((ExpressionContext)_localctx).ex2.ast, ((ExpressionContext)_localctx).ex1.ast.getLine(), ((ExpressionContext)_localctx).ex1.ast.getColumn());
						}
						break;
					case 6:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.ex1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(317);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(318);
						match(T__21);
						setState(319);
						((ExpressionContext)_localctx).ID = match(ID);
						((ExpressionContext)_localctx).ast =  new Point(((ExpressionContext)_localctx).ex1.ast, (((ExpressionContext)_localctx).ID!=null?((ExpressionContext)_localctx).ID.getText():null), ((ExpressionContext)_localctx).ex1.ast.getLine(), ((ExpressionContext)_localctx).ex1.ast.getColumn());
						}
						break;
					}
					} 
				}
				setState(325);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Simple_typeContext extends ParserRuleContext {
		public Type ast;
		public Simple_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simple_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PmmListener ) ((PmmListener)listener).enterSimple_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PmmListener ) ((PmmListener)listener).exitSimple_type(this);
		}
	}

	public final Simple_typeContext simple_type() throws RecognitionException {
		Simple_typeContext _localctx = new Simple_typeContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_simple_type);
		try {
			setState(332);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__36:
				enterOuterAlt(_localctx, 1);
				{
				setState(326);
				match(T__36);
				((Simple_typeContext)_localctx).ast =  new CharType();
				}
				break;
			case T__37:
				enterOuterAlt(_localctx, 2);
				{
				setState(328);
				match(T__37);
				((Simple_typeContext)_localctx).ast =  new DoubleType();
				}
				break;
			case T__38:
				enterOuterAlt(_localctx, 3);
				{
				setState(330);
				match(T__38);
				((Simple_typeContext)_localctx).ast =  new IntType();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionsContext extends ParserRuleContext {
		public List<Expression> ast = new ArrayList();
		public ExpressionContext ex1;
		public ExpressionContext ex2;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ExpressionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressions; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PmmListener ) ((PmmListener)listener).enterExpressions(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PmmListener ) ((PmmListener)listener).exitExpressions(this);
		}
	}

	public final ExpressionsContext expressions() throws RecognitionException {
		ExpressionsContext _localctx = new ExpressionsContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_expressions);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(334);
			((ExpressionsContext)_localctx).ex1 = expression(0);
			_localctx.ast.add(((ExpressionsContext)_localctx).ex1.ast);
			setState(342);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__10) {
				{
				{
				setState(336);
				match(T__10);
				setState(337);
				((ExpressionsContext)_localctx).ex2 = expression(0);
				_localctx.ast.add(((ExpressionsContext)_localctx).ex2.ast);
				}
				}
				setState(344);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 11:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 9);
		case 1:
			return precpred(_ctx, 8);
		case 2:
			return precpred(_ctx, 7);
		case 3:
			return precpred(_ctx, 6);
		case 4:
			return precpred(_ctx, 14);
		case 5:
			return precpred(_ctx, 13);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001.\u015a\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0001\u0000\u0001\u0000\u0001\u0000\u0005\u0000"+
		" \b\u0000\n\u0000\f\u0000#\t\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0003\u00015\b\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0005\u0001:\b\u0001\n\u0001\f\u0001=\t\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0003\u0002H\b\u0002\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0004\u0003N\b\u0003\u000b\u0003\f\u0003O\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0005\u0004W\b\u0004\n\u0004"+
		"\f\u0004Z\t\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0003"+
		"\u0005f\b\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0003\u0005n\b\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0003\u0005u\b\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0005\u0005z\b\u0005\n\u0005\f\u0005}\t\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0005\u0006\u008d\b\u0006\n\u0006\f\u0006\u0090\t\u0006"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0005\u0007\u009b\b\u0007\n\u0007"+
		"\f\u0007\u009e\t\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0003\u0007\u00a8\b\u0007"+
		"\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0005\b\u00af\b\b\n\b\f\b\u00b2"+
		"\t\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\t\u0001\t\u0003\t\u00ba\b\t"+
		"\u0001\t\u0001\t\u0001\t\u0001\t\u0003\t\u00c0\b\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0003\t\u00d3\b\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0003\t\u00e7"+
		"\b\t\u0001\t\u0001\t\u0001\t\u0003\t\u00ec\b\t\u0001\n\u0001\n\u0001\n"+
		"\u0001\n\u0001\n\u0001\n\u0001\n\u0005\n\u00f5\b\n\n\n\f\n\u00f8\t\n\u0001"+
		"\n\u0003\n\u00fb\b\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0003\u000b\u0116\b\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0003\u000b\u0122\b\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0005\u000b\u0142"+
		"\b\u000b\n\u000b\f\u000b\u0145\t\u000b\u0001\f\u0001\f\u0001\f\u0001\f"+
		"\u0001\f\u0001\f\u0003\f\u014d\b\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0005\r\u0155\b\r\n\r\f\r\u0158\t\r\u0001\r\u0000\u0001\u0016"+
		"\u000e\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018"+
		"\u001a\u0000\u0004\u0001\u0000\u0019\u001b\u0002\u0000\u0017\u0017\u001c"+
		"\u001c\u0001\u0000\u001d\"\u0001\u0000#$\u0178\u0000!\u0001\u0000\u0000"+
		"\u0000\u0002)\u0001\u0000\u0000\u0000\u0004G\u0001\u0000\u0000\u0000\u0006"+
		"M\u0001\u0000\u0000\u0000\bQ\u0001\u0000\u0000\u0000\n_\u0001\u0000\u0000"+
		"\u0000\f\u0081\u0001\u0000\u0000\u0000\u000e\u00a7\u0001\u0000\u0000\u0000"+
		"\u0010\u00a9\u0001\u0000\u0000\u0000\u0012\u00eb\u0001\u0000\u0000\u0000"+
		"\u0014\u00fa\u0001\u0000\u0000\u0000\u0016\u0121\u0001\u0000\u0000\u0000"+
		"\u0018\u014c\u0001\u0000\u0000\u0000\u001a\u014e\u0001\u0000\u0000\u0000"+
		"\u001c\u001d\u0003\u0004\u0002\u0000\u001d\u001e\u0006\u0000\uffff\uffff"+
		"\u0000\u001e \u0001\u0000\u0000\u0000\u001f\u001c\u0001\u0000\u0000\u0000"+
		" #\u0001\u0000\u0000\u0000!\u001f\u0001\u0000\u0000\u0000!\"\u0001\u0000"+
		"\u0000\u0000\"$\u0001\u0000\u0000\u0000#!\u0001\u0000\u0000\u0000$%\u0003"+
		"\u0002\u0001\u0000%&\u0005\u0000\u0000\u0001&\'\u0006\u0000\uffff\uffff"+
		"\u0000\'(\u0006\u0000\uffff\uffff\u0000(\u0001\u0001\u0000\u0000\u0000"+
		")*\u0005\u0001\u0000\u0000*+\u0005\u0002\u0000\u0000+,\u0005\u0003\u0000"+
		"\u0000,-\u0005\u0004\u0000\u0000-.\u0005\u0005\u0000\u0000./\u0005\u0006"+
		"\u0000\u0000/0\u0005\u0007\u0000\u000004\u0005\b\u0000\u000012\u0003\u0006"+
		"\u0003\u000023\u0006\u0001\uffff\uffff\u000035\u0001\u0000\u0000\u0000"+
		"41\u0001\u0000\u0000\u000045\u0001\u0000\u0000\u00005;\u0001\u0000\u0000"+
		"\u000067\u0003\u0012\t\u000078\u0006\u0001\uffff\uffff\u00008:\u0001\u0000"+
		"\u0000\u000096\u0001\u0000\u0000\u0000:=\u0001\u0000\u0000\u0000;9\u0001"+
		"\u0000\u0000\u0000;<\u0001\u0000\u0000\u0000<>\u0001\u0000\u0000\u0000"+
		"=;\u0001\u0000\u0000\u0000>?\u0005\t\u0000\u0000?@\u0006\u0001\uffff\uffff"+
		"\u0000@\u0003\u0001\u0000\u0000\u0000AB\u0003\u0006\u0003\u0000BC\u0006"+
		"\u0002\uffff\uffff\u0000CH\u0001\u0000\u0000\u0000DE\u0003\n\u0005\u0000"+
		"EF\u0006\u0002\uffff\uffff\u0000FH\u0001\u0000\u0000\u0000GA\u0001\u0000"+
		"\u0000\u0000GD\u0001\u0000\u0000\u0000H\u0005\u0001\u0000\u0000\u0000"+
		"IJ\u0003\b\u0004\u0000JK\u0005\n\u0000\u0000KL\u0006\u0003\uffff\uffff"+
		"\u0000LN\u0001\u0000\u0000\u0000MI\u0001\u0000\u0000\u0000NO\u0001\u0000"+
		"\u0000\u0000OM\u0001\u0000\u0000\u0000OP\u0001\u0000\u0000\u0000P\u0007"+
		"\u0001\u0000\u0000\u0000QR\u0005,\u0000\u0000RX\u0006\u0004\uffff\uffff"+
		"\u0000ST\u0005\u000b\u0000\u0000TU\u0005,\u0000\u0000UW\u0006\u0004\uffff"+
		"\uffff\u0000VS\u0001\u0000\u0000\u0000WZ\u0001\u0000\u0000\u0000XV\u0001"+
		"\u0000\u0000\u0000XY\u0001\u0000\u0000\u0000Y[\u0001\u0000\u0000\u0000"+
		"ZX\u0001\u0000\u0000\u0000[\\\u0005\u0007\u0000\u0000\\]\u0003\u000e\u0007"+
		"\u0000]^\u0006\u0004\uffff\uffff\u0000^\t\u0001\u0000\u0000\u0000_`\u0005"+
		"\u0001\u0000\u0000`a\u0005,\u0000\u0000ae\u0005\u0003\u0000\u0000bc\u0003"+
		"\f\u0006\u0000cd\u0006\u0005\uffff\uffff\u0000df\u0001\u0000\u0000\u0000"+
		"eb\u0001\u0000\u0000\u0000ef\u0001\u0000\u0000\u0000fg\u0001\u0000\u0000"+
		"\u0000gh\u0005\u0004\u0000\u0000hm\u0005\u0005\u0000\u0000ij\u0003\u0018"+
		"\f\u0000jk\u0006\u0005\uffff\uffff\u0000kn\u0001\u0000\u0000\u0000ln\u0005"+
		"\u0006\u0000\u0000mi\u0001\u0000\u0000\u0000ml\u0001\u0000\u0000\u0000"+
		"no\u0001\u0000\u0000\u0000op\u0005\u0007\u0000\u0000pt\u0005\b\u0000\u0000"+
		"qr\u0003\u0006\u0003\u0000rs\u0006\u0005\uffff\uffff\u0000su\u0001\u0000"+
		"\u0000\u0000tq\u0001\u0000\u0000\u0000tu\u0001\u0000\u0000\u0000u{\u0001"+
		"\u0000\u0000\u0000vw\u0003\u0012\t\u0000wx\u0006\u0005\uffff\uffff\u0000"+
		"xz\u0001\u0000\u0000\u0000yv\u0001\u0000\u0000\u0000z}\u0001\u0000\u0000"+
		"\u0000{y\u0001\u0000\u0000\u0000{|\u0001\u0000\u0000\u0000|~\u0001\u0000"+
		"\u0000\u0000}{\u0001\u0000\u0000\u0000~\u007f\u0005\t\u0000\u0000\u007f"+
		"\u0080\u0006\u0005\uffff\uffff\u0000\u0080\u000b\u0001\u0000\u0000\u0000"+
		"\u0081\u0082\u0005,\u0000\u0000\u0082\u0083\u0005\u0007\u0000\u0000\u0083"+
		"\u0084\u0003\u0018\f\u0000\u0084\u0085\u0001\u0000\u0000\u0000\u0085\u008e"+
		"\u0006\u0006\uffff\uffff\u0000\u0086\u0087\u0005\u000b\u0000\u0000\u0087"+
		"\u0088\u0005,\u0000\u0000\u0088\u0089\u0005\u0007\u0000\u0000\u0089\u008a"+
		"\u0003\u0018\f\u0000\u008a\u008b\u0006\u0006\uffff\uffff\u0000\u008b\u008d"+
		"\u0001\u0000\u0000\u0000\u008c\u0086\u0001\u0000\u0000\u0000\u008d\u0090"+
		"\u0001\u0000\u0000\u0000\u008e\u008c\u0001\u0000\u0000\u0000\u008e\u008f"+
		"\u0001\u0000\u0000\u0000\u008f\r\u0001\u0000\u0000\u0000\u0090\u008e\u0001"+
		"\u0000\u0000\u0000\u0091\u0092\u0003\u0018\f\u0000\u0092\u0093\u0006\u0007"+
		"\uffff\uffff\u0000\u0093\u00a8\u0001\u0000\u0000\u0000\u0094\u0095\u0005"+
		"\f\u0000\u0000\u0095\u009c\u0005\b\u0000\u0000\u0096\u0097\u0003\u0010"+
		"\b\u0000\u0097\u0098\u0005\n\u0000\u0000\u0098\u0099\u0006\u0007\uffff"+
		"\uffff\u0000\u0099\u009b\u0001\u0000\u0000\u0000\u009a\u0096\u0001\u0000"+
		"\u0000\u0000\u009b\u009e\u0001\u0000\u0000\u0000\u009c\u009a\u0001\u0000"+
		"\u0000\u0000\u009c\u009d\u0001\u0000\u0000\u0000\u009d\u009f\u0001\u0000"+
		"\u0000\u0000\u009e\u009c\u0001\u0000\u0000\u0000\u009f\u00a0\u0005\t\u0000"+
		"\u0000\u00a0\u00a8\u0006\u0007\uffff\uffff\u0000\u00a1\u00a2\u0005\r\u0000"+
		"\u0000\u00a2\u00a3\u0005(\u0000\u0000\u00a3\u00a4\u0005\u000e\u0000\u0000"+
		"\u00a4\u00a5\u0003\u000e\u0007\u0000\u00a5\u00a6\u0006\u0007\uffff\uffff"+
		"\u0000\u00a6\u00a8\u0001\u0000\u0000\u0000\u00a7\u0091\u0001\u0000\u0000"+
		"\u0000\u00a7\u0094\u0001\u0000\u0000\u0000\u00a7\u00a1\u0001\u0000\u0000"+
		"\u0000\u00a8\u000f\u0001\u0000\u0000\u0000\u00a9\u00aa\u0005,\u0000\u0000"+
		"\u00aa\u00b0\u0006\b\uffff\uffff\u0000\u00ab\u00ac\u0005\u000b\u0000\u0000"+
		"\u00ac\u00ad\u0005,\u0000\u0000\u00ad\u00af\u0006\b\uffff\uffff\u0000"+
		"\u00ae\u00ab\u0001\u0000\u0000\u0000\u00af\u00b2\u0001\u0000\u0000\u0000"+
		"\u00b0\u00ae\u0001\u0000\u0000\u0000\u00b0\u00b1\u0001\u0000\u0000\u0000"+
		"\u00b1\u00b3\u0001\u0000\u0000\u0000\u00b2\u00b0\u0001\u0000\u0000\u0000"+
		"\u00b3\u00b4\u0005\u0007\u0000\u0000\u00b4\u00b5\u0003\u000e\u0007\u0000"+
		"\u00b5\u00b6\u0006\b\uffff\uffff\u0000\u00b6\u0011\u0001\u0000\u0000\u0000"+
		"\u00b7\u00b9\u0005\u000f\u0000\u0000\u00b8\u00ba\u0003\u001a\r\u0000\u00b9"+
		"\u00b8\u0001\u0000\u0000\u0000\u00b9\u00ba\u0001\u0000\u0000\u0000\u00ba"+
		"\u00bb\u0001\u0000\u0000\u0000\u00bb\u00bc\u0005\n\u0000\u0000\u00bc\u00ec"+
		"\u0006\t\uffff\uffff\u0000\u00bd\u00bf\u0005\u0010\u0000\u0000\u00be\u00c0"+
		"\u0003\u001a\r\u0000\u00bf\u00be\u0001\u0000\u0000\u0000\u00bf\u00c0\u0001"+
		"\u0000\u0000\u0000\u00c0\u00c1\u0001\u0000\u0000\u0000\u00c1\u00c2\u0005"+
		"\n\u0000\u0000\u00c2\u00ec\u0006\t\uffff\uffff\u0000\u00c3\u00c4\u0003"+
		"\u0016\u000b\u0000\u00c4\u00c5\u0005\u0011\u0000\u0000\u00c5\u00c6\u0003"+
		"\u0016\u000b\u0000\u00c6\u00c7\u0005\n\u0000\u0000\u00c7\u00c8\u0006\t"+
		"\uffff\uffff\u0000\u00c8\u00ec\u0001\u0000\u0000\u0000\u00c9\u00ca\u0005"+
		"\u0012\u0000\u0000\u00ca\u00cb\u0003\u0016\u000b\u0000\u00cb\u00cc\u0005"+
		"\u0007\u0000\u0000\u00cc\u00d2\u0003\u0014\n\u0000\u00cd\u00ce\u0005\u0013"+
		"\u0000\u0000\u00ce\u00cf\u0005\u0007\u0000\u0000\u00cf\u00d0\u0003\u0014"+
		"\n\u0000\u00d0\u00d1\u0006\t\uffff\uffff\u0000\u00d1\u00d3\u0001\u0000"+
		"\u0000\u0000\u00d2\u00cd\u0001\u0000\u0000\u0000\u00d2\u00d3\u0001\u0000"+
		"\u0000\u0000\u00d3\u00d4\u0001\u0000\u0000\u0000\u00d4\u00d5\u0006\t\uffff"+
		"\uffff\u0000\u00d5\u00ec\u0001\u0000\u0000\u0000\u00d6\u00d7\u0005\u0014"+
		"\u0000\u0000\u00d7\u00d8\u0003\u0016\u000b\u0000\u00d8\u00d9\u0005\u0007"+
		"\u0000\u0000\u00d9\u00da\u0003\u0014\n\u0000\u00da\u00db\u0006\t\uffff"+
		"\uffff\u0000\u00db\u00ec\u0001\u0000\u0000\u0000\u00dc\u00dd\u0005\u0015"+
		"\u0000\u0000\u00dd\u00de\u0003\u0016\u000b\u0000\u00de\u00df\u0005\n\u0000"+
		"\u0000\u00df\u00e0\u0006\t\uffff\uffff\u0000\u00e0\u00ec\u0001\u0000\u0000"+
		"\u0000\u00e1\u00e2\u0005,\u0000\u0000\u00e2\u00e6\u0005\u0003\u0000\u0000"+
		"\u00e3\u00e4\u0003\u001a\r\u0000\u00e4\u00e5\u0006\t\uffff\uffff\u0000"+
		"\u00e5\u00e7\u0001\u0000\u0000\u0000\u00e6\u00e3\u0001\u0000\u0000\u0000"+
		"\u00e6\u00e7\u0001\u0000\u0000\u0000\u00e7\u00e8\u0001\u0000\u0000\u0000"+
		"\u00e8\u00e9\u0005\u0004\u0000\u0000\u00e9\u00ea\u0005\n\u0000\u0000\u00ea"+
		"\u00ec\u0006\t\uffff\uffff\u0000\u00eb\u00b7\u0001\u0000\u0000\u0000\u00eb"+
		"\u00bd\u0001\u0000\u0000\u0000\u00eb\u00c3\u0001\u0000\u0000\u0000\u00eb"+
		"\u00c9\u0001\u0000\u0000\u0000\u00eb\u00d6\u0001\u0000\u0000\u0000\u00eb"+
		"\u00dc\u0001\u0000\u0000\u0000\u00eb\u00e1\u0001\u0000\u0000\u0000\u00ec"+
		"\u0013\u0001\u0000\u0000\u0000\u00ed\u00ee\u0003\u0012\t\u0000\u00ee\u00ef"+
		"\u0006\n\uffff\uffff\u0000\u00ef\u00fb\u0001\u0000\u0000\u0000\u00f0\u00f6"+
		"\u0005\b\u0000\u0000\u00f1\u00f2\u0003\u0012\t\u0000\u00f2\u00f3\u0006"+
		"\n\uffff\uffff\u0000\u00f3\u00f5\u0001\u0000\u0000\u0000\u00f4\u00f1\u0001"+
		"\u0000\u0000\u0000\u00f5\u00f8\u0001\u0000\u0000\u0000\u00f6\u00f4\u0001"+
		"\u0000\u0000\u0000\u00f6\u00f7\u0001\u0000\u0000\u0000\u00f7\u00f9\u0001"+
		"\u0000\u0000\u0000\u00f8\u00f6\u0001\u0000\u0000\u0000\u00f9\u00fb\u0005"+
		"\t\u0000\u0000\u00fa\u00ed\u0001\u0000\u0000\u0000\u00fa\u00f0\u0001\u0000"+
		"\u0000\u0000\u00fb\u0015\u0001\u0000\u0000\u0000\u00fc\u00fd\u0006\u000b"+
		"\uffff\uffff\u0000\u00fd\u00fe\u0005\u0003\u0000\u0000\u00fe\u00ff\u0003"+
		"\u0016\u000b\u0000\u00ff\u0100\u0005\u0004\u0000\u0000\u0100\u0101\u0006"+
		"\u000b\uffff\uffff\u0000\u0101\u0122\u0001\u0000\u0000\u0000\u0102\u0103"+
		"\u0005\u0003\u0000\u0000\u0103\u0104\u0003\u0018\f\u0000\u0104\u0105\u0005"+
		"\u0004\u0000\u0000\u0105\u0106\u0003\u0016\u000b\f\u0106\u0107\u0006\u000b"+
		"\uffff\uffff\u0000\u0107\u0122\u0001\u0000\u0000\u0000\u0108\u0109\u0005"+
		"\u0017\u0000\u0000\u0109\u010a\u0003\u0016\u000b\u000b\u010a\u010b\u0006"+
		"\u000b\uffff\uffff\u0000\u010b\u0122\u0001\u0000\u0000\u0000\u010c\u010d"+
		"\u0005\u0018\u0000\u0000\u010d\u010e\u0003\u0016\u000b\n\u010e\u010f\u0006"+
		"\u000b\uffff\uffff\u0000\u010f\u0122\u0001\u0000\u0000\u0000\u0110\u0111"+
		"\u0005,\u0000\u0000\u0111\u0115\u0005\u0003\u0000\u0000\u0112\u0113\u0003"+
		"\u001a\r\u0000\u0113\u0114\u0006\u000b\uffff\uffff\u0000\u0114\u0116\u0001"+
		"\u0000\u0000\u0000\u0115\u0112\u0001\u0000\u0000\u0000\u0115\u0116\u0001"+
		"\u0000\u0000\u0000\u0116\u0117\u0001\u0000\u0000\u0000\u0117\u0118\u0005"+
		"\u0004\u0000\u0000\u0118\u0122\u0006\u000b\uffff\uffff\u0000\u0119\u011a"+
		"\u0005(\u0000\u0000\u011a\u0122\u0006\u000b\uffff\uffff\u0000\u011b\u011c"+
		"\u0005.\u0000\u0000\u011c\u0122\u0006\u000b\uffff\uffff\u0000\u011d\u011e"+
		"\u0005-\u0000\u0000\u011e\u0122\u0006\u000b\uffff\uffff\u0000\u011f\u0120"+
		"\u0005,\u0000\u0000\u0120\u0122\u0006\u000b\uffff\uffff\u0000\u0121\u00fc"+
		"\u0001\u0000\u0000\u0000\u0121\u0102\u0001\u0000\u0000\u0000\u0121\u0108"+
		"\u0001\u0000\u0000\u0000\u0121\u010c\u0001\u0000\u0000\u0000\u0121\u0110"+
		"\u0001\u0000\u0000\u0000\u0121\u0119\u0001\u0000\u0000\u0000\u0121\u011b"+
		"\u0001\u0000\u0000\u0000\u0121\u011d\u0001\u0000\u0000\u0000\u0121\u011f"+
		"\u0001\u0000\u0000\u0000\u0122\u0143\u0001\u0000\u0000\u0000\u0123\u0124"+
		"\n\t\u0000\u0000\u0124\u0125\u0007\u0000\u0000\u0000\u0125\u0126\u0003"+
		"\u0016\u000b\n\u0126\u0127\u0006\u000b\uffff\uffff\u0000\u0127\u0142\u0001"+
		"\u0000\u0000\u0000\u0128\u0129\n\b\u0000\u0000\u0129\u012a\u0007\u0001"+
		"\u0000\u0000\u012a\u012b\u0003\u0016\u000b\t\u012b\u012c\u0006\u000b\uffff"+
		"\uffff\u0000\u012c\u0142\u0001\u0000\u0000\u0000\u012d\u012e\n\u0007\u0000"+
		"\u0000\u012e\u012f\u0007\u0002\u0000\u0000\u012f\u0130\u0003\u0016\u000b"+
		"\b\u0130\u0131\u0006\u000b\uffff\uffff\u0000\u0131\u0142\u0001\u0000\u0000"+
		"\u0000\u0132\u0133\n\u0006\u0000\u0000\u0133\u0134\u0007\u0003\u0000\u0000"+
		"\u0134\u0135\u0003\u0016\u000b\u0007\u0135\u0136\u0006\u000b\uffff\uffff"+
		"\u0000\u0136\u0142\u0001\u0000\u0000\u0000\u0137\u0138\n\u000e\u0000\u0000"+
		"\u0138\u0139\u0005\r\u0000\u0000\u0139\u013a\u0003\u0016\u000b\u0000\u013a"+
		"\u013b\u0005\u000e\u0000\u0000\u013b\u013c\u0006\u000b\uffff\uffff\u0000"+
		"\u013c\u0142\u0001\u0000\u0000\u0000\u013d\u013e\n\r\u0000\u0000\u013e"+
		"\u013f\u0005\u0016\u0000\u0000\u013f\u0140\u0005,\u0000\u0000\u0140\u0142"+
		"\u0006\u000b\uffff\uffff\u0000\u0141\u0123\u0001\u0000\u0000\u0000\u0141"+
		"\u0128\u0001\u0000\u0000\u0000\u0141\u012d\u0001\u0000\u0000\u0000\u0141"+
		"\u0132\u0001\u0000\u0000\u0000\u0141\u0137\u0001\u0000\u0000\u0000\u0141"+
		"\u013d\u0001\u0000\u0000\u0000\u0142\u0145\u0001\u0000\u0000\u0000\u0143"+
		"\u0141\u0001\u0000\u0000\u0000\u0143\u0144\u0001\u0000\u0000\u0000\u0144"+
		"\u0017\u0001\u0000\u0000\u0000\u0145\u0143\u0001\u0000\u0000\u0000\u0146"+
		"\u0147\u0005%\u0000\u0000\u0147\u014d\u0006\f\uffff\uffff\u0000\u0148"+
		"\u0149\u0005&\u0000\u0000\u0149\u014d\u0006\f\uffff\uffff\u0000\u014a"+
		"\u014b\u0005\'\u0000\u0000\u014b\u014d\u0006\f\uffff\uffff\u0000\u014c"+
		"\u0146\u0001\u0000\u0000\u0000\u014c\u0148\u0001\u0000\u0000\u0000\u014c"+
		"\u014a\u0001\u0000\u0000\u0000\u014d\u0019\u0001\u0000\u0000\u0000\u014e"+
		"\u014f\u0003\u0016\u000b\u0000\u014f\u0156\u0006\r\uffff\uffff\u0000\u0150"+
		"\u0151\u0005\u000b\u0000\u0000\u0151\u0152\u0003\u0016\u000b\u0000\u0152"+
		"\u0153\u0006\r\uffff\uffff\u0000\u0153\u0155\u0001\u0000\u0000\u0000\u0154"+
		"\u0150\u0001\u0000\u0000\u0000\u0155\u0158\u0001\u0000\u0000\u0000\u0156"+
		"\u0154\u0001\u0000\u0000\u0000\u0156\u0157\u0001\u0000\u0000\u0000\u0157"+
		"\u001b\u0001\u0000\u0000\u0000\u0158\u0156\u0001\u0000\u0000\u0000\u001b"+
		"!4;GOXemt{\u008e\u009c\u00a7\u00b0\u00b9\u00bf\u00d2\u00e6\u00eb\u00f6"+
		"\u00fa\u0115\u0121\u0141\u0143\u014c\u0156";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}