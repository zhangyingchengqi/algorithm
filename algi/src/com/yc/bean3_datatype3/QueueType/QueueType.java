package com.yc.bean3_datatype3.QueueType;

//使用数组来作为底层存储实现
public class QueueType {
	private static final int MAXLEN = 100;
	private Object[] data = new Object[MAXLEN];
	private int head; // 队头
	private int tail; // 队尾

	public void init() {
		data = new Object[MAXLEN];
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
		data[tail] = obj;
		tail++;
		return true;
	}

	// 出队： 取出队头元素
	public Object dequeue() {
		if (tail == head) {
			throw new RuntimeException("队列已出空...");
		}
		return data[head++];
	}

	// 偷队头的值
	public Object peek() {
		if (tail == head) {
			throw new RuntimeException("队列已出空...");
		}
		return data[head];
	}

	// 取大小
	public int size() {
		return tail - head;
	}

	public static void main(String[] args) {
		QueueType qt=new QueueType();
		
		for( int i=0;i<10;i++){
			qt.enqueue(   i+5 );
		}
		System.out.println( qt.size() );
		System.out.println(   qt.peek() );
		
		for( int i=0;i<30;i++){
			System.out.println(  qt.dequeue());
		}
	}

}
