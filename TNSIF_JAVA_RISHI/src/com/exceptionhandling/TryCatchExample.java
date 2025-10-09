//program to demonstrate try catch block
package com.exceptionhandling;

public class TryCatchExample {
	static int performDivision(int x, int y) {
		System.out.println("I am in performDivision method");
		int z = 0;
		z = x / y;
		return z;
	}

	static float performDivision(float a, float b) {
		return a / b;
	}
}