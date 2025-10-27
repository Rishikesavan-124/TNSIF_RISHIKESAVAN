//Program to demonstrate calling functional interface using old way

package com.tnsif.lambdaexpression;

//1. Defining Implementable class
class MyCubeImpl implements MyCube
{
	@Override
	public int getCube(int no) {
		return no*no*no;
	}
}

public class UsingOldWay {
	public static void main(String[] args) {
		//1. Using object of implementable class
		MyCube obj=new MyCubeImpl();
		System.out.println("Cube is "+obj.getCube(3));

		//2. Using Anonymous class
		MyCube cubeObj=new MyCube() {	
			@Override
			public int getCube(int no) {				
				return no*no*no;
			}
		};
		System.out.println("Cube is "+cubeObj.getCube(5));				
	}
}
