/*
 * References: https://github.com/antlr/grammars-v4/blob/master/c/C.g4
 * 
 * NOTES:
 * Remember to save after you change anything. 
 * If you change the initial rule, remember to change it
 * also in main.
 * 
 * FIRST RULE IS AT THE BOTTOM 
 * 
 * OBS!!! white spaces matters!!! 
 * A way to don't think too much about it is adding 
 * the WS rule every time is needed. 
 * WS : [ \t\r\n]+ -> skip ;
 * */


grammar Hello;
//One rule to rule them all


/* 
 * From bottom to top. 
 * This sections goes from 
 * atoms to compound rules
 * */
 
TYPE : 
	'int'	|	
	'char' 	|
	STRUCTS;
	
WS 
	: [ \t\n]* -> skip ;

INT
	:  [0-9];
CHAR 
	: [a-zA-Z_];
CHARINPUT
	: '\'' CHAR '\'';
ID
	:  CHAR+;
	

VARDEC
	: TYPE WS ID WS ARR*;
	
ARR
	: '[' WS INT* WS ']';
/*
 * STRUCT
 * */
STRUCT
	: STRUCTS WS '{' WS STRUCTCONTENT* WS '}' WS ';'; 

STRUCTS
	: 'struct' WS ID;
	
STRUCTCONTENT
	: WS VARDEC WS ';'  ;
/*
 * FUNCTION
 * 
 */	
 FUNC
 	: VARDEC '(' WS PARAM* WS ')' WS BLOCK WS RETURN;

 RETURN
 	:'return' WS VAR WS';' WS '}' ; 
 BLOCK
 	: '{' WS BLOCKCONTENT WS;
 
 CONDITION
 	: CONDITIONAL WS '(' WS CONDICONTENT WS ')' WS BLOCK WS '}';
 	
 CONDICONTENT
 	: BOOL|NEG;
 BOOL
 	:BOOLPARA BOOLPARAS+;
 BOOLPARA
 	: VAR ARR? MEMBER?;
 MEMBER
 	: '.' CHAR;
 BOOLPARAS
 	: OP BOOLPARA;
 NEG
 	: '!' BOOLPARA;
 OP
 	: '>'|'<'|'>='|'<='|'=='|'||'|'&&' | '!=';
 CONDITIONAL
 	: 	'while'|'if';
 BLOCKCONTENT
 	: A* WS CONDITION*;
 //I run out of names, this is things like id id[] or expressions
A
	: STRUCTARREND | EXP | CALLING;
 EXP
 	: TYPE* WS ID WS '=' WS EXPCONTENT ;
 EXPCONTENT
 	: ARITH | CALLING ;
 	//OBS ARR* != ARR [0-1] = ?
 STRUCTARREND
 	:STRUCTARR WS ';';
 STRUCTARR
 	: ID WS ID WS ARR? ;
CALLING
 	: ID WS '(' WS CALL* WS ')' ';';
CALL
	:VAR WS CALLS*;
CALLS
	: ',' VAR;
 ARITH
 	: VARINPUT WS ARITHS* WS ';';
 ARITHS
 	: UNARYOP WS VAR;
 UNARYOP
 	: '+'|'-'|'*'|'/'|'%'; 
 		
 VAR
 	: INT | CHAR | ID;
 VARINPUT
 	: INT | CHARINPUT | ID;
 
 PARAM
 	: PARAMLHS PARAMS*;
 PARAMLHS
 	: VARDEC|STRUCTARR|STRUCT;
  	
 PARAMS
 : ',' WS PARAMLHS; 
 
 
p : STRUCT*  FUNC*;
