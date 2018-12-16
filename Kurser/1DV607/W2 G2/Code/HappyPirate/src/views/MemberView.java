package views;



import java.util.Scanner;

import models.Member;

public class MemberView extends ViewInput {
	private Scanner sc = new Scanner (System.in);
	public BoatView boatView = new BoatView();
	
	public MemberView() {}

	

	public Member addMember() {
		System.out.print("==== Add Member ====\r\n");	
		Member member = doAMember();
		return member;
			
	}
	
	public Member editMember() {
		System.out.print("==== Edit Member ====\r\n");	
		return doAMember();		
	}
	
	private Member doAMember() {
		System.out.print("Name: ");
		String name = sc.nextLine();
		
		System.out.print("Surname: ");
		String surname = sc.nextLine();
		
		System.out.print("National ID: ");
		String personId = sc.nextLine();
		
		System.out.print("Phone: ");
		String phone = sc.nextLine();
		
		return new Member(name, surname, personId, phone);	
	}
	
	public memberOptions doManageMember() {
		String sb = "==== Member Manager ====\r\n" +
				"0. Exit\r\n" +
				"1. Edit Member\r\n" +
				"2. Delete Member\r\n" +
				"3. Add Boat\r\n" +
				"4. Select Boat\r\n" +
				"Select: ";
		System.out.print(sb);
		return inputMemberOptions(); 
	}
	
	public void printMember(Member aMember) {
		this.printLite(aMember);
		
		
		
		if (!aMember.boatsIsEmpty()) {
			System.out.printf("\t==== Boats ====\n");
			this.printAllBoatsOf(aMember);
		}
	}
	
	
	
	public void printLite(Member aMember) {
		System.out.printf("\r\n>> Member ID: %s \n", aMember.getMemberId());
		System.out.printf("\tName: %s %s\t", aMember.getFirstName(), aMember.getSurname());
		System.out.printf("\tPhone: %s \n", aMember.getPhone());
		System.out.printf("\tNational ID: %s \n", aMember.getPersonId());
		System.out.println("\tBoats: " + aMember.getMemberBoats().count() );
	}
	
	public String doSelectBoat(Member member) {
		String sb = "==== Select a Boat ====\r\n";
		System.out.println(sb);
		this.printAllBoatsOf(member);

		sb = "Please write a boat id: ";
		System.out.print(sb);
		return sc.nextLine();

	}
	
	public enum memberOptions{
		EXIT , EDIT , DELETE , ADD_BOAT, MANAGE_BOAT, ERROR
		
	}

	public void printAllBoatsOf(Member aMember) {
		aMember.getMemberBoats().forEach(Boat -> {
			boatView.printBoat(Boat);
		});
	}
		
		
	public memberOptions inputMemberOptions() {
		int answer = getUserInput(sc);
		System.out.println("input member options: "+answer);
		
		if (answer == 0)
			return memberOptions.EXIT;
		else if (answer == 1)
			return memberOptions.EDIT;
		else if (answer == 2)
			return memberOptions.DELETE;
		else if (answer == 3)
			return memberOptions.ADD_BOAT;
		else if (answer == 4)
			return memberOptions.MANAGE_BOAT;
		else {
			return memberOptions.ERROR;
		}
	}
}
