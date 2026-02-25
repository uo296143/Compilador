grammar Pmm;

@header{
    import ast.statement,*;
}

program: definition* mainProgram
         ;

mainProgram: 'def' 'main' '(' ')' '->' 'None' ':' '{' (variableDefinition)* (statement)* '}'
             ;

definition: variableDefinition | functionDefinition
            ;

variableDefinition: ID (',' ID)* ':' type ';'
                    ;

functionDefinition: 'def' ID '(' parameters?  ')' '->' (simple_type|'None') ':' '{' (variableDefinition)* (statement)* '}'
                    ;
parameters: (ID ':' simple_type) (',' ID ':' simple_type )*
        ;

type: simple_type
    | 'struct' '{' (ID ':' type ';')* '}'
    | '[' INT_CONSTANT ']' type
     ;

statement: 'print' expression (',' expression )* ';'
           | 'input' expression (',' expression )* ';'
           | expression '=' expression ';'
           | 'if' expression ':' '{' statement* '}' ( 'else' '{' statement* '}' )?
           | 'if' expression ':' '{' statement '}' ( 'else' statement )?
           | 'if' expression ':' statement ( 'else' ':' '{' statement* '}' )?
           | 'if' expression ':' statement ( 'else' ':' statement )?
           | 'while' expression ':' statement
           | 'while' expression ':' '{' statement* '}'
           | 'return' expression ';'
           | functionInvocation ';'
           ;


expression returns [Expression ast]: '(' ex1=expression ')' {$ast = new ArrayAccess($ID.text, $expression.ast);}
            | ex1=expression '[' ex2=expression ']' {$ast = new ArrayAccess($ID.text, $expression.ast);}
            | ex1=expression '.' ID {$ast = new Point($expression.ast, $ID.text);}
            | '(' simple_type ')' ex1=expression {$ast = new Cast($expression.ast, $simple_type.ast);}
            | '-' ex1=expression {$ast = new NotArithmetic($expression.ast);}
            | '!' ex1=expression {$ast = new NotLogic($expression.ast);}
            | ex1=expression OP=('*'|'/'|'%') ex2=expression {$ast = new ArithmeticOperator($OP.text, $ex1.ast, $ex2.ast);}
            | ex1=expression OP=('+'|'-') ex2=expression {$ast = new ArithmeticOperator($OP.text, $ex1.ast, $ex2.ast);}
            | ex1=expression OP=('>'|'>='|'<'|'<='|'!='|'==') ex2=expression {$ast = new ComparativeOperator($OP.text, $ex1.ast, $ex2.ast);}
            | ex1=expression OP=('&&'|'||') ex2=expression {$ast = new LogicalOperator($OP.text, $ex1.ast, $ex2.ast);}
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

functionInvocation: ID '(' expressions? ')' {$ast = new FunctionInvocation(new Variable($ID.text), $ex1.ast, $expressions.ast);}
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






