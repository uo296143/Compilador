grammar Pmm;

@header{
    import ast.definition.*;
    import ast.statement.*;
    import ast.type.*;
    import ast.statement.expression.*;
    import ast.statement.expression.constants.*;
}

program returns [Program ast]: definition* mainProgram
         ;

mainProgram returns [Program ast]: 'def' 'main' '(' ')' '->' 'None' ':' '{' (variableDefinition)* (statement)* '}'
             ;

definition returns [Definition ast]: variableDefinition | functionDefinition
            ;

variableDefinition returns [Definition ast, List<Statement> variableDefinitions = new ArrayList<Statement>()]: ID (',' ID)* ':' type ';'
                    ;

functionDefinition returns [FunctionDefinition ast, List<List<Statement>> statements = new ArrayList<List<Statement>>()]:
                           'def' ID '(' parameters?  ')' '->' (simple_type|'None') ':'
                           '{' (variableDefinition)* {$variableDefinition.variableDefinitions.foreach( variableDefinitions -> $statements.add(variableDefinitions) );}
                           (statement)* '}' {$statement.ast.foreach( statement -> $statements.add($statement) );}
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

statement returns [Statement ast]: 'print' expressions? ';' {$ast = new Print($expressions.ast, $expressions.ast.getLine(), $expressions.ast.getColumn());}
           | 'input' expressions? ';' {$ast = new Input($expressions.ast, $expressions.ast.getLine(), $expressions.ast.getColumn());}
           | ex1=expression '=' ex2=expression ';' {$ast = new Assignment($ex1.ast, $ex2.ast, $ex1.ast.getLine(), $ex1.ast.getColumn());}
           | 'if' ex1=expression ':' '{' stmt1=statement* '}' ( 'else' '{' stmt2=statement* '}' )?
           | 'if' ex1=expression ':' '{' stmt1=statement* '}' ( 'else' stmt2=statement )?
           | 'if' ex1=expression ':' stmt1=statement ( 'else' ':' '{' stmt2=statement* '}' )?
           | 'if' ex1=expression ':' stmt1=statement ( 'else' ':' stmt2=statement )?
           | 'while' ex1=expression ':' stmt1=statement {$ast = new While($ex1.ast, $stmt1.ast, $ex1.ast.getLine(), $ex1.ast.getColumn());}
           | 'while' ex1=expression ':' '{' stmt1=statement* '}'
           | 'return' ex1=expression ';' {$ast = new Return($ex1.ast, $ex1.ast.getLine(), $ex1.ast.getColumn());}
           | fi1=functionInvocation ';' {$ast = $fi1.ast;}
           ;


expression returns [Expression ast]: '(' ex1=expression ')' {$ast = new ArrayAccess($ex1.ast, $ex2.ast, $ex1.ast.getLine(), $ex1.ast.getColumn());}
            | ex1=expression '[' ex2=expression ']' {$ast = new ArrayAccess($ex1.ast, $ex2.ast, $ex1.ast.getLine(), $ex1.ast.getColumn());}
            | ex1=expression '.' ID {$ast = new Point($expression.ast, $ID.text, $ex1.ast.getLine(), $ex1.ast.getColumn());}
            | '(' simple_type ')' ex1=expression {$ast = new Cast($expression.ast, $simple_type.ast, $ex1.ast.getLine(), $ex1.ast.getColumn());}
            | '-' ex1=expression {$ast = new NotArithmetic($ex1.ast, $ex1.ast.getLine(), $ex1.ast.getColumn());}
            | '!' ex1=expression {$ast = new NotLogic($expression.ast, $ex1.ast.getLine(), $ex1.ast.getColumn());}
            | ex1=expression OP=('*'|'/'|'%') ex2=expression {$ast = new ArithmeticOperator($OP.text, $ex1.ast, $ex2.ast, $ex1.ast.getLine(), $ex1.ast.getColumn());}
            | ex1=expression OP=('+'|'-') ex2=expression {$ast = new ArithmeticOperator($OP.text, $ex1.ast, $ex2.ast, $ex1.ast.getLine(), $ex1.ast.getColumn());}
            | ex1=expression OP=('>'|'>='|'<'|'<='|'!='|'==') ex2=expression {$ast = new ComparativeOperator($OP.text, $ex1.ast, $ex2.ast, $ex1.ast.getLine(), $ex1.ast.getColumn());}
            | ex1=expression OP=('&&'|'||') ex2=expression {$ast = new LogicalOperator($OP.text, $ex1.ast, $ex2.ast, $ex1.ast.getLine(), $ex1.ast.getColumn());}
            | functionInvocation
            | INT_CONSTANT {$ast = new IntLiteral($INT_CONSTANT.text);}
            | CHAR_CONSTANT {$ast = new CharLiteral($CHAR_CONSTANT.text);}
            | REAL_CONSTANT {$ast = new DoubleLiteral($REAL_CONSTANT.text);}
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






