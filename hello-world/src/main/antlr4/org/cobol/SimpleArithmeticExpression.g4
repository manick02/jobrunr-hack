// https://stackoverflow.com/questions/23092081/antlr4-visitor-pattern-on-simple-arithmetic-example

grammar SimpleArithmeticExpression;
start : expr ;

expr  : left=expr op=('*'|'/') right=expr #opExpr
      | left=expr op=('+'|'-') right=expr #opExpr
      | '(' expr ')'                      #parenExpr
      | atom=INT                          #atomExpr
      ;

INT   : ('0'..'9')+ ;

WS    : [ \t\r\n]+ -> skip ;