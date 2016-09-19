package com.yc.bean2_sort2.selectionsort;


public class SelectionSort {
	private int[] a;
	
	public SelectionSort( int[] a){
		this.a=a;
	}
	
	public void sort(){
		//外循 环每循环一次，表示找到一个最小值
		for(  int i=0;i<a.length;i++){
			//内循环  找到最小值的位置
			int minindex=i;
			for( int j=i+1;j<a.length;j++){
				if( a[j]<a[minindex]){
					minindex=j;
				}
			}
			int t=a[i];
			a[i]=a[minindex];
			a[minindex]=t;
		}
	}
	
	public static void main(String[] args){
		int[] arr={44,32,6,9,22};
		
		SelectionSort bs=new SelectionSort( arr );
		bs.sort();
		
		for( int t:arr){
			System.out.print(   t+"\t");
		}
	}
}
