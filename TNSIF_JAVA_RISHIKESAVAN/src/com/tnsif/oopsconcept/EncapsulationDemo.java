package com.tnsif.oopsconcept;

public class EncapsulationDemo {

	//IPL Team
	
	//CSK
	
	//data members or variables
	String name;
	int age;
	int jersyNo;
	
	
	//getters and setters
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name; //this refers to the current object
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getJersyNo() {
		return jersyNo;
	}

	public void setJersyNo(int jersyNo) {
		this.jersyNo = jersyNo;
	}

	
	//toString method
	@Override
	public String toString() {
		return "EncapsulationDemo [name=" + name + ", age=" + age + ", jersyNo=" + jersyNo + "]";
	}
	
	
	
		
}
