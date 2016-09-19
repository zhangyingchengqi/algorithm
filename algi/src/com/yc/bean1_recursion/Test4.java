package com.yc.bean1_recursion;

public class Test4 {

	public static void main(String[] args) {
		System.out.println( isPalindrome( "ab") );
		
		System.out.println( isPalindrome( "aba",0, "aba".length()-1) );
	}

	
	
	//判断一个字符串是否为回文
	//   "c"  => true
	//  "bb"  => true
	// "bcb"  => true
	//"abcba"  => true
	private static boolean isPalindrome(String string) {
		if( string.length()<=1){
			return true;
		}else if(   string.charAt(0) !=   string.charAt(string.length()-1) ){
			return false;
		}else{
			//
			String t=string.substring(1, string.length()-1);     //       String  ->  常量   ->  substring  () ->新字符串   -> 
			return isPalindrome( t );
		}
	}
	
	
	private static boolean isPalindrome(String string, int low, int high) {
		if( high<=low){
			return true;
		}else if(   string.charAt(low) !=   string.charAt(high) ){
			return false;
		}else{
			return isPalindrome( string, low+1, high-1 );
		}
	}
	
	
	   

}
