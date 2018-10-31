package ht222fd_assign3;


public class MultiDisplayMain {

	public static void main(String[] args) {
		/*MultiDislayMain:
		 * Not that much to comment here, it's pretty obvious.*/
		
		MultiDisplay md = new MultiDisplay ();		
		md.setDisplayMessage("Hello World!");
		md.setDisplayCount (3);
		md.display();		
		md.display("Goodbye cruel world!", 2);		
		System.out.println("Current Message: " + md.getDisplayMessage());
		
		
	}

}
