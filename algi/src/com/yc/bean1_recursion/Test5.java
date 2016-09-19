package com.yc.bean1_recursion;

public class Test5 {

	public static void main(String[] args) {
		int[] x={33,22,11,12,10,100};
		sort( x,  0, x.length-1 );
		printArray( x );
		
	}
	
	private static void printArray( int[] x){
		for( int t: x){
			System.out.print(   t+"\t");
		}
	}
	
	//使用递归实现选择排序
	private static void sort(   int[] list, int low, int high){
		if(   low>=high){
			return;
		}else{
			//业务: 循环从low到high位置找出小值，存到  low的位置
			//存当前low位置的值
			int indexofmin=low;
			int min=list[low];
			for( int i=low+1;i<=high;i++){
				if( list[i]<min ){
					//记录最小的值的位置,值
					min=list[i];
					indexofmin=i;
				}
			}
			//完成交换
			list[indexofmin]=list[low];
			list[low]=min;
			
			
			sort( list, low+1, high );
		}
	}
	

}
