package com.yc.bean2_sort5.mergesort;

import com.yc.bean2_sort4.shellsort.ShellSorter;
// {3,1}
public class MergeSorter {

	private int[] a;

	public MergeSorter(int[] a) {
		this.a = a;
	}

	public void sort() {
		if(  a.length<=1  ){
			return;
		}
		//将a数组拆成两个
		int[] first=new int[  a.length/2 ];
		int[] second=new int[  a.length-first.length   ];
		//将  a数组  从0开始到a.length/2-1的位置的元素值放到first中
		System.arraycopy(a, 0, first, 0, first.length);
		System.arraycopy(a,first.length,second,0,second.length);   // first=> 3    seond:1
		//递归再分
		MergeSorter ms1=new MergeSorter(first);
		MergeSorter ms2=new MergeSorter( second);
		ms1.sort();   // first: {3}
		ms2.sort();   // second: {1}
		merge(first, second);
		
	}
	
	
	//合并两个已排序数组
	private void merge(  int[] first, int [] second  ){
		//三个索引   iFirst 指first    iSecond指second,     j指新数组
		int iFirst=0, iSecond=0, j=0;
		//循 环两个数组，找到小的值存到  a中
		while(   iFirst<first.length &&iSecond<second.length ){
			if(   first[iFirst]<second[iSecond]  ){
				a[j]=first[iFirst];
				iFirst++;
			}else {
				a[j]=second[iSecond];
				iSecond++;
			}
			j++;
		}
		//预防  first数组先运行完
		System.arraycopy(first, iFirst, a, j,    first.length-iFirst );
		//预防second数组先运行完
		System.arraycopy(  second, iSecond, a, j, second.length-iSecond);   // a: 1,3
	}
	
	
	public static void main(String[] args) {
		/* */
		int[] arr = { 6, 2,4,1,5,9};
		MergeSorter bs = new MergeSorter(arr);
		bs.sort();
		for (int t : arr) {
			System.out.print(t + "\t");
		}
		
		/**
		 * 第一小步，实现两个有序数组的合并
		
		int[] x={2,66,99};
		int[] y={3,6,90};
		
		int[] r=new int[6];
		MergeSorter ms=new MergeSorter(r);
		ms.merge(x, y);
		for( int t: ms.a){
			System.out.print(   t +"\t");
		}
		 */
		
		
		
		
	}
}
