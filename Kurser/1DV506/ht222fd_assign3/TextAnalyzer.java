package ht222fd_assign3;

public class TextAnalyzer {
	private String text;
	private int digitCounter;
	private int caseCounter;
	private int spaceCounter;
	private char space =' ';
	//Constructor
	public TextAnalyzer (String text){
		this.text = text;
	}

	public int charCount(){
		/*Is it cheating if I use
		 * length as number of chars? 
		 * I guess no ;)
		 * */
		int chars = this.text.length();
		return chars;
	}
	public int upperCaseCount(){
		
		for (int i = 0; i < this.text.length(); i++){
			if (Character.isUpperCase(this.text.charAt(i)))
				caseCounter++;
		}
		return caseCounter;
	}
	public int whitespaceCount(){
		for (int i = 0; i < this.text.length(); i++) {
			if (this.text.charAt(i)== space)
				spaceCounter++;
		}
		return spaceCounter;
	}
	public int digitCount(){
		for (int i = 0; i < this.text.length(); i++) {
			if (Character.isDigit(this.text.charAt(i)))
				digitCounter++;
		}
		return digitCounter;
	}

	public boolean containsChar(char x){
		for (int i = 0; i < this.text.length(); i++) {
			if (this.text.charAt(i) == x)
				return true;
		}
		return false;
	}
	public boolean containsString(String input){
		
		if (this.text.contains(input))
			return true;
		return false;
	}


}
