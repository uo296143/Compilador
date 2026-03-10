grammar Pmm;

@header{
    import ast.*;
    import ast.definition.*;
    import ast.statement.*;
    import ast.type.*;
    import ast.statement.expression.*;
    import ast.statement.expression.constants.*;
    import errorhandler.*;
}

/******************** Parser ********************/

program returns [Program ast] locals [List<Definition> definitions = new ArrayList<Definition>()]:
                ( definition {$definitions.addAll($definition.ast);} )*
                mainFunction EOF {$definitions.add($mainFunction.ast);}
                {$ast = new Program($definitions);}
                ;

mainFunction returns [FunctionDefinition ast] locals [List<Statement> statements = new ArrayList<Statement>()]:
                     'def' MAIN='main' '(' ')' '->' 'None' ':' '{' (variableDefinitions {$statements.addAll($variableDefinitions.ast);} )?
                     ( statement {$statements.add($statement.ast);} )* '}'
                     {$ast = new FunctionDefinition($statements, "main", new FunctionType(new None(), new ArrayList<Statement>()), $MAIN.getLine(), $MAIN.getCharPositionInLine()+1);}
                     ;

definition returns [List<Definition> ast = new ArrayList<Definition>()]: variableDefinitions {$ast.addAll($variableDefinitions.ast);}
                   | functionDefinition {$ast.add($functionDefinition.ast);}
                   ;

variableDefinitions returns [List<VariableDefinition> ast = new ArrayList<VariableDefinition>()] :
                           ( varDefinition COMA=';' {for(VariableDefinition variable : $varDefinition.ast)
                                                       {
                                                           if($ast.contains(variable)){
                                                               ErrorHandler.getInstance().addError(new ErrorType("Variable repetida: " + variable.getName(), new CharLiteral("'h'", $COMA.getLine(), $COMA.getCharPositionInLine() + 1)));
                                                           }else{
                                                               $ast.add(variable);
                                                           }
                                                       }
                                                    ;}
                           )+
                           ;

varDefinition returns [List<VariableDefinition> ast = new ArrayList<VariableDefinition>()] locals [List<String> names = new ArrayList<String>()]:
                      ID {$names.add($ID.text);}
                      ( ',' ID  {
                           if ($names.contains($ID.text)) {
                                ErrorHandler.getInstance().addError(new ErrorType("Variable repetida: " + $ID.text, new CharLiteral("'h'", $ID.getLine(), $ID.getCharPositionInLine() + 1)));
                           } else {
                                {$names.add($ID.text);}
                           }
                         ;}
                      )* ':' type { for(String n : $names) {
                                        $ast.add(new VariableDefinition($type.ast, n, $ID.getLine(), $ID.getCharPositionInLine()));
                                    };}
                     ;

functionDefinition returns [FunctionDefinition ast] locals [List<Statement> statements = new ArrayList<Statement>(), Type returnType = new None(),
                                                           List<Statement> functionParameters = new ArrayList<Statement>()]:
                           'def' ID '(' (parameters {$functionParameters = $parameters.ast;}) ?  ')' '->' (simple_type {$returnType = $simple_type.ast;} |'None') ':'
                           '{' (variableDefinitions {$statements.addAll($variableDefinitions.ast);} )?
                           ( statement {$statements.add($statement.ast);} )* '}'
                           {$ast = new FunctionDefinition($statements, $ID.text, new FunctionType($returnType, $functionParameters), $ID.getLine(), $ID.getCharPositionInLine() + 1);}
                           ;

parameters returns [List<Statement> ast = new ArrayList<Statement>()] : (ID ':' st1=simple_type) {$ast.add(new VariableDefinition($st1.ast, $ID.text,  $ID.getLine(), $ID.getCharPositionInLine() + 1));}
                   (',' ID ':' st2=simple_type {$ast.add(new VariableDefinition($st2.ast, $ID.text, $ID.getLine(), $ID.getCharPositionInLine() + 1));} )*
                   ;

type returns [Type ast] locals [List<Field> sFields = new ArrayList<Field>()]: st1=simple_type {$ast = $st1.ast;}
             | 'struct' '{' ( fields COMA=';' { for(Field field : $fields.ast)
                                                   {
                                                       if($sFields.contains(field))
                                                           ErrorHandler.getInstance().addError(new ErrorType("Variable repetida: " + field.getName(), new CharLiteral("'h'", $COMA.getLine(), $COMA.getCharPositionInLine() + 1)));
                                                       else
                                                           $sFields.add(field);
                                                   }
                                              ;}
                            )* '}' {$ast = new StructType($sFields);}
             | '[' INT_CONSTANT ']' t1=type {$ast = new ArrayType($t1.ast, $INT_CONSTANT.text);}
             ;

fields returns [List<Field> ast = new ArrayList<Field>()] locals [List<String> fieldNames = new ArrayList<String>()]:
               ID1=ID { $fieldNames.add($ID1.text) ;} (',' ID2=ID
                     {
                         if ($fieldNames.contains($ID2.text)) {
                            ErrorHandler.getInstance().addError(new ErrorType("Variable repetida: " + $ID2.text, new CharLiteral("'h'", $ID2.getLine(), $ID2.getCharPositionInLine() + 1)));
                         } else {
                            $fieldNames.add($ID2.text);
                         }
                     ;}
                  )* ':' t1=type {for(String name : $fieldNames)
                                      {
                                           $ast.add(new Field(name, $t1.ast));
                                      }
                                   ;}

               ;

