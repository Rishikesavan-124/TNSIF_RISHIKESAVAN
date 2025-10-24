package com.lambda;

public class dummy {
	package dumme;

	  class Find_Factorial4{
	public static void main(String args[]){
	 Scanner scan = new Scanner(System.in);

	System.out.println("Enter a number for find factorial");
	int num=scan.nextInt();
	factorial(num);
	}
	 static void factorial (int num)
	{
	int i,f=1;
	for(i=1; i<=num; 1++) {
	f=f*i;
	}
	System.out.print("Factorial of the "+num+"i= "+f);

}
