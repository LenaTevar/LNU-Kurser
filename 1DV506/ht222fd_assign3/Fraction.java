package ht222fd_assign3;

public class Fraction {
	private int numerator;
	private int denominator;
	/*Constructors
	 * */
	public Fraction (){
		numerator = 0;
		denominator = 1;
		/*(07/12 - 10:00) 
		 * I'm thinking about a helper method to check if
		 * the denominator is 0. 
		 * */
	}
	public Fraction (int num, int den){
		/*Fraction:
		 * Checks if the denominator is equal to 0,
		 * if both are negative (so it becomes positive)
		 * or else.
		 * */
		if (den == 0){
			System.out.println("The denominator has to be bigger than zero.\n Please try again");
			System.exit(0);
		}
		else if (num < 0 && den < 0){
			numerator = Math.abs(num);
			denominator = Math.abs(den);
			
		}
		else {
			numerator = num;
			denominator = den;
		}
		
	}
	
	
	/*getter 'n setters
	 * */
	public void setNumerator(int num){
		numerator = num;
	}
	public int getNumerator(){
		return numerator;}
	
	public void setDenominator(int den){
		denominator = den;
	}
	public int getDenominator(){
		return denominator;}
	/*
	 * */
	public boolean isNegative(){
		if (numerator < 0 || denominator < 0)
			return true;
		else if (numerator < 0 && denominator < 0)
			return false;
		return false;
	}
	
	public Fraction substract(Fraction input){
		/*A/B - C/D = AD-CB/BD */
		Fraction sub = new Fraction ();
		sub.numerator = (this.numerator*input.denominator - input.numerator*this.denominator);
		sub.denominator = this.denominator*input.denominator;
		return sub;
		
	}
	public Fraction add(Fraction input){
		/*A/B + C/D = AD+CB/BD */
		Fraction add = new Fraction ();
		add.numerator = (this.numerator*input.denominator + input.numerator*this.denominator);
		add.denominator = this.denominator*input.denominator;
		return add;
	}
	public Fraction Multiply(Fraction input){
		Fraction multi= new Fraction ();
		multi.numerator = this.numerator * input.numerator;
		multi.denominator = this.denominator * input.denominator;
		return multi;
	}
	public Fraction divide (Fraction input){
		/*  A/b / C/D = A*D/B*C   */
		Fraction divi = new Fraction ();
		divi.numerator = this.numerator*input.denominator;
		divi.denominator = this.denominator*input.numerator;
		return divi;
	}
	public boolean isEqualTo (Fraction input){
		if (this.numerator == input.numerator && this.denominator == input.denominator)
			return true;
		return false;
		
	}
	public String toString (){
		String str = "("+numerator+"/"+denominator+")";
		return str;
	}
	
	/*EXTRA
	 * */
	
	private int gcd(){
		int a = this.numerator;
		int b = this.denominator;
		int temp;
		
		while (b!=0){
			temp = b;
			b = (a % b);
			a = temp;
		}
		System.out.println("GCD = " + a);
		return a;		
	}
	
	public void reduce (){
		int mygcd = this.gcd();
		this.numerator /= mygcd;
		this.denominator/= mygcd;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
