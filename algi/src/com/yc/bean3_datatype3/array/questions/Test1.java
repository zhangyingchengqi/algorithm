package com.yc.bean3_datatype3.array.questions;

/**
 * 给定两个排序后的数组a和b, 其中a的未端有足够的空间来存b,,编写一个方法，将b合并入a并排序. 
     解决方案:  从数组的最后开始比较，将最大的元素放到数组a的最后
 */
public class Test1 {

	public static void main(String[] args){
		int[] x=new int[]{2,4,7,99,100,200,0,0,0,0,0};
		int[] y={3,6,8,9,220};
		merge(x,y,6,5);
		for(   int t: x){
			System.out.print( t+"\t");
		}
	}
	
	/**
	 * 合并
	 * @param a: 第一个排序数组
	 * @param b: 第二个排序数组
	 * @param lastA: 第一个数组的有效数据的长度
	 * @param lastB: 第二个数组的有效数据的长度
	 */
	public static void merge( int[] a, int [] b, int lastA, int lastB){
		int indexA=lastA-1;
		int indexB=lastB-1;
		
		int indexmerged=lastA+lastB-1;  //合并后最后元素的索引
		while(  indexA>=0&&indexB>=0 ){
			if(  a[indexA]>b[indexB]){
				a[indexmerged]=a[indexA];
				indexmerged--;
				indexA--;
			}else{
				a[indexmerged]=b[indexB];
				indexmerged--;
				indexB--;
			}
		}
		
		while(     indexB>=0){
			a[indexmerged]=b[indexB];
			indexmerged--;
			indexB--;
		}
		//处理完 b 数组元素后，不需要复制a的shengyu元素.
	}
}
