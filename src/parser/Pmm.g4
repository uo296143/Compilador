grammar Pmm;	

program: definition* mainProgram
         ;

mainProgram: 'def' 'main' '(' ')' '->' 'None' ':' '{' (variableDefinition)* (statement)* '}'
             ;

definition: variableDefinition | functionDefinition
            ;

variableDefinition: ID (',' ID)* ':' type ';'
                    | ID ':' 'struct' '{' (ID ':' type ';')* '}' ';'
                    | ID ':' expression type';'
                    ;

functionDefinition: 'def' ID '(' (ID ':' simple_type)? (',' ID ':' simple_type )*  ')' '->' type ':' '{' (variableDefinition)* (statement)* '}'
                    ;

type: ('int'|'double'|'char'|'None')
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

expression: '(' expression ')'
            | ID ('[' expression ']')+
            | ('[' expression ']')+
            | expression '.' ID
            | '(' simple_type ')' expression
            | '-' expression
            | '!' expression
            | expression ('*'|'/'|'%') expression
            | expression ('+'|'-') expression
            | expression ('>'|'>='|'<'|'<='|'!='|'==') expression
            | expression ('&&'|'||') expression
            | functionInvocation
            | INT_CONSTANT
            | CHAR_CONSTANT
            | REAL_CONSTANT
            | ID
            ;

simple_type: 'char'|'double'|'int'
             ;

functionInvocation: ID '(' expression? (',' expression)* ')'
                    ;



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






