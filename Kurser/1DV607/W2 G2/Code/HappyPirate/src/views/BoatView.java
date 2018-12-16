package views;

import java.util.Scanner;

import models.Boat;
import models.BoatType;

public class BoatView extends ViewInput {
	private Scanner sc = new Scanner (System.in);
	
	public BoatView() {}
	
	public boatOptions doBoatMenu() {
		
		String sb = "==== Boat Manager ====\r\n" +
				"0. Exit\r\n" +
				"1. Edit Boat\r\n" +
				"2. Delete Boat\r\n" +
				"Select: ";
		System.out.print(sb);
		return inputBoatOptions();
	}

	public Boat doAddBoat() {
		System.out.print("==== Add Boat ====\n");	
		Boat boat = doABoat();
		return boat;
	}
	
	public Boat doEditBoat() {
		System.out.print("==== Edit Boat ====\n");	
		Boat boat = doABoat();
		return boat;
	}
	
	/*General method for creating a boat
	 * used in add and edit boats.*/
	public Boat doABoat() {
		System.out.print("Name:");
		String name = sc.nextLine();
		System.out.print("ID: ");
		String id = sc.nextLine();
		System.out.print("Type >> (1) Sailboat - (2) Motorboat - (3) Katamaran - (4) Other: ");
		BoatType type = getTypeFromInput();
		System.out.print("Length: ");
		double length = getLength(sc);
		sc.nextLine();
		return new Boat(type, length, name, id);
	}	
	
	public void printBoat(Boat aBoat) {
		System.out.printf("\t\tBoat Name: %s \n", aBoat.getName());
		System.out.printf("\t\tBoat Id: %s \n", aBoat.getMMSI());
		System.out.printf("\t\tBoat Type: %s \n", aBoat.getType());
		System.out.printf("\t\tBoat Length: %s \n", aBoat.getLength());		
	}
	
	/*
	 * Loops type of boat until user picks a
	 * correct one.
	 * */
	public BoatType getTypeFromInput() {
		BoatType value = BoatType.OTHER; 
		boolean loop = true;
		do {

			int option = this.getUserInput(sc);
			if (option == 1) {
				loop = false;
				value =  BoatType.SAILBOAT;
			}
				
			else if (option == 2) {
				loop = false;
				value = BoatType.MOTORBOAT;
			} 
				
			else if (option == 3) {
				loop = false;
				value =  BoatType.KATAMARAN;
			}
			else if(option == 4) {
				loop = false;
				value =  BoatType.OTHER;
				}
			else {
				System.out.print("Please enter a boat type\r" + 
								"Type >> "+ 
								"(1) Sailboat - " + 
								"(2) Motorboat - " + 
								"(3) Katamaran - " + 
								"(4) Other: ");
			}
		} while (loop);
		return value;
		
	}
	/*Loop until user inputs a correct double.*/
	private double getLength(Scanner sc) {
		boolean loop = true;
		double d = 0;
		
		do {
			if(sc.hasNextDouble()) {
				d = sc.nextDouble();
				loop = false;
			} else {
				System.out.println("Please, write a valid length:");
				sc.nextLine();
			} 
		
		} while (loop);
		
		return d;
	}

	public enum boatOptions{EXIT, ADD, EDIT, DELETE, ERROR}
	
	public boatOptions inputBoatOptions() {
		int answer = getUserInput(sc);
		
		if (answer == 0)
			return boatOptions.EXIT;
		else if (answer == 1)
			return boatOptions.EDIT;
		else if (answer == 2)
			return boatOptions.DELETE;
		else {
			return boatOptions.ERROR;
		}
		
	}
	
}
