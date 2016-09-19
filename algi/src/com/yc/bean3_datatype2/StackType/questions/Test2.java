package com.yc.bean3_datatype2.StackType.questions;

import com.yc.bean3_datatype2.StackType.StackType;

/**
 * 2. 设计一个栈，除了pop(), push()外，还有min方法可返回栈中最小的值。
 * 解决方案： 利用额外的stackType来记录
 */
public class Test2 {

	public static void main(String[] args) {
		MyStack2 ms=new MyStack2();
		ms.push(1);
		ms.push(3);
		ms.push(22);
		
		System.out.println( ms.min()  );
		System.out.println( ms.max()  );
		ms.pop();
		System.out.println( ms.min()  );
		System.out.println( ms.max()  );
		ms.pop();
		System.out.println( ms.min()  );
		System.out.println( ms.max()  );
	}

}

class MyStack2 extends StackType {
	// 这是一个新栈，用于存当前这个栈中最小的值
	private StackType mins = new StackType();
	private StackType maxs= new StackType();

	// 压栈
	public boolean push(Comparable obj) {
		// 先取出当前栈中最小的值,可以保证mins这个栈中的栈顶总是最小值
		if (min()==null||obj.compareTo(min()) < 0) {
			mins.push(obj);
		}
		if (max()==null||obj.compareTo(max()) > 0) {
			maxs.push(obj);
		}
		return super.push(obj);
	}

	// 出栈:出栈时，有可以将最小值从栈中去除，所以也要保证mins中也要将最小值去除
	public Object pop() {
		Comparable obj=(Comparable) super.pop();
		if(  obj.compareTo(min())==0){
			mins.pop();
		}
		if(  obj.compareTo(max())==0){
			maxs.pop();
		}
		return obj;
	}

	public Comparable min() {
		if (mins.isEmpty()) {
			return null;
		}else{
			return (Comparable) mins.peek();   //取出mins中最小的值
		}
	}
	
	public Comparable max() {
		if (maxs.isEmpty()) {
			return null;
		}else{
			return (Comparable) maxs.peek();   //取出mins中最小的值
		}
	}
}
