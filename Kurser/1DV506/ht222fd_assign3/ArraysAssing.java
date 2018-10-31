package ht222fd_assign3;
//import java.util.Arrays;

/* METHODS BELOW MAIN
 * Note: ALT + SHIFT + S
 * Why cannot we use the Arrays library? U.U
 * The library is still there because I used it to check stuff.
 * That is also the reason why this exercise is not called "Arrays"-
 * */


public class ArraysAssing {

	public static void main(String[] args) {
		int[] numbers = {9, 2, 3, 1};

		System.out.println("My First Array " + toString(numbers));
		//oh the irony


		//1.1
		System.out.println("Exercise 1.1 - sum: ");
		int suma = sum(numbers);
		System.out.println("First Array sum: " + suma);

		//1.2
		System.out.println("\nExercise 1.2 - toString:");
		System.out.println("First Array: " + toString(numbers));

		//1.3
		System.out.println("\nExercise 1.3 - addN:");
		int [] adding = addN(numbers, 5);
		System.out.println("New array: " + toString(adding));

		//1.4
		System.out.println("\nExercise 1.4 - reverse:");
		int [] reversing = reverse(numbers);
		System.out.println("New array: " + toString(reversing));

		//1.5
		System.out.println("\nExercise 1.5 - hasN = 7:");
		boolean theTruth = hasN(numbers, 7);
		printBool(theTruth);
		
		System.out.println("\nExercise 1.5 - hasN = 1:");
		boolean theTruth2 = hasN(numbers, 1);
		printBool(theTruth2);

		//1.6
		System.out.println("\nExercise 1.6 - replaceAll 2 <-> 4:");
		replaceAll(numbers, 2, 4);
		System.out.println("First Array: " + toString(numbers));

		//1.7
		System.out.println("\nExercise 1.7 - sort:");
		int [] sorted = sort(numbers);
		System.out.println("New array: " + toString(sorted));

		//1.8
		System.out.println("\nExercise 1.8 - has subsequence:");
		int [] moreNumbers = {3, 7, 9};
		System.out.println("Numbers: "+toString(numbers));
		System.out.println("More Numbers: "+toString(moreNumbers));
		boolean searchSubArr = hasSubsequence(numbers, moreNumbers);
		printBool(searchSubArr);

		int [] evenMoreNumbers = {3, 4, 9};
		System.out.println("\nNumbers: "+toString(numbers));
		System.out.println("Even more Numbers: "+toString(evenMoreNumbers));

		searchSubArr = hasSubsequence(numbers, evenMoreNumbers);
		printBool(searchSubArr);

	}//end main

	//And this one is just a small help ;)	
	private static void printBool(boolean a){
		if (a == true)
			System.out.println("TRUE");
		else
			System.out.println("FALSE");
	}

	//1.8
	private static boolean hasSubsequence(int[] arr, int[] arrTwo) {

		for (int i = 0; i < arr.length; i++) {
			if(arr[i] == arrTwo[0]){
				int arrTwoPos = 0;
				//position inside the arrTwo
				for (int j = i; j < arrTwo.length + i ; j++) {

					if(arr[j] == arrTwo[arrTwoPos]){
						arrTwoPos++;
						if (arrTwoPos == arrTwo.length){							
							return true;}
						/*this checks if we arrived to the end of arrTwo
						 * */
					}
					else
						break;
				}
			}//First if
		}//First for
		return false;
	}//end hasSubsequence
	//1.7	
	private static int[] sort(int[] arr) {
		/*int [] temp = arr;
		Arrays.sort(temp);
		return temp;
		This looks so easy...
		In C# we used the bubble sort before (If I remember how to do it...)
		 */
		int [] tempArr = arr;
		for (int i = 0; i < tempArr.length; i++) {
			for (int j = i + 1; j < tempArr.length; j++) {
				if (arr[i]>arr[j]){
					int temp;
					temp = arr [i];
					arr [i] = arr [j];
					arr [j] = temp;
				}//end if					
			}//end for j
		}//end for i
		return tempArr;
	}
	//1.6	
	private static void replaceAll(int [] arr, int old, int nw){
		for (int i = 0; i < arr.length; i++) {
			if (arr[i]==old)
				arr[i]=nw;
		}//end for loop		
	}//end replaceAll
	//1.5
	private static boolean hasN(int[] arr, int i) {
		for (int j = 0; j < arr.length; j++) {
			if (arr[j] == i)
				return true;
		}
		return false;
	}
	//1.4
	private static int[] reverse(int[] arr) {
		int[] temp = new int [arr.length];
		for (int i = 0; i < arr.length; i++) {
			temp[temp.length-1-i] = arr[i];
		}
		return temp;
	}
	//1.3
	private static int[] addN(int[] arr, int N) {
		/*		 
		int [] temp = Arrays.copyOf(arr, arr.length+1);
		temp[temp.length-1] = i;
		return temp;
		 */

		int [] temp = new int [arr.length];
		for (int i = 0; i < arr.length; i++) {
			temp[i] = arr[i]+N;
		}
		/*If we were using arr.length*2, I would use "arr.length-1" 
		 * as the place were to add N instead of tem.length. */
		return temp;

	}
	//1.2
	private static String toString(int[] arr) {
		/*Method toString:
		 * What it is a "Nice looking Array??" 
		 * I like this array with fancy lines.
		 * */
		String output = "";
		for (int i = 0; i < arr.length; i++) {
			if (i==0)
				output += arr[i];
			else
				output += " | " + arr[i];
		}//end for loop
		return output;
	}
	//1.1 
	private static int sum(int[] arr) {
		int add = 0;
		for (int element : arr) {
			add = add + element;
		}// end  for loop
		return add;
	}//end 1.1

}//end class

