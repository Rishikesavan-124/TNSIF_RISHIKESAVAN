package com.lambda;

	import java.util.Scanner;

	@FunctionalInterface
	interface Factorial {
	    int calculate(int n);
	}

	public class Find_Factorial_Lambda {
	    public static void main(String[] args) {
	        Scanner scan = new Scanner(System.in);

	        System.out.println("Enter a number to find factorial:");
	        int num = scan.nextInt();

	        // Lambda expression to calculate factorial
	        Factorial fact = (n) -> {
	            int f = 1;
	            for (int i = 1; i <= n; i++) {
	                f *= i;
	            }
	            return f;
	        };

	        System.out.println("Factorial of " + num + " is " + fact.calculate(num));
	    }
	}


