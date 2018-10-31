/**
 * Define a grammar called Hello
 * https://github.com/antlr4ide/antlr4ide
 */
grammar Hello;
r  : STRUCT* FUNCTION* ;         


 
INT : [0-9]+; 
 	
CHAR : [a-zA-Z_];

ID : CHAR+;
 
OPTWS : [ \t\r\n]* -> skip ; // skip spaces, tabs, newlines

WS:[ \t\r\n]+ -> skip ; 

QUOTE: '\'' ;

UnaryOP :   '/' | '*' | '+' | '-'  ;


/*
 * STRUCT
 * 
 */
 
 STRUCT: VarStruct '{' VarDecls* '}' ';';
    
 //declaration of variables inside struct
 VarDecls: VarDec ';' VarDecls*;
 
 VarDec: TYPE WS ID ARR?;
 
 TYPE:'int'|'char'|VarStruct;
 
 VarStruct:'struct'  WS ID;
 
 ARR:'['ArrayContent*']';
 
 ArrayContent:INT|CHAR|ID;
 
 /*
  * FUNC
  * 
  */
  
// VarDec: TYPE WS ID ARR*;
FUNCTION:VarDec PARAM FuncBLOCK RETURN;
  
PARAM:'('ParaContent*')';
  
//One or more with comma
ParaContent:FuncVarDec ParaContents*;
ParaContents:',' FuncVarDec;
  
//ID: The name of the instance used in the parameter, for instance (location food)
FuncVarDec:TypeOrStruct WS ID ARR? ;

//Type or the name of the struct, for instance "location"
TypeOrStruct:TYPE|ID;

/*
 * Func BLOCK
 * 
 */
FuncBLOCK:'{' FuncBlockContent* CONDITIONALS*;
  
FuncBlockContent:FuncBlockVarDecl|FuncBlockVarArg;

FuncBlockVarDecl: TypeOrStruct WS GeneralBlockPattern  ;

//OBS This rule is used inside conditionals  
GeneralBlockPattern: ID ARR?  ARITHMETIC? ';' ;

FuncBlockVarArg:VarWithArguments ';';
VarWithArguments: ID '('VarArg* ')'; 
VarArg: ID VarArgs*;
VarArgs:',' VarArg;
  
/**
 * ARITHMETICS
 */  
ARITHMETIC:'=' TERM ARITHMETICS* ;
  
 //ex: ='L' or =make_new_food(snake)
 TERM: INT|CHAR|ID|'\''CHAR'\''|VarWithArguments; 
 ARITHMETICS: UnaryOP TERM ;
  
/*
 * 
 * CONDITIONALS
 * 
 */
 
 BoolOP:'<'|'>'|'=='|'<='|'>='| '!='| '||' | '&&';
 ConditionalDecl: 'while' | 'if';

 CONDITIONALS: ConditionalDecl ConditionalParam ConditionalBlock;

 ConditionalParam: '(' ConditionalExpressions ')';
 
 ConditionalExpressions:NEGATION|LOGICEXPRESSION;
 
 NEGATION: '!' LogicTerm ;

 LOGICEXPRESSION: LogicTerm  LogicTerms+;

//The logic can be done with the name of a variable (array and or its calls) or an int, for example in u==2
LogicTerm:LogicVar|INT;
//ADDING WS BECAUSE IT IS READABLE THIS WAY
LogicTerms: WS BoolOP WS LogicTerm;
LogicVar:ID ARR? CALL?;

CALL:'.' ID;

//Inside a conditional block, variables are not defined by its type. 
ConditionalBlock:'{' ConContent* CONDITIONALS*  '}' ;
 
ConContent: GeneralBlockPattern | ConVar;
	
ConVar: ID '(' ArgOrEmpty* ')' ';';
ArgOrEmpty:ArgWithCall ArgWithCalls*;
ArgWithCall:ID CALL?;
ArgWithCalls:',' ArgWithCall;

/*
 * RETURN 
 * 
 */	
RETURN:'return' WS TERM ';' '}';
  
  