package com.example.lcpjava.queue;

public class MyCircularQueue_2 {
	
	int[] queue = null;
	
	int head = 0;
	
	int tail = -1;
	
	int size = 0;
	
	public MyCircularQueue_2(int k) {
		queue = new int[k];																							// S : O(n)
	}
	
	public boolean enQueue(int value) {
		if (isFull()) { return false; }
		
		tail = (tail + 1) % queue.length;
		queue[tail] = value;
		size++;
		
		return true;
	}
	
	public boolean deQueue() {
		if (isEmpty()) { return false; }
		
		head = (head + 1) % queue.length;
		size--;
		
		return true;
	}
	
	public int Front() {
		return isEmpty() ? -1 : queue[head];
	}
	
	public int Rear() {
		return isEmpty() ? -1 : queue[tail];
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public boolean isFull() {
		return size == queue.length;
	}
	
}