statement returns [Statement ast] locals [List<Expression> exp = new ArrayList<Expression>(), List<Statement> elseBody = new ArrayList<Statement>()]:
                   PRINT='print' expressions? ';' {$ast = new Print($expressions.ast, $PRINT.getLine(), $PRINT.getCharPositionInLine()+1);}
                  | INPUT='input' expressions? ';' {$ast = new Input($expressions.ast, $INPUT.getLine(), $INPUT.getCharPositionInLine()+1);}
                  | ex1=expression '=' ex2=expression ';' {$ast = new Assignment($ex1.ast, $ex2.ast, $ex1.ast.getLine(), $ex1.ast.getColumn());}
                  | 'if' ex1=expression ':' b1=block ( 'else' ':' b2=block {$elseBody = $b2.ast;} )? {$ast = new IfElse($b1.ast, $ex1.ast, $elseBody, $ex1.ast.getLine(), $ex1.ast.getColumn());}
                  | 'while' ex1=expression ':' b1=block {$ast = new While($b1.ast, $ex1.ast, $ex1.ast.getLine(), $ex1.ast.getColumn());}
                  | 'return' ex1=expression ';' {$ast = new Return($ex1.ast, $ex1.ast.getLine(), $ex1.ast.getColumn());}
                  | ID '(' (expressions {$exp = $expressions.ast;}) ? ')' ';' {$ast = new FunctionInvocation(new Variable($ID.text, $ID.getLine(), $ID.getCharPositionInLine()+1), $exp, $ID.getLine(), $ID.getCharPositionInLine()+1);}
                  ;

block returns [List<Statement> ast = new ArrayList<Statement>()]: statement {$ast.add($statement.ast);}
              | '{' (statement {$ast.add($statement.ast);}) * '}'
              ;

expression returns [Expression ast] locals [List<Expression> exp = new ArrayList<Expression>()]: '(' ex1=expression ')' {$ast = $ex1.ast;}
                   | ex1=expression '[' ex2=expression ']' {$ast = new ArrayAccess($ex1.ast, $ex2.ast, $ex1.ast.getLine(), $ex1.ast.getColumn());}
                   | ex1=expression '.' ID {$ast = new Point($ex1.ast, $ID.text, $ex1.ast.getLine(), $ex1.ast.getColumn());}
                   | '(' simple_type ')' ex1=expression {$ast = new Cast($expression.ast, $simple_type.ast, $ex1.ast.getLine(), $ex1.ast.getColumn());}
                   | '-' ex1=expression {$ast = new NotArithmetic($ex1.ast, $ex1.ast.getLine(), $ex1.ast.getColumn());}
                   | '!' ex1=expression {$ast = new NotLogic($expression.ast, $ex1.ast.getLine(), $ex1.ast.getColumn());}
                   | ex1=expression OP=('*'|'/'|'%') ex2=expression {$ast = new ArithmeticOperator($OP.text, $ex1.ast, $ex2.ast, $ex1.ast.getLine(), $ex1.ast.getColumn());}
                   | ex1=expression OP=('+'|'-') ex2=expression {$ast = new ArithmeticOperator($OP.text, $ex1.ast, $ex2.ast, $ex1.ast.getLine(), $ex1.ast.getColumn());}
                   | ex1=expression OP=('>'|'>='|'<'|'<='|'!='|'==') ex2=expression {$ast = new ComparativeOperator($OP.text, $ex1.ast, $ex2.ast, $ex1.ast.getLine(), $ex1.ast.getColumn());}
                   | ex1=expression OP=('&&'|'||') ex2=expression {$ast = new LogicalOperator($OP.text, $ex1.ast, $ex2.ast, $ex1.ast.getLine(), $ex1.ast.getColumn());}
                   | ID '(' (expressions {$exp = $expressions.ast;}) ? ')' {$ast = new FunctionInvocation(new Variable($ID.text, $ID.getLine(), $ID.getCharPositionInLine()+1), $exp);}
                   | INT_CONSTANT {$ast = new IntLiteral($INT_CONSTANT.text, $INT_CONSTANT.getLine(), $INT_CONSTANT.getCharPositionInLine()+1);}
                   | CHAR_CONSTANT {$ast = new CharLiteral($CHAR_CONSTANT.text, $CHAR_CONSTANT.getLine(), $CHAR_CONSTANT.getCharPositionInLine()+1);}
                   | REAL_CONSTANT {$ast = new DoubleLiteral($REAL_CONSTANT.text, $REAL_CONSTANT.getLine(), $REAL_CONSTANT.getCharPositionInLine()+1);}
                   | ID {$ast = new Variable($ID.text, $ID.getLine(), $ID.getCharPositionInLine()+1);}
                   ;

simple_type returns [Type ast]:
                    'char' {$ast = new CharType();}
                    |'double' {$ast = new DoubleType();}
                    |'int' {$ast = new IntType();}
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
               (REAL_SIMPLE_CONSTANT|INT_PART) [eE] [-+]? INT_PART;

CHAR_CONSTANT:'\'' .? '\'' |
              '\'\\' [nt] '\'' |
              '\'\\' [0-9]+ '\'' ;






