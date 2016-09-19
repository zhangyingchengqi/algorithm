package com.yc.bean2_sort6.quicksort;


public class QuickSort {
	private int[] a;
	public QuickSort(int[] a) {
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
		int pivot=a[from];//参照值
		int i=from-1;
		int j=to+1;
		while( i<j ){
			//i表示左边，只要左边有一个值比pivot大，则记下这个位置(停下)
			i++;
			while(    a[i]<pivot){
				i++;
			}
			//j表示右边，只要右边有一个值比 pivot小，则记录下。
			j--;
			while( a[j]>pivot){
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
		int temp=a[i];
		a[i]=a[minPos];
		a[minPos]=temp;
	}
	public static void main(String[] args) {
		int[] arr = { 6, 2,4,1,5,9};

		QuickSort bs = new QuickSort(arr);
		bs.sort();

		for (int t : arr) {
			System.out.print(t + "\t");
		}
	}
}
