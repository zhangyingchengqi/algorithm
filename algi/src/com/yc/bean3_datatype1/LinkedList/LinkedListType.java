package com.yc.bean3_datatype1.LinkedList;

//单链表
public  class LinkedListType<T>{
	public T t;
	public LinkedListType<T> nextNode;    //下一节点
	//获取链表的长度
	public int size(     ){
		int size=0;
		LinkedListType temp=this;
		while(    temp!=null  ){
			size++;
			//
			temp=temp.nextNode;
		}
		return size;
	}
	//遍历节点
	public void showAllNode(   ){
		LinkedListType temp=this;
		int length=size(   );
		System.out.println("总共有"+ length+"个节点...,它们是:");
		while(    temp!=null  ){
			System.out.println( temp.t ); 
			//
			temp=temp.nextNode;
		}
	}
	//     add( t )
	public LinkedListType add(   T t  ){
		if(   this.t==null){
			this.t=t;
			return this;
		}
		LinkedListType<T> node=new LinkedListType<T>();
		if(   node==null   ){
			throw new RuntimeException("申请内存空间失败...");
		}
		//新节点的数据
		node.t=t;   //将数据t存到新节点中
		node.nextNode=null;
		//循环查找链表的最后一个元素
		//异常：head为空，则  node为首节点
		
		//循 环
		LinkedListType temp=this;
		while(  temp.nextNode!=null  ){
			temp=temp.nextNode;
		}
		temp.nextNode=node;
		return this;
	}
	
	public LinkedListType addFirst(   T t){
		LinkedListType<T> node=new LinkedListType<T>();
		if(   node==null   ){
			throw new RuntimeException("申请内存空间失败...");
		}
		//新节点的数据
		node.t=t;   //将数据t存到新节点中
		node.nextNode=this;
		return node;
	}
	
	public LinkedListType addLast(T t){
		return add( t);
	}
	
	public LinkedListType removeFirst( ){
		LinkedListType<T> newhead= this.nextNode;
		return newhead;
	}
	
	public LinkedListType removeLast( ){
		LinkedListType<T> temp=this;
		LinkedListType<T> pre=null;
		while(   temp!=null ){
			pre=temp;
			temp=temp.nextNode;
		}
		//找到了最后一个节点
		pre.nextNode=null;
		return this;
	}
	
	public T get( int index){
		int i=0;
		LinkedListType<T> temp=this;
		while( temp!=null  ){
			if( i==index){
				return temp.t;
			}
			i++;
			temp=temp.nextNode;
		}
		throw new RuntimeException("索引下标越界");
	}
	
	public static void main(String[] args){
		LinkedListType head=new LinkedListType();
		head.add("tom");
		head.add("smith");
		
		System.out.println(   head.size(  ));
		
		System.out.println(  head.get(0));
		 head=head.removeFirst();
		System.out.println(  head.size()  );
		System.out.println(  head.get(0));
		
		
	}
	
	//TODO: 快慢行...
	
	
	
}
