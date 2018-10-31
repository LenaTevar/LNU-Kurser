package ht222fd_assign3;

import java.util.Scanner;
/*Class Play123Main:
 * Not commenting here because well..
 * I already said a lot in PlayCards.java ;)
 * */

public class Play123Main {

	public static void main(String[] args) {
		boolean quit = true;
		Scanner scan = new Scanner(System.in);
		

		Deck myDeck = new Deck();
		do {
			int win = 0;
			int lose = 0;
			
			System.out.println("\n=========================\n|| Patience Statistics ||\n=========================");
			System.out.println("1: Play 100.");
			System.out.println("2: Play 1000.");
			System.out.println("Q: Quit ");
			System.out.print("Select: ");

			String choice = scan.next().toUpperCase();
			
			switch(choice){
			case "1":
				System.out.println("\n\nPlaying Patience 100 times.");
				for (int i = 0; i < 100; i++){
					boolean game = myDeck.Patience();
					if (game)
						win++;
					else if (!game)
						lose++;					
				}
				System.out.println("Win: " + win);
				System.out.println("Lose: " + lose);
				System.out.println("The % of wining was: " + win + "%");
				break;	
				
			case "2":
				System.out.println("\n\nPlaying Patience 1000 times.");
				for (int i = 0; i < 1000; i++){
					boolean game = myDeck.Patience();
					if (game)
						win++;
					else if (!game)
						lose++;					
				}
				System.out.println("Win: " + win);
				System.out.println("Lose: " + lose);
				float percent = (float) win*100/1000;
				System.out.print("the % of wining was " + percent + ".");
				break;
				
			case "Q":
				System.out.println("\n\nThanks for using Patience Statistics ");
				quit = false;
				break;
				
			default:
				System.out.println("\n\nUps! Something went wrong. Try again.");
				break;
			}

		} while (quit);

		scan.close();
	}
	
	
}//main



