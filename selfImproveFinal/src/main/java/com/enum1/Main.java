package com.enum1;

public class Main {
	public static void main(String[] args) {
//		Season.enumIterate();
//		Season.display(Season.SUMMER);
		
		//比较 ==
//		System.out.println(Season.FALL == Season.FALL);//true
//		System.out.println(Season.FALL == Season.SPRING);//false
//		
//		System.out.println(Season.FALL.equals(Season.FALL));// true
//		System.out.println(Season.FALL.equals("FALL"));// false and no compiler error pitfall
//		System.out.println(Season.FALL.equals(Season.WINTER));// false
		
		// Usage:
		MutableExample.A.print();       // Outputs 0
		MutableExample.A.increment();
		MutableExample.A.print();       // Outputs 1 -- we've changed a field   
		MutableExample.B.print();       // Outputs 0 -- another instance remains unchanged
	}
}


