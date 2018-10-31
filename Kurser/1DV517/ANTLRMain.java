
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
//things

public class HelloRunner {
/*
 * + "while(u!=1){u=1;}"
 * 
 * */
	public static void main(String[] args) throws Exception {
		
		String testStruct = "struct a { int a[2]; struct b b ; char c; } ;";
		String testFunc = "int a(int a,int b){ int a=3+3+a; if(!3) {} return a}";
		String test = "struct location{ int x; int y;};"
				+ "int main (location snake[], location food){int snake_length=1;"
				+ "location snake[10];"
				+ "location food;"
				+ "int u=0;"
				+ "char d='L';"
				+ "food=make_new_food(snake);"
				+ "init_game(snake);"
				+ "int u=abc(abc);"
				+ "u=update(make,food,d,snake_length);"
				+ "while(u!=1){u=1;}"
				
				+ "return 0;}";
		//parseString(testFunc);
		//parseString(testStruct);
		parseString(test);
	}
	
	static void parseString(String inputSTR) {
		ANTLRInputStream input = new ANTLRInputStream(inputSTR);
		
		
		
		HelloLexer lexer = new HelloLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		HelloParser parser = new HelloParser(tokens);
		ParseTree tree = parser.p(); //Starts running rule parser.RULE();
		System.out.println(tree.toStringTree(parser));
		
	}

}
