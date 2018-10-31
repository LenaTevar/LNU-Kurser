import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
/*
 * Student: ht222fd
 * This is the main class used with the parser. 
 * Strings were slightly modified because handling with whitespace was taking
 * too much time and the point is to learn about grammar and not about white spaces.
 *  I tested different times with different strings, all of them are the 
 *  one written in the assignmnet. The String called ALL is no more no less that
 *  all the ones before concatenated and, as its names say, it is the whole string 
 *  from the assignment.
 * */
public class MainParser {
	public static void main(String[] args) {
		
		String Test = "struct location{int x;int y;};";
				
		//ParseString(Test, "STRUCT");
		
		String Test2 = "int update(location snake[],location food,char direction,int snake_length){" 
				+ "int i=0;move_snake(snake,direction);"
					+ "while(i < snake_length){"
						+ "if(snake[i].x == food.x && snake[i].y == food.y){add_snake_part(snake.direction);}}"
				+ "return 0;}"; 
		
		//ParseString(Test2, "TEST2");
		String Test3="int main(){int snake_length=1;location snake[10];location food;int u=0;char d='L';init_game(snake);"+//99aprox
				"while(u != 1){d=handle_input();u=updte(snake,rood,d,snake_length);if(u == 2){food=make_new_food(snake);snake_length=snake_length+1;}if(snake_length == 10){u=1;}}" +
				
				"return 0;}";
				
		//ParseString(Test3,"TEST 3");
		
		
		String All=Test+Test2+Test3;
		
		ParseString(All, "All the strings together");
	}
	
	
	public static void ParseString(String input, String text) {
		
		ANTLRInputStream ANTLRinput = new ANTLRInputStream( input);

		HelloLexer lexer = new HelloLexer(ANTLRinput);

		CommonTokenStream tokens = new CommonTokenStream(lexer);

		HelloParser parser = new HelloParser(tokens);
		ParseTree tree = parser.r(); // begin parsing at rule 'r'
		System.out.println(text);
		System.out.println(tree.toStringTree(parser)); // print LISP-style tree+
	}

}

