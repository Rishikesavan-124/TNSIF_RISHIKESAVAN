package com.interfaces;

public class FunctionalDemo {

	public static void main(String[] args) {
	
		//Lambda Expression
		GreetingDemo gd = () -> 
		System.out.println("Hello Everyone, Welcome to the Java Session");
		
		gd.greet();
		
		

	}

}
