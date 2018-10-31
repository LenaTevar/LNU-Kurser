package ht222fd_assign3;

import java.util.Scanner;

public class TextAnalizerMain {

	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner (System.in);
		System.out.print("Write something: ");
		String text = sc.nextLine();
		System.out.print("Write a substring: ");
		String substring = sc.nextLine();
		
		
		
		TextAnalyzer ta = new TextAnalyzer(text);

		System.out.println("Char Count: "+ ta.charCount());
		System.out.println("Upper Case Count: "+ ta.upperCaseCount());
		System.out.println("Whitespace Count: "+ ta.whitespaceCount());
		System.out.println("Digit Count "+ ta.digitCount());

		if (ta.containsChar('x'))
			System.out.println("The text contains char \'x\'");
		else if (!ta.containsChar('x'))
			System.out.println("The text contains char \'x\'");

		if (ta.containsString(substring))
			System.out.println("The text contains substring \""+substring+"\"");
		else if (!ta.containsString(substring))
			System.out.println("The text do NOT contains substring \""+substring+"\"");
		
		sc.close();
	}

}
