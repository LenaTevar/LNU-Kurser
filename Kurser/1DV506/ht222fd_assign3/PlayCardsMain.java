package ht222fd_assign3;

import java.util.Scanner;

public class PlayCardsMain {

	public static void main(String[] args) {
		boolean quit = true;
		Scanner scan = new Scanner(System.in);


		Deck myDeck = new Deck();
		do {
			System.out.println("=====================\n|| Play With Cards ||\n=====================");
			System.out.println("1: Shuffle");
			System.out.println("2: Deal a card");
			System.out.println("3: How many Cards are in the deck");
			System.out.println("4: Print your deck");
			System.out.println("Q: Quit ");
			System.out.print("Select: ");

			String choice = scan.next().toUpperCase();
			/*String choice:
			 * I used to encapsulate try/catch in C# so 
			 * I looked for the way to do it
			 * in java. But at the end I used
			 * String because any wrong letter will go to default directly,
			 * so I only needed to be sure of uppercase.
			 * */
			
			

			switch(choice){
			/*Switch:
			 * Why people don't like switches? 
			 * Am I missing something? 
			 * They look pretty awesome to make a Menu.*/
			case "1":
				myDeck.Shuffle();
				System.out.println("Your deck has been shuffled.");
				break;
			case "2": 
				Card dealedCardMain = myDeck.Deal();
				System.out.println(dealedCardMain.toString());
				break;
			case "3":
				System.out.println("Your deck has " + myDeck.HowMany() + " cards left.");
				break;
			case "4":
				System.out.println(myDeck.ArrToString());
				break;
			case "Q":
				System.out.println("Thanks for using Play With Cards");
				quit = false;
				break;
			default:
				System.out.println("Ups! Something went wrong. Try again.");
				break;
				}
			
			} while (quit);

		scan.close();
	}
	/*Method tryParse
	 * I used this until I though that String choice would
	 * make it easier.*/
	public static Integer tryParse(String text) {
		try {
			return Integer.parseInt(text);
		} 
		catch(NumberFormatException e){
			return 99; //it goes to default
		}
	}

}
