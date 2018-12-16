package views;


import java.util.Scanner;
import java.util.stream.Stream;

import models.Member;

public class ConsoleView extends ViewInput {
	
	private Scanner sc = new Scanner (System.in);
	public MemberView memberView = new MemberView();

	public consoleOptions doMenu() {
		String sb ="\n==== Happy Pirate Manager ====\n" +
				"0. Exit\n" +
				"1. Add Member\n" +
				"2. Manage Member\n" +
				"3. Print List Verbose\n" +
				"4. Print List Lite\n" +
				"Select: ";
		drawBoat();
		System.out.print(sb);
		return inputOption();	
	}
	

	
	public int doSelectMember() {
		String sb ="\n==== Select a Member ==== \n" + "Please write a member id: ";
		System.out.print(sb);
		try {
			return sc.nextInt();
		} catch (Exception e) {
			return -1;
		}
	}
	
	/*==== Printing catalogue ====*/	
	public void printVerbose(Stream<Member> cata) {
		System.out.println( "\n==== Members Registered Verbose ====\n");
		cata.forEach(member -> memberView.printMember(member));
	}
	
	public void printLite(Stream<Member> cata) {
		System.out.println(System.lineSeparator() + 
				"==== Members Registered Lite ====" + 
				System.lineSeparator());
		cata.forEach(member -> memberView.printLite(member));
	}
	
	/*==== Messages ====*/
	public void catalogueIsEmpty() {
		System.out.println(">>> Catalogue empty. Please add memberes to acces this option.");		
	}
	
	public void error(String e) {
		String sb = ">>> Ups, something went wrong. " + e;
		System.out.println(sb);
		
	}
	
	
	
	public void bye() {
		System.out.println(">>> Thanks for using Happy Pirate!");
	}
	
	public void drawBoat() {
		String sb = "\n            __4___\n" + 
					"         _  \\ \\ \\ \\ \n" + 
					"        <'\\ /_/_/_/ \n" + 
					"         ((____!___/) \n" + 
					"          \\0\\0\\0\\0\\/ \n" +
					"~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~";
		System.out.println(sb);
	}
	
	/*==== Enum options ====*/
	public enum consoleOptions{
		EXIT, ADD_MEMBER, MANAGE_MEMBER, VERBOSE, LITE, ERROR;
	}
	
	public consoleOptions inputOption () {
		
		int answer = getUserInput(sc);
		
		if (answer == 0)
			return consoleOptions.EXIT;
		else if(answer == 1)
			return consoleOptions.ADD_MEMBER;
		else if (answer == 2)
			return consoleOptions.MANAGE_MEMBER;
		else  if (answer == 3)
			return consoleOptions.VERBOSE;
		else  if (answer == 4)
			return consoleOptions.LITE;
		else {
			return consoleOptions.ERROR;
		}
	}
	
}
