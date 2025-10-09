package com.wrapperclass;

public class WrapperClassDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		//autoboxing - primitive to object
		//unboxing - object to primitive
		
		int x = 5;
		//autoboxing
		Integer y = Integer.valueOf(x);
		
		//unboxing 
		
		int z = y;
		
		System.out.println(y +" "+ z);

	}

}
