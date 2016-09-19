package com.yc.bean3_datatype2.StackType;

public class StackType {
	protected static final int MAXLEN = 100;
	// 可以使用线性表，也可以使用链表
	protected Object[] data = new Object[MAXLEN];

	protected int top; // 栈顶

	// 初始化栈
	public void init() {
		top = 0;
		data = new Object[MAXLEN];
		System.gc();
	}

	// 判断是否为空栈
	public boolean isEmpty() {
		return top == 0 ? true : false;
	}

	// 判断栈是否已经存满
	public boolean isFull() {
		return top == MAXLEN ? true : false;
	}

	// 清空栈
	public void clear() {
		top = 0;
	}

	// 压栈
	public boolean push(Object obj) {
		// 判断是否yi出
		if (top >= MAXLEN) {
			throw new RuntimeException("栈溢出");
		}
		data[top] = obj;
		top++;
		return true;
	}

	// 出栈
	public Object pop() {
		// 判断是否到栈底
		if (top == 0) {
			throw new RuntimeException("栈已出空.");
		}
		return data[--top];
	}

	// 偷kui栈顶值
	public Object peek() {
		// 判断是否到栈底
		if (top == 0) {
			throw new RuntimeException("栈已出空.");
		}
		return data[top - 1];
	}
	
	//获取大小
	public int size(){
		return top;
	}

	public static void main(String[] args) {
		StackType st=new StackType();
		st.push("a");
		st.push("b");
		
		st.push("c");
		
		System.out.println(   st.size()  );
		
		System.out.println(   st.peek() );
		
		System.out.println( st.pop() );
		
		System.out.println( st.peek() );
		
	}

}
