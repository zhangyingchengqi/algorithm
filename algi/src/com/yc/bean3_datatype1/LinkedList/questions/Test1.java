package com.yc.bean3_datatype1.LinkedList.questions;

import java.util.Hashtable;

import com.yc.bean3_datatype1.LinkedList.LinkedListType;

public class Test1 {

	
	/**
	 * 2. 编写代码，移除没有排过序的链表中的重复结点？
    思路： 方案一： 可以直接访问整个链表，将每个结点加入散列表，若发现重复元素则将该结点从链表中移除，然后继续。
        方案二： 不使用缓存散列表，则可以用两个指针来循环，p1循环整个链表，p2检查后续的结点是否有重复。
	 */
	public static void main(String[] args) {
		LinkedListType llt=new LinkedListType();
		llt.add(1);
		llt.add(2);
		llt.add(3);
		llt.add(4);
		
		llt.add(2);
		
		for( int i=0;i<llt.size();i++){
			System.out.println(   llt.get(i));
		}
		
		delete2(  llt );
		for( int i=0;i<llt.size();i++){
			System.out.println(   llt.get(i));
		}
	}
	
	public static void delete1(  LinkedListType node){
		Hashtable ht=new Hashtable();
		LinkedListType previous=null;
		while(    node!=null ){

			if(  ht.containsKey(node.t)   ){



				//执行删除
				previous.nextNode=node.nextNode;
			}else{
				ht.put(node.t, true);
				previous=node;
			}
			node=node.nextNode;
		}
	}
	
	public static void delete2( LinkedListType node){
		if(  node==null){
			return;
		}
		LinkedListType p1=node;   //临时指针
		while(  p1!=null ){
			LinkedListType p2=p1;   //让p1和p2指向同一节点
			//再判断p2是否有下一个节点，如果有，则取出下一个节点进行相等判断
			while(  p2.nextNode!=null  ){
				if(  p2.nextNode.t.equals(p1.t)){
					p2.nextNode=p2.nextNode.nextNode;
				}else{
					p2=p2.nextNode;
				}
			}
			p1=p1.nextNode;
		}
	}
	

}
