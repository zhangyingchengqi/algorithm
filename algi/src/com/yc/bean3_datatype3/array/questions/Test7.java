package com.yc.bean3_datatype3.array.questions;

/**
 * 有一个已经排序的数组（升序），数组中可能有正数、负数或0，求数组中元素的绝对值最小的数，要求，不能用顺序比较的方法（复杂度需要小于O（n）），可以使用任何语言实现

例如，数组{-20，-13，-4, 6, 77,200} ，绝对值最小的是-4。



初步的解决思路是：

    1.数组中的元素全为正，取最左边的数字；

    2.数组中的元素全为负，取最右边的数字的绝对值；

    3.数组中有正数有负数，就用二分法查找，判断中间元素的符号

       a)中间元素为正，继续判断中间元素前面一个元素的符号

       b)中间元素为负，判断中间元素后一个元素的符号

       c)中间元素为零，令其等于结果值返回

下面是根据上面的想法的代码实现，应该还会有漏洞
 *
 */
public class Test7 {
	public static void main(String[] args) {
		int [] arr={-22,-11,-5,-2,3,55,77,88,99,120};
		int min=minAbsoluteInSortedArray(   arr );
		System.out.println(    min );
	}
	
	public static int minAbsoluteInSortedArray(   int[] arr){
		int first=0;
		int last=arr.length-1;
		int result=0;
		//数组中全是负数，则取最右边的数
		if(    arr[0]<0&&arr[last]<0){
			result=arr[last];
		}else if(  arr[0]>0&&arr[last]>0){
			result=arr[0];
		}else{
			//二分查找
			while(  first<last){
				int mid=(first+last)/2;
				if( arr[mid]>0){     //中间元素为正，继续判断中间元素前面一个元素的符号
					if( arr[mid-1]>0){
						last=mid-1;
					}else if( arr[mid-1]<0){
						result=   -arr[mid-1]<arr[mid]?arr[mid-1]:arr[mid];
						break;
					}else{
						result=arr[mid-1];
						break;
					}
				}else if(  arr[mid]<0){
					if(  arr[mid+1]<0){
						first=mid+1;
					}else if(   arr[mid+1]>0){
						result=   -arr[mid]<arr[mid+1]?arr[mid]:arr[mid+1];
						break;
					}else{
						result=arr[mid+1];
						break;
					}
				}
			}
			
		}
		return result;
	}
}
