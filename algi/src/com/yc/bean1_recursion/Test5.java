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
	
	//ʹ�õݹ�ʵ��ѡ������
	private static void sort(   int[] list, int low, int high){
		if(   low>=high){
			return;
		}else{
			//ҵ��: ѭ����low��highλ���ҳ�Сֵ���浽  low��λ��
			//�浱ǰlowλ�õ�ֵ
			int indexofmin=low;
			int min=list[low];
			for( int i=low+1;i<=high;i++){
				if( list[i]<min ){
					//��¼��С��ֵ��λ��,ֵ
					min=list[i];
					indexofmin=i;
				}
			}
			//��ɽ���
			list[indexofmin]=list[low];
			list[low]=min;
			
			
			sort( list, low+1, high );
		}
	}
	

}