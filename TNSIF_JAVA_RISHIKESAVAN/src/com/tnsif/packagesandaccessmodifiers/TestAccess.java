package com.tnsif.packagesandaccessmodifiers;

public class TestAccess {

	public static void main(String[] args) {
		
		AccessModifiersExample ame = new AccessModifiersExample();
		
		System.out.println("Public Variable: "+ ame.publicVar);
		//System.out.println("Private Variable: "+ ame.privateVar);
		System.out.println("Protected Variable: "+ ame.protectedVar);
		System.out.println("Default Variable: "+ ame.defaultVar);

	}

}
