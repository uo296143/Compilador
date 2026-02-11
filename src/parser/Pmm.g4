grammar Pmm;	

program:
       ;

fragment
LETTER: [a-zA-Z];

fragment
INT_PART: [1-9][0-9]*;

fragment
EXPONENT: [Ee]'-'?INT_PART*;

INT_CONSTANT: [0]|INT_PART;

LINE_COMMENT: ('#'.*? '\r'? ('\n' | EOF)) -> skip;

WHITE_SPACE: [ \r\n\t]+ -> skip;

BLOCK_COMMENT:  '"""'.*?'"""' -> skip;

IDENTIFIER: ('_'|LETTER)(LETTER|'_'|INT_CONSTANT)*;

REAL_CONSTANT: INT_PART?.?INT_PART?EXPONENT?;




