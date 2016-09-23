package com.yc.bean1_recursion;

public class Test3 {

	public static void main(String[] args) {
		printHello("hello world",10);
	}

	//以递归实现输出 n次hello world. 
	private static void printHello(String string, int i) {
		if(   i <1){
			return;
		}else{
			System.out.println( "第"+ i+"次:"+ string);
			printHello( string,i-1);
		}
	}
	

	

	

}
