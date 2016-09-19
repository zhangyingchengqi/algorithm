package com.yc.bean3_datatype3.QueueType;

import com.yc.bean3_datatype1.LinkedList.LinkedListType;

//使用  链表作为底层存储实现
public class QueueType2 {
	private static final int MAXLEN = Integer.MAX_VALUE;
	private LinkedListType data=new LinkedListType();   // TODO:
	private int head; // 队头
	private int tail; // 队尾

	public void init() {
		data=new LinkedListType();   //TODO:
		head = 0;
		tail = 0;
		System.gc();
	}

	// 判断是否为空队列
	public boolean isEmpty() {
		return head == tail ? true : false;
	}

	// 判断队列是否已经存满
	public boolean isFull() {
		return tail == MAXLEN ? true : false;
	}

	// 清空队列
	public void clear() {
		head = 0;
		tail = 0;
	}

	// 入队: 入队尾, tail++
	public boolean enqueue(Object obj) {
		// 判断队列是否已存满
		if (tail == MAXLEN) {
			throw new RuntimeException("队列已满");
		}
		data.add(obj);   // TODO:
		tail++;
		return true;
	}

	// 出队： 取出队头元素
	public Object dequeue() {
		if (tail == head) {
			throw new RuntimeException("队列已出空...");
		}
		return data.get(head++);
	}

	// 偷队头的值
	public Object peek() {
		if (tail == head) {
			throw new RuntimeException("队列已出空...");
		}
		return data.get(head);
	}

	// 取大小
	public int size() {
		return tail - head;
	}

	public static void main(String[] args) {
		QueueType2 qt=new QueueType2();
		
		for( int i=0;i<100;i++){
			qt.enqueue(   i+5 );
		}
		System.out.println( qt.size() );
		System.out.println(   qt.peek() );
		
		for( int i=0;i<30;i++){
			System.out.println(  qt.dequeue());
		}
	}

}
