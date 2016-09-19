package com.yc.bean1_recursion;

public class Test1 {

	public static void main(String[] args) {
		System.out.println(    factorial( 4) );
	}

	//n½×³Ë
	private static int factorial(int i) {
		if( i==1){
			return 1;
		}else{
			return i*factorial( i-1 );
		}
		
		
		
	}
	
	
	

}
