   package com.tnsif.nonaccessmodifiers;

public class StaticDemo {
	
	//static variable
	
	static int count;	
	
	//static block
	static {
		count = 20;
		System.out.println("shows the static count assigned: " + count);
	}
	
	//static method
	static void show() {
		System.out.println("Method runs in static with count of: " + count);
	}
	

	public static void main(String[] args) {
	
		System.out.println("static in main method: "+count);
		
		show();//calling the method
		
		

	}

}
