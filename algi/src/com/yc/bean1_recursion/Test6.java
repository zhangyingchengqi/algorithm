package com.yc.bean1_recursion;

public class Test6 {

	public static void main(String[] args) {
		//二分查找: 顺序数组，    
		int[] t={1,2,3,6,8,9,15,18};
		System.out.println( recuisiveBinarySearch( t, 80, 0, t.length-1) );
		
	}
	
	//使用递归实现二分查找
	private static int recuisiveBinarySearch( int[] list, int key, int low, int high){    // 0, 9    4       0-3     1
		if( low>high){
			return -1;
		}else{
			//二分查找:    找中间的索引. 
			
			//找中间的索引
			int mid=(low+high)/2;
			
			if(   key<list[mid] ){
				//在左边递归
				return recuisiveBinarySearch( list, key, low, mid-1);
			}else if( key>list[mid]){
				//在右边递归
				return recuisiveBinarySearch( list, key, mid+1, high);
			}else{
				return mid;
			}
		}
	}

}
