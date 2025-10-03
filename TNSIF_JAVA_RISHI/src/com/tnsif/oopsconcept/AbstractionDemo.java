package com.tnsif.oopsconcept;

abstract class Shape{
	abstract void draw(); 
}

class Circle extends Shape{

	void draw() {
		System.out.println("Drawing Circle");
	}
}
public class AbstractionDemo {

	public static void main(String[] args) {
		
		Shape s = new Circle();
		s.draw();		
	}
}
