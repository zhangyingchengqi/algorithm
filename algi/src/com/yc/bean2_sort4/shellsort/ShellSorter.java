package com.yc.bean2_sort4.shellsort;


public class ShellSorter {

	private int[] a;

	public ShellSorter(int[] a) {
		this.a = a;
	}

	public void sort() {
		int r,i,temp,j;  //  3   1
		//外循环控制倍数
		for( r=a.length/2;r>=1;r/=2  ){
			//   i=>  3, 4,5
			for(  i=r;i<a.length;i++ ){
				temp=a[i];   // temp=1
				j=i-r;  // 0
				while(  j>=0&& temp<a[j]  ){
					a[j+r]=a[j];  //  arr=   {6,2,4,6,5,9} 
					j-=r;    // j=-3
				}
				a[j+r]=temp;   //  arr=   {1,2,4,6,5,9} 
			}
			
		}
	}

	public static void main(String[] args) {
		int[] arr = { 6, 2,4,1,5,9};

		ShellSorter bs = new ShellSorter(arr);
		bs.sort();

		for (int t : arr) {
			System.out.print(t + "\t");
		}
	}

}
