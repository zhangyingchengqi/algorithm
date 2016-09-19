package com.yc.bean2_sort3.insertsort;

import com.yc.bean2_sort2.selectionsort.SelectionSort;

public class InsertSorter {
	private int[] a;
	
	public InsertSorter( int[] a){
		this.a=a;
	}
	
	public void sort(){
		//插入排序假定: 前面的元素是已经排好序. 
		
		//假定第一个元素它是已经排好序的, 从第二个元素循环
		for( int i=1;i<a.length;i++){
			//取出当前的值
			int next=a[i];
			//记录索引
			int j=i;
			//循环i前面的元素，看前面的元素是否大于  next
			while(   j>0 && a[j-1]  >next ){
				//交换位置
				a[j]=a[j-1];
				j--;
			}
			a[j]=next;
		}
	}
	
	public static void main(String[] args){
		int[] arr={44,32,6,9,22};
		
		InsertSorter bs=new InsertSorter( arr );
		bs.sort();
		
		for( int t:arr){
			System.out.print(   t+"\t");
		}
	}
}
