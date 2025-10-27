package com.tnsif.nonaccessmodifiers;

final class FinalDemo {
	
	final int Var = 100;
	
	final void display() {
		System.out.println("show the value of max: "+Max);
	}

	public static void main(String[] args) {
		FinalDemo fd = new FinalDemo();
		fd.display();
		fd.Var = 100;

	}

}

class Child extends FinalDemo{
	void display() {
		System.out.println("show the value of max: "+Max);
	}
}
