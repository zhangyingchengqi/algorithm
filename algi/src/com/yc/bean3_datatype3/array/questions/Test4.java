package com.yc.bean3_datatype3.array.questions;

import java.util.Random;

/**
 * 随机发牌. 有10000张牌,随机发出一张，要使得随机发出的牌不重复，而且时间，空间复杂度要恒定。如何实现?


   =>  [1,2,3,4,5,6,7,8.....10000];
 *
 */
public class Test4 {
	
public static final int length=10;
	
	public static void main(String[] args) {
		int[] arr=new int[length];
		for( int i=1;i<=length;i++){
			arr[i-1]=i;
		}
		Random r=new Random();
		int index=length;
		int temp=0;
		int i=1;
		while(  index>0 ){
			int tempindex=r.nextInt(index);
			System.out.println(  arr[tempindex]);
			temp=arr[index-1];
			arr[index-1]=arr[tempindex];
			arr[tempindex]=temp;
			index--;
			i++;
		}
	}
}
