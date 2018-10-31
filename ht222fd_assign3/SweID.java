package ht222fd_assign3;
//Thanks alex for the char.getvalue thing!!!!'
/* 551314-0913
 * */

import java.util.Scanner;

public class SweID {
	public static void main(String[] args) {
		Scanner input = new Scanner (System.in);
		System.out.println("Add your ID: ");
		String idMain = input.nextLine();
		if (!checkUser(idMain)){
			System.exit(0);
		}
		
		
		//Exercise 1
		System.out.println("\nExercise 1\n");
		System.out.println("First Part:" + getFirstPart(idMain));
		System.out.println("Second Part:" + getSecondPart(idMain));
		
		//Exercise 2
		System.out.println("\nExercise 2\n");
		boolean maleSex = isMaleNumber(idMain);
		boolean femaleSex = isFemaleNumber(idMain);
		System.out.print("Checking if ID is a Female: ");
		printBool(femaleSex);
		System.out.print("Checking if ID is Male: ");
		printBool(maleSex);
		
		//Exercise 3
		System.out.println("\nExercise 3\n");
		System.out.println("Add a second ID: ");
		String idMainSecond = input.nextLine();
		System.out.print("Checking if Id's are equal: ");
		boolean same = areEqual(idMain, idMainSecond);
		printBool(same);
		
		//VG
		System.out.println("\nExercise VG\n");
		System.out.println("Checking if ID is correct: ");
		answerCheck(idMain);
		
		input.close();
	}

	// 4 VG Checking
	/*README VG Checking
	 *Methods used:
	 *- boolean isCorrectCheck: Checks if the last digit is correct
	 *- boolean isCorrectDate: Checks if the months and days are logical
	 *including leap years
	 *- isideArray: little helper ;)
	 *- answerCheck: group of if/elses using the two first methods
	 *and printing the answer.
	 *	 * */
	
	private static boolean isCorrectCheck(String  input) {
		//		character get numeric value

		char checkChar = input.charAt(10);
		int checkInt = Character.getNumericValue(checkChar);
		// The original checking number.

		String withoutCheck = getFirstPart(input) + getSecondPart(input);
		withoutCheck= withoutCheck.substring(0, 9);

		int [] tempArr = new int [9];
		int sum = 0;
		int myCheck; //My checking number after all the problem


		for (int i = 0; i < withoutCheck.length(); i++) {
			char tempChar = withoutCheck.charAt(i);
			int tempNum = Character.getNumericValue(tempChar);

			if (i%2==0){
				tempNum = tempNum*2;

				if (tempNum > 10){
					int superTemp = tempNum % 10;
					tempNum /= 10;
					tempNum += superTemp;
				}//IF TEMPNUM>10
			}//IF PAIR
			tempArr[i] = tempNum;
		}//FOR adding numbers to array

		for (int i = 0; i < tempArr.length; i++){
			sum += tempArr[i];
		}//the sum

		myCheck = 10 - (sum % 10);

		if ( myCheck == checkInt){
//			System.out.println("Your ID is correct.");
			return true;
		}
//		System.out.println("Your ID is incorrect.");
		return false;

	}//END METHOD
	private static boolean insideArray(int[] arr, int x){
		for (int months : arr){
			if (x == months)
				return true;

		}
		return false;

	}
	private static boolean isCorrectDate(String input){
		int[] MONTHS31 = {1, 3, 5, 7, 8, 10, 12};
		int[] MONTHS30 = {4, 6, 9, 11};

		String year = input.substring(0,2);
		int yearI = Integer.parseInt(year);

		String month = input.substring(2,4);
		int monthI = Integer.parseInt(month);

		String day = input.substring(4);
		int dayI = Integer.parseInt(day);

		//LEAP YEAR
		if (monthI==02){
			if ( (yearI %4 == 0 && yearI % 100!= 0) || yearI % 400 == 0){
				if (dayI <= 29){
					return true;}
			}
			else if (dayI<=28){
				return true;}
			else if (dayI>28) {
				System.out.println("The month " + monthI + " has not " + dayI + "day.");
			}

		}//END FEBRARY

		else if (insideArray(MONTHS31,monthI) ){
			if (dayI<=31){
				return true;
			}
			else if (dayI>31) {
				System.out.println("The month " + monthI + " has not " + dayI + "day.");
			}
		}

		else if (insideArray(MONTHS30,monthI)){
			if (dayI<=30){
				return true;
			}
			else if (dayI>30)
			{
				System.out.println("The month " + monthI + " has not " + dayI + "day.");
			}
		}
		else if (!insideArray(MONTHS31,monthI) && !insideArray(MONTHS30,monthI) ){
			System.out.println("The month is not correct.");
		}
		return false;
	}
	
	
	public static void answerCheck(String input){
		if (isCorrectCheck(input)){
			
			if (isCorrectDate(getFirstPart(input))){
				
				if (isFemaleNumber(input))
					System.out.println("It is a correct female number");
				else if (isMaleNumber(input))
					System.out.println("It is a correct male number");
			}//correctDate			
			
		}//correctCheck
		
		else if (!isCorrectCheck(input))
			System.out.println("The check number is not correct");
		}
		
	
	
	// 3 Are Equal
	public static boolean areEqual(String input1, String input2) {
		if (input1.equals(input2)){
			return true;
		}
		return false;
	}

	//Little helpers
	/*void printBool
	 * Like toString but with booleans
	 * */
	public static void printBool(boolean a){

		if (a == true)
			System.out.println("TRUE");
		else
			System.out.println("FALSE");
	}
		
	/*boolean checkUser:
	 * Trying to check if the user has actually written an ID
	 * or just random stuff.
	 * */
	public static boolean checkUser(String input){
		if (input.length() < 11 || input.length() > 11){
			System.out.println("Your ID has to be ######-####. Please try again. (1)");
			return false;
		}
		String checkUserFirst = getFirstPart(input);
		String checkUSerSecond = getSecondPart(input);
		
		for (int i = 0; i < checkUserFirst.length(); i++) {
			char c = checkUserFirst.charAt(i);					
			if (Character.isLetter(c)){
				System.out.println("Your ID has to be ######-####. Please try again. (2)");
				return false;
			}
		}
		for (int i = 0; i < checkUSerSecond.length(); i++) {
			char c = checkUSerSecond.charAt(i);
			if (Character.isLetter(c)){
				System.out.println("Your ID has to be ######-####. Please try again. (3)");
				return false;
			}
		}
		return true;
			
	}
	
	//2 Female/male
	public static boolean isFemaleNumber(String input) {

		char temp = input.charAt(7);
		int charValue = Character.getNumericValue(temp);
		//		String temp = input.substring(7,10);
		//		int threeNumbers = Integer.parseInt(temp);

		if (charValue % 2 == 0)
			return true;
		else
			return false; //Why not using this bool to say that is male???
	}
	public static boolean isMaleNumber(String input) {
		String temp = input.substring(7,10);
		int threeNumbers = Integer.parseInt(temp);

		if (threeNumbers % 2 == 0)
			return false;
		else
			return true;
	}

	//1	get first/second part
	public static String getSecondPart(String input) {
		String secondPart = input.substring(7);
		return secondPart;
	}
	public static String getFirstPart(String input){
		String firstPart = input.substring(0, 6);
		return firstPart;
	}


}