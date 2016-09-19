package com.yc.bean3_datatype2.StackType.questions;

import com.yc.bean3_datatype2.StackType.StackType;

/**
 * 实现一个MyQueue类, 用两个栈来实现一个队列. 
       解决方案:   需要修改peek()和pop(), 以相反顺序执行操作. 我们可以利用第二个栈反转元素的次序(弹出stackNew的元素，压入stackOld).
 *
 */
public class Test3 {
	public static void main(String[] args) {
		MyQueue mq=new MyQueue();
		mq.enqueue(1);
		mq.enqueue(2);
		mq.enqueue(3);
		mq.enqueue(4);
		
		for( int i=0;i<4;i++){
			System.out.println( mq.dequeue() );
		}
	}
}

class MyQueue{
	StackType stackNew,stackOld;
	
	public MyQueue(){
		stackNew=new StackType();
		stackOld=new StackType();
	}
	
	public int size(){
		return stackNew.size()+stackOld.size();
	}
	/**
	 * 入队,最新元素始位于它的顶端
	 * @param value
	 */
	public void enqueue( Object value){
		stackNew.push(value);
	}
	
	private void shiftStack(){
		if( stackOld.isEmpty() ){
			while(  !stackNew.isEmpty() ){
				stackOld.push(   stackNew.pop());
			}
		}
	}
	//查看队头元素 
	public Object peek(){
		shiftStack();
		return stackOld.peek();
	}
	//出队
	public Object dequeue(){
		shiftStack();
		return stackOld.pop();
	}
}
