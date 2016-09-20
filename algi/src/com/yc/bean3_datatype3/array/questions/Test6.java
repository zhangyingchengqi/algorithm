package com.yc.bean3_datatype3.array.questions;

/**
 * 确定一个字符串的所有字符是否全都不同.
 */
public class Test6 {
	public static void main(String[] args) {
		String s="aaadegf";
		System.out.println(    isUniqueChar(  s )   );
	}
	public static boolean isUniqueChar(  String str ){
		if(  str.length()>256 ){
			return false;
		}
		boolean [] char_set=new boolean[256];  //  false
		for( int i=0;i<str.length();i++){
			int charcode=str.charAt(i);
			if(   char_set[charcode]==true  ){
				return false;
			}
			char_set[charcode]=true;
		}
		return true;
	}
}
