package com.yc.bean3_datatype1.LinkedList.questions;

import com.yc.bean3_datatype1.LinkedList.LinkedListType;

public class Test2 {

	/**
	 * 实现一个算法，找出单向链表中倒数第n个结点。
	 *思路： 使用两个指针，开始时，它们都指向链表的首结点，然后将p2指针向前移动n个结点，
           之后，以同样的速度移动这两个指针，p2会在移动length-n后到达链表的最后，此时，p1会指向链表倒数第n个结点
	 */
	public static void main(String[] args) {
		LinkedListType llt=new LinkedListType();
		llt.add(1);
		llt.add(2);
		llt.add(3);
		llt.add(4);
		llt.add(2);
		LinkedListType node=toLastN( llt, 0);
		System.out.println(   node==null?null: node.t   );
	}
	
	public static LinkedListType toLastN(  LinkedListType head, int n    ){
		if(  n<=0){
			return null;
		}
		LinkedListType p1=head;
		LinkedListType p2=head;
		
		for( int i=0;i<n;i++){
			if(  p2==null){
				return null;
			}
			p2=p2.nextNode;
		}
		if(  p2==null){
			return null;
		}
		while(  p2.nextNode!=null ){
			p1=p1.nextNode;
			p2=p2.nextNode;
		}
		return p1;
	}

}
