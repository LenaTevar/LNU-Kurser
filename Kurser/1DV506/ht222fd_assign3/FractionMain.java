package ht222fd_assign3;

import java.util.Scanner;

public class FractionMain {

	public static void main(String[] args) {

		System.out.println("Welcome to Fractions. Please add two fractions.\n");
		Fraction firstMain = newFraction();
		System.out.println("First fraction: " + firstMain.toString());
		System.out.println("isNegative - " + firstMain.isNegative());

		System.out.println("Add your second fraction.");		
		Fraction secondMain = newFraction();
		System.out.println("Second fraction: " +  secondMain.toString());
		System.out.println("isNegative - " + secondMain.isNegative());

		Fraction addfrac = firstMain.add(secondMain);
		System.out.println("Adding - " + addfrac);

		Fraction subfrac = firstMain.substract(secondMain);
		System.out.println("sub - " + subfrac.toString());


		Fraction multifrac = firstMain.Multiply(secondMain);
		System.out.println("multiply - " + multifrac.toString());

		Fraction divifrac = firstMain.divide(secondMain);
		System.out.println("Division - " + divifrac.toString());
		divifrac.reduce();
		System.out.println("Division Reduced - " + divifrac.toString());

		System.out.println("First Fraction IsEqual to Second? - " + firstMain.isEqualTo(secondMain));
	}

	/*
	 * */
	private static boolean ParseString (String userInput){
		try {
			Integer.parseInt(userInput);
			return true;
		}
		catch (NumberFormatException e){
			return false;
		}

	}
	private static Fraction newFraction (){
		/*newFraction:
		 * If I try to close scanner, it doesn't works.
		 * And I don't like that try/catch in Java is so 
		 * complicated!!! SO I have to encapsulate with if elses
		 * */
		Scanner sc = new Scanner (System.in);
		int userNumerator = 0;
		int userDenominator = 0;

		System.out.println("Add numerator: ");

		String userStr = sc.nextLine();

		if (ParseString(userStr)){
			userNumerator = Integer.parseInt(userStr);
		}

		else if (!ParseString(userStr)){
			System.out.println("Sorry, something went wrong. Please, try again.");
			System.exit(0);
		}

		System.out.println("Add denominator: ");
		userStr = sc.nextLine();

		if (ParseString(userStr)){
			userDenominator = Integer.parseInt(userStr);
		}

		else if (!ParseString(userStr)){
			System.out.println("Sorry, something went wrong. Please, try again.");
			System.exit(0);
		}
		//		sc.close();
		Fraction fractionMain = new Fraction (userNumerator, userDenominator);

		return fractionMain;
	}


}
