package com.exceptionhandling;

	import java.util.Scanner;

	public class ThrowThrowsExample {

	    // This method declares it might throw an Exception
	    static void checkAge(int age) throws ArithmeticException {
	        if (age < 18) {
	            // Manually throw an exception
	            throw new ArithmeticException("Access denied - You must be at least 18 years old.");
	        } else {
	            System.out.println("Access granted - You are old enough!");
	        }
	    }

	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        System.out.print("Enter your age: ");
	        int userAge = scanner.nextInt();

	        try {
	            checkAge(userAge);
	        } catch (ArithmeticException e) {
	            System.out.println("Exception caught: " + e.getMessage());
	        } finally {
	            System.out.println("Program completed.");
	            scanner.close();
	        }
	    }
	
}
