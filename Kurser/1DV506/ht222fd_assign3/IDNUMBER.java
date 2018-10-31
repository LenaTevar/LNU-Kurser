package stuff;

import java.util.Arrays;
import java.util.Scanner;

public class IDNUMBER {
	public static void main(String[] args) {
		boolean itsOn = true;
		String persNumm;


		Scanner sc = new Scanner (System.in);
		System.out.println("============================\n| Welcome to the ID checker|\n============================");
		System.out.print("Please add your swedish ID:");
		persNumm = sc.nextLine();

		while (itsOn){


			System.out.println("\n\n===================\n| ID checker Menu |\n===================");
			System.out.println("1 - Check your ID first part.");
			System.out.println("1 - Check your ID second part.");
			System.out.println("3 - Check if your ID is female.");
			System.out.println("4 - Check if your ID is male.");
			System.out.println("5 - Check if your ID is equal to another ID.");
			System.out.println("6 - Check if your ID is correct.");
			System.out.println("7 - EXIT");

			System.out.print("Write a number to access a method: ");
			int answer = sc.nextInt();

			switch (answer) {
			case 1:
				System.out.println("First Part:" + getFirstPart(persNumm));
				break;
			case 2:
				System.out.println("Second Part:" + getSecondPart(persNumm));
				break;
			case 3:
				boolean femaleSex = isFemaleNumber(persNumm);
				if (femaleSex)
					System.out.println("Your ID is a female number.");
				else
					System.out.println("Your ID is not a female number.");
//				printBool(femaleSex);
				break;
			case 4:
				boolean maleSex = isMaleNumber(persNumm);
				if (maleSex)
					System.out.println("Your ID is a male number.");
				else
					System.out.println("Your ID is not a male number.");
//				printBool(maleSex);
				break;
			case 5:
				System.out.print("Please, add a new ID: ");
				Scanner inputSc = new Scanner (System.in);
				String secondperson = inputSc.nextLine();
				
				boolean same = areEqual(persNumm, secondperson);
				if (same)
					System.out.println("Those ID are equal.");
				else
					System.out.println("Those ID are different.");
//				printBool(same);
				/*ASK: Why I cannot close this scanner
				 * */
				//inputSc.close();
				break;
			case 6:
				answerCheck(persNumm);
				break;
			case 7:
				System.out.println("Thanks for using ID checker.");
				itsOn=false;
				break;
			default:
				break;
			
			}//END Switch

		}//END WHILE
		
		sc.close();
	}//END MAIN


	// 4 VG Checking
	public static boolean isCorrectCheck(String  input) {
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
	public static boolean insideArray(int[] arr, int x){
		for (int months : arr){
			if (x == months)
				return true;

		}
		return false;

	}
	public static boolean isCorrectDate(String input){
		int[] MONTHS31 = {1, 3, 5, 7, 8, 10, 12};
		int[] MONTHS30 = {4, 6, 9, 11};

		String year = input.substring(0,2);
//		System.out.println(year);
		int yearI = Integer.parseInt(year);

		String month = input.substring(2,4);
//		System.out.println(month);
		int monthI = Integer.parseInt(month);

		String day = input.substring(4);
//		System.out.println(day);
		int dayI = Integer.parseInt(day);

		//LEAP YEAR
		if (monthI==02){
			if ( (yearI %4 == 0 && yearI % 100!= 0) || yearI % 400 == 0){
				if (dayI <= 29){
//					System.out.println("TRUE1: MONTH= " + month + " Day= " + day);
					return true;}
			}
			else if (dayI<=28){
//				System.out.println("TRUE2: MONTH= " + month + " Day= " + day);
				return true;}

		}//END FEBRARY

		else if (insideArray(MONTHS31,monthI) ){
			if (dayI<=31){
//				System.out.println("TRUE3: MONTH= " + month + " Day= " + day);
				return true;
			}
		}

		else if (insideArray(MONTHS30,monthI)){
			if (dayI<=30){
//				System.out.println("TRUE4: MONTH= " + month + " Day= " + day);
				return true;
			}
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
		else if (!isCorrectDate(input)){
			System.out.println("The date is not correct");
		}
		
	}
	
	// 3 Are Equal
	private static boolean areEqual(String input1, String input2) {
		if (input1.equals(input2)){
			return true;
		}
		return false;
	}

	//Little helper
	private static void printBool(boolean a){

		if (a == true)
			System.out.println("TRUE");
		else
			System.out.println("FALSE");
	}

	//2 Female/male
	private static boolean isFemaleNumber(String input) {

		char temp = input.charAt(7);
		int charValue = Character.getNumericValue(temp);
		//		String temp = input.substring(7,10);
		//		int threeNumbers = Integer.parseInt(temp);

		if (charValue % 2 == 0)
			return true;
		else
			return false; //Why not using this bool to say that is male???
	}
	private static boolean isMaleNumber(String input) {
		String temp = input.substring(7,10);
		int threeNumbers = Integer.parseInt(temp);

		if (threeNumbers % 2 == 0)
			return false;
		else
			return true;
	}

	//1	get first/second part
	private static String getSecondPart(String input) {
		String secondPart = input.substring(7);
		return secondPart;
	}
	private static String getFirstPart(String input){
		String firstPart = input.substring(0, 6);
		return firstPart;
	}


}