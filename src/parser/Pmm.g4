grammar Pmm;

@header{
    import ast.definition.*;
    import ast.statement.*;
    import ast.type.*;
    import ast.statement.expression.*;
    import ast.statement.expression.constants.*;
}

program returns [Program ast]: definition* mainProgram EOF
         ;

mainProgram returns [Program ast] locals [List<Definition> definitions = new ArrayList<Definition>()]:
                           'def' 'main' '(' ')' '->' 'None' ':' '{' ( variableDefinition {$definitions.addAll($variableDefinition.ast);} )*
                           ( statement {$definitions.add($statement.ast);} )* '}'
                           {$ast = new Program($definitions);}
             ;

definition returns [Definition ast]: variableDefinition | functionDefinition
            ;

variableDefinition returns [List<VariableDefinition> ast]:
                        ID (',' ID)* ':' type ';'
                    ;

functionDefinition returns [FunctionDefinition ast] locals [List<Statement> statements = new ArrayList<Statement>(), Type returnType]:
                           'def' ID '(' parameters?  ')' '->' (simple_type|'None') ':'
                           '{' (variableDefinition)* {$statements.addAll($variableDefinition.ast);}
                           (statement {$statements.add($statement.ast);})* '}'
                           /* Aquí hay que comprobar si simple_type es null. ¿ Y también si parameters lo es ? */
                           {$ast = new FunctionDefinition($statements, new Variable($ID.text, new FunctionType($simple_type.ast, $parameters.ast);}
                    ;

parameters returns [List<Variable> ast = new ArrayList<Variable>]: (ID ':' st1=simple_type) {$ast.add(new Variable($ID.text, $st1.ast, $ID.getLine(), $ID.getCharPositionInLine() + 1);}
                                     (',' ID ':' st2=simple_type )* {$ast.add(new Variable($ID.text, $st2.ast, $ID.getLine(), $ID.getCharPositionInLine() + 1);}
        ;

type returns [Type ast, List<Field> fields = new ArrayList<Field>()]: st1=simple_type {$ast = $st1.ast;}
    | 'struct' '{' (ID ':' t1=type ';')* '}' {$ast = new Struct($fields.forEach(field ->  $fields.add(new Field($ID.text, $t1.ast));}
    | '[' INT_CONSTANT ']' t1=type {$ast = new Array($ast = t1, $INT_CONSTANT.text);}
     ;

statement returns [Statement ast]: 'print' expressions? ';' {$ast = new Print($expressions.ast, $expressions.ast.get(0).getLine(), $expressions.ast.get(0).getColumn());}
           | 'input' expressions? ';' {$ast = new Input($expressions.ast, $expressions.ast.get(0).getLine(), $expressions.ast.get(0).getColumn());}
           | ex1=expression '=' ex2=expression ';' {$ast = new Assignment($ex1.ast, $ex2.ast, $ex1.ast.getLine(), $ex1.ast.getColumn());}
           | 'if' ex1=expression ':' b1=block ( 'else' ':' b2=block )? {$ast = new IfElse($b1.ast, $ex1.ast, $b2.ast, $ex1.ast.getLine(), $ex1.ast.getColumn());}
           | 'while' ex1=expression ':' b1=block {$ast = new While($b1.ast, $ex1.ast, $ex1.ast.getLine(), $ex1.ast.getColumn());}
           | 'return' ex1=expression ';' {$ast = new Return($ex1.ast, $ex1.ast.getLine(), $ex1.ast.getColumn());}
           | fi1=functionInvocation ';' {$ast = $fi1.ast;}
           ;

block returns [List<Statement> ast = new ArrayList<Statement>()]: statement {$ast.add($statement.ast);}
        | '{' (statement {$ast.add($statement.ast);}) * '}'
        ;

expression returns [Expression ast]: '(' ex1=expression ')' {$ast = $ex1.ast;}
            | ex1=expression '[' ex2=expression ']' {$ast = new ArrayAccess($ex1.ast, $ex2.ast, $ex1.ast.getLine(), $ex1.ast.getColumn());}
            | ex1=expression '.' ID {$ast = new Point($ex1.ast, $ID.text, $ex1.ast.getLine(), $ex1.ast.getColumn());}
            | '(' simple_type ')' ex1=expression {$ast = new Cast($expression.ast, $simple_type.ast, $ex1.ast.getLine(), $ex1.ast.getColumn());}
            | '-' ex1=expression {$ast = new NotArithmetic($ex1.ast, $ex1.ast.getLine(), $ex1.ast.getColumn());}
            | '!' ex1=expression {$ast = new NotLogic($expression.ast, $ex1.ast.getLine(), $ex1.ast.getColumn());}
            | ex1=expression OP=('*'|'/'|'%') ex2=expression {$ast = new ArithmeticOperator($OP.text, $ex1.ast, $ex2.ast, $ex1.ast.getLine(), $ex1.ast.getColumn());}
            | ex1=expression OP=('+'|'-') ex2=expression {$ast = new ArithmeticOperator($OP.text, $ex1.ast, $ex2.ast, $ex1.ast.getLine(), $ex1.ast.getColumn());}
            | ex1=expression OP=('>'|'>='|'<'|'<='|'!='|'==') ex2=expression {$ast = new ComparativeOperator($OP.text, $ex1.ast, $ex2.ast, $ex1.ast.getLine(), $ex1.ast.getColumn());}
            | ex1=expression OP=('&&'|'||') ex2=expression {$ast = new LogicalOperator($OP.text, $ex1.ast, $ex2.ast, $ex1.ast.getLine(), $ex1.ast.getColumn());}
            | functionInvocation
            | INT_CONSTANT {$ast = new IntLiteral($INT_CONSTANT.text, $INT_CONSTANT.getLine(), $INT_CONSTANT.getCharPositionInLine()+1);}
            | CHAR_CONSTANT {$ast = new CharLiteral($CHAR_CONSTANT.text, $CHAR_CONSTANT.getLine(), $CHAR_CONSTANT.getCharPositionInLine()+1);}
            | REAL_CONSTANT {$ast = new DoubleLiteral($REAL_CONSTANT.text, $REAL_CONSTANT.getLine(), $REAL_CONSTANT.getCharPositionInLine()+1);}
            | ID {$ast = new Variable($ID.text);}
            ;

simple_type returns [Type ast]:
            'char' {$ast = new CharType();}
            |'double' {$ast = new DoubleType();}
            |'int' {$ast = new IntType();}
            ;

functionInvocation returns [FunctionInvocation ast]: ID '(' expressions? ')' {$ast = new FunctionInvocation(new Variable($ID.text), $expressions.ast);}
                    ;

expressions returns [List<Expression> ast = new ArrayList()]:
        ex1=expression {$ast.add($ex1.ast);}
        (',' ex2=expression {$ast.add($ex2.ast);} )*
        ;

/*
 * .start devuelve el 1º token
 */

/******************** Lexer ********************/

fragment
LETTER: [a-zA-Z];

fragment
INT_PART: [1-9][0-9]*;

fragment
DECIMAL_PART: [0-9]*[1-9];

fragment
REAL_SIMPLE_CONSTANT: INT_PART'.'DECIMAL_PART? |
                      '.'DECIMAL_PART;
fragment
EXPONENT: [Ee]'-'?INT_PART*;

/******************** Reglas ********************/

INT_CONSTANT: [0]|INT_PART;

LINE_COMMENT: ('#'.*? '\r'? ('\n' | EOF)) -> skip;

WHITE_SPACE: [ \r\n\t]+ -> skip;

BLOCK_COMMENT:  '"""'.*?'"""' -> skip;

ID: ('_'|LETTER)(LETTER|'_'|INT_CONSTANT)*;

REAL_CONSTANT: REAL_SIMPLE_CONSTANT |
               (REAL_SIMPLE_CONSTANT|INT_PART) [eE] [-]? INT_PART;

CHAR_CONSTANT:'\'' .? '\'' |
              '\'\\' [nt] '\'' |
              '\'\\' [0-9]+ '\'' ;






