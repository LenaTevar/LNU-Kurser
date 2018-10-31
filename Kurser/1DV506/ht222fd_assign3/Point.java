package ht222fd_assign3;

public class Point {
	private int x;
	private int y;

	//Constructor
	public Point (int x, int y){
		this.x = x;
		this.y= y;
	}

	public Point() {
		x = 0;
		y = 0;
	}


	public String toString(){
		String str = "(" + x + "," + y + ")";
		return str;
	}

	public boolean isEqual(Point p){
		if (this.x == p.x && this.y== p.y)
			return true;
		return false;
	}

	public double distanceTo (Point p){
		double distance = Math.sqrt(Math.pow(this.x - p.x, 2)
				+ Math.pow(this.y - p.y, 2));
		return distance;
	}

	public void move(int i, int j) {
		this.x += i;
		this.y += j;
	}
	public void moveTo (int i, int j){
		this.x = i;
		this.y= j;
	}



}
