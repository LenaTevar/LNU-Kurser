package ht222fd_assign3;

public class PointMain {
	/*PointMain
	 * Is it okay to add a little bit of code here?
	 * Just a couple of else if to check when it's false
	 * */

	public static void main(String[] args) {
		Point p1 = new Point();
		Point p2 = new Point(3,4);
		
		System.out.println(p1.toString());
		System.out.println(p2.toString());
		
		if (p1.isEqual(p2))
			System.out.println("The two points are equal.");
		else if (!p1.isEqual(p2))
			System.out.println("The two points are NOT equal.");
		
		double dist = p1.distanceTo(p2);
		System.out.println("Point Distance:  " + dist);
		
		p2.move(5, -2);
		p1.moveTo(8, 2);
		
		if (p1.isEqual(p2))
			System.out.println("The two points are equal.");
		else if (!p1.isEqual(p2))
			System.out.println("The two points are NOT equal.");
		
	}

}
