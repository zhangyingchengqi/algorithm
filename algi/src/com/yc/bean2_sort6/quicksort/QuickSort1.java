package com.yc.bean2_sort6.quicksort;


public class QuickSort1 {
	private String[] a;
	public QuickSort1(String[] a) {
		this.a = a;
	}
	public void sort() {
		sort( 0,a.length-1);
	}
	private void sort(int from, int to) {
		if(from>=to){
			return;
		}
		int p=partition( from, to);
		sort( from ,p);
		sort( p+1,to);
	}
	private int partition(int from, int to) {
		String pivot=a[from];
		int i=from-1;
		int j=to+1;
		while( i<j ){
			//i表示左边，只要左边有一个值比pivot大，则记下这个位置(停下)
			i++;
			while(   a[i].compareTo(pivot)<0){    //     string.compareTo(anotherstring)      正数 "c"  "b" ->1      负数      0
				i++;
			}
			//j表示右边，只要右边有一个值比 pivot小，则记录下。
			j--;
			while(  a[j].compareTo(pivot)>0){
				j--;
			}
			//交换i, j
			if( i<j ){
				swap( i,j);
			}
		}
		return j;
	}
	private void swap(  int minPos, int i ){
		String temp=a[i];
		a[i]=a[minPos];
		a[minPos]=temp;
	}
	public static void main(String[] args) {
		String[] arr = { "ab","ty","lm","op","ef"};

		QuickSort1 bs = new QuickSort1(arr);
		bs.sort();

		for (String t : arr) {
			System.out.print(t + "\t");
		}
	}
}
