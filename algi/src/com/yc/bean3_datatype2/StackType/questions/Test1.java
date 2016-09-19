package com.yc.bean3_datatype2.StackType.questions;

/**
 * 1. 只用一个数组实现三个栈. 解决方案：将整个数组分成三等份，将每个栈的增长限制在各自的空间中。 这样，栈1使用 0-n/3, 栈2使用
 * n/3-2n/3, 栈3使用 2n/3-n
 *
 */
public class Test1 {

	public static void main(String[] args) {
		MyStack ms=new MyStack();
		ms.push(0, 1);
		ms.push(0, 2);
		ms.push(0, 3);
		ms.push(0, 4);
		ms.push(1, 5);
		ms.push(1, 6);
		ms.push(1, 7);
		ms.push(1, 8);
		ms.push(2, 80);
		
		for( int t: ms.buffer){
			System.out.print(    t+"\t" );
		}
	}

}

class MyStack {

	int stackSize = 10;
	int[] buffer = new int[3 * stackSize];
	int[] stackPointer = { -1, -1, -1 }; // 每个栈的栈顶指针

	public boolean isEmpty(int stackNum) {
		return stackPointer[stackNum] == -1;
	}

	public int size(int stackNum) {
		return stackPointer[stackNum] + 1;
	}

	public boolean isFull(int stackNum) {
		return stackPointer[stackNum] == (stackSize - 1);
	}

	// 入栈
	public void push(int stackNum, int value) {
		// 判断stackNum所指定的栈是否已满
		if (isFull(stackNum)) {
			throw new RuntimeException("stack " + stackNum + " is full");
		}
		stackPointer[stackNum]++;
		// 存值 buffer[0] buffer[100] buffer[200]
		int index = absPosStack(stackNum);
		buffer[index] = value;

	}

	// 出栈
	public int pop(int stackNum) {
		// 判断stackNum所指定的栈是否已空
		if (stackPointer[stackNum] == -1) {
			throw new RuntimeException("stack " + stackNum + " is empty");
		}
		int index = absPosStack(stackNum); // 取出栈顶的索引
		int value = buffer[index];
		stackPointer[stackNum]--;
		return value;
	}
	
	// 出栈
		public int peek(int stackNum) {
			// 判断stackNum所指定的栈是否已空
			if (stackPointer[stackNum] == -1) {
				throw new RuntimeException("stack " + stackNum + " is empty");
			}
			int index = absPosStack(stackNum); // 取出栈顶的索引
			int value = buffer[index];
			return value;
		}

	private int absPosStack(int stackNum) {
		return stackNum * stackSize + stackPointer[stackNum];
	}
}
