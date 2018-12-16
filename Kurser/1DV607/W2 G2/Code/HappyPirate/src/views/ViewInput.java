package views;

import java.util.Scanner;
/*
 * abstract class ViewInput
 * Used to remove duplicated code from ConsoleView, MemberView and BoatView.
 * */
public abstract class ViewInput {
	
	public int getUserInput(Scanner sc) {
		int input = -1;
		try {
			input =  sc.nextInt();
			sc.nextLine();
			
		}catch (Exception e) {	
			sc.nextLine();
		}
		
		return input;
	}
}
