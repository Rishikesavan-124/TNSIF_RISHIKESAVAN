package com.tnsif.oopsconcept;

//Single Inheritance

class Animal{
	String name;
	
	//Constructor
	
	Animal(String name){
		this.name = name;
	}
	
	void display() {
		System.out.println("Animal Name: "+name);
	}
}

class Dog extends Animal{

	String breed;
	
	Dog(String name , String breed){
		super(name);
		this.breed = breed;
	}
	
	void showDetails() {
		display();
		System.out.println("Dog Breed: "+breed);
	}
	
}


//multilevel inheritance

class grandparent{
	void gp() {
		System.out.println("Grand parent class");
	}
}

class Parent extends grandparent {
	void p() {
		System.out.println("Parent class");
	}
}

class Child extends Parent{
	void child() {
		System.out.println("Child class");
	}
}


//multiple inheritance

class Parent1{
	void pt1() {
		System.out.println("parent 1");
	}
}

class Parent2{
	void pt2() {
		System.out.println("parent 2");
	}
}


//hierarichcial inheritance
class Fruit{
	void show() {
		System.out.println("I like to eat fruits");
	}
}

class Apple extends Fruit{
	void AppleDemo() {
		System.out.println("I like to eat apple");
	}
}

class Grapes extends Fruit{
	void GrapesDemo() {
		System.out.println("I like to eat grapes");
	}
}


/*
 * class Child1 extends Parent1, Parent2{ void child1() {
 * System.out.println("Child 1"); } }
 */



public class InheritanceDemo {

	public static void main(String[] args) {
		
		Dog d = new Dog("John","Seberian Husky");
		d.showDetails();
		
		Child c = new Child();
		c.child();
		c.p();
		c.gp();
		
		
		Apple a = new Apple();
		a.AppleDemo();
		a.show();

		Grapes g = new Grapes();
		g.GrapesDemo();
		g.show();





		
	
	}

}
