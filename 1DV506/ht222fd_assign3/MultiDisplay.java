package ht222fd_assign3;

public class MultiDisplay {
	private String message;
	private int counter;
	
	public void setDisplayMessage(String txt){
		this.message = txt;
	}
	public String getDisplayMessage(){
		return this.message;
	}
	
	public void setDisplayCount(int n){
		this.counter = n;
	}
	
	public void display(){
		for (int i = 0; i < counter; i++) {
			System.out.println(message);
		}
	}
	
	public void display (String txt, int n){
		this.message = txt;
		for (int i = 0; i < n; i++) {
			System.out.println(message);
		}
	}
	
}
