package com.yc.bean3_datatype1.LinkedList.questions;

import com.yc.bean3_datatype1.LinkedList.LinkedListType;

public class Test3 {

	/**
	 * 以给定值x 为基准将链表分为两个部分，所有小于x的结点排在大于或等于x的结点之前。
	 *   思路： 创建两个链表，一个链表存小于x的元素，一个链表存大于或等于x的元素.
      循环整个链表，将元素插入两个链表，当到达链表最后，则表明拆分完成，再合并两个链表。 
	 */
	public static void main(String[] args) {
		LinkedListType llt=new LinkedListType();
		llt.add(100);
		llt.add(20);
		llt.add(32);
		llt.add(41);
		llt.add(25);
		
		LinkedListType head=partition(  llt, 40);
	
		for( int i=0;i<head.size();i++){
			System.out.println(   head.get(i));
		}
	}
	
	public static LinkedListType partition(   LinkedListType head, Comparable obj){
		LinkedListType beforeStart=null;
		LinkedListType afterStart=null;
		
		while(   head!=null ){
			LinkedListType next=head.nextNode;
			//判断大小，存到对应的链表中
			if(  obj.compareTo(   head.t) >0 ){
				head.nextNode=beforeStart;
				beforeStart=head;
			}else{
				head.nextNode=afterStart;
				afterStart=head;
			}
			head=next;
		}
		//合并
		//先判断beforeStart是否为空
		if(  beforeStart==null ){
			return afterStart;
		}
		LinkedListType newHead=beforeStart;   //将beforeStart当成链表的前半部分
		while(   beforeStart.nextNode!=null ){
			beforeStart=beforeStart.nextNode;
		}
		beforeStart.nextNode=afterStart;
		return newHead;
	}

}
