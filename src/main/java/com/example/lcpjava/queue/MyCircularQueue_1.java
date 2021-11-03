package com.example.lcpjava.queue;

public class MyCircularQueue_1 {
	
	int[] queue = null;
	
	int head = -1;
	
	int tail = -1;
	
	public MyCircularQueue_1(int k) {
		queue = new int[k];																							// S : O(n)
	}
	
	public boolean enQueue(int value) {
		if (isFull()) { return false; }
		
		if (tail == -1) { head = 0; }
		tail = (tail + 1) % queue.length;
		queue[tail] = value;
		
		return true;
	}
	
	public boolean deQueue() {
		if (isEmpty()) { return false; }
		
		queue[head] = 0;
		if (head == tail) {
			head = -1;
			tail = -1;
		} else {
			head = (head + 1) % queue.length;
		}
		
		return true;
	}
	
	public int Front() {
		if (isEmpty()) { return -1; }
		return queue[head];
	}
	
	public int Rear() {
		if (isEmpty()) { return -1; }
		return queue[tail];
	}
	
	public boolean isEmpty() {
		if (tail == -1) { return true; }
		return false;
	}
	
	public boolean isFull() {
		if (tail == -1) { return false; }
		int distance = tail - head;
		if (distance == -1 || distance == (queue.length - 1)) { return true; }
		return false;
	}
	
}
