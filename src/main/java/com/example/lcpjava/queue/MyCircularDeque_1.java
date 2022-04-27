package com.example.lcpjava.queue;

public class MyCircularDeque_1 {
	
	public int head;
	
	public int tail;
	
	public int size;
	
	public final int INITIAL_SIZE;
	
	public int[] bucket;																							// S : O(n)
	
	public MyCircularDeque_1(int k) {
		head = -1;
		tail = k;
		size = 0;
		INITIAL_SIZE = k;
		bucket = new int[k];
	}
	
	public boolean insertFront(int value) {
		if (isFull()) { return false; }
		
		head = (head + 1) % INITIAL_SIZE;
		if (isEmpty()) { tail = head; }
		
		bucket[head] = value;
		size++;
		
		return true;
	}
	
	public boolean insertLast(int value) {
		if (isFull()) { return false; }
		
		tail = (tail + INITIAL_SIZE - 1) % INITIAL_SIZE;
		if (isEmpty()) { head = tail; }
		
		bucket[tail] = value;
		size++;
		
		return true;
	}
	
	public boolean deleteFront() {
		if (isEmpty()) { return false; }
		
		head = (head + INITIAL_SIZE - 1) % INITIAL_SIZE;
		size--;
		
		return true;
	}
	
	public boolean deleteLast() {
		if (isEmpty()) { return false; }
		
		tail = (tail + 1) % INITIAL_SIZE;
		size--;
		
		return true;
	}
	
	public int getFront() {
		return isEmpty() ? -1 : bucket[head];
	}
	
	public int getRear() {
		return isEmpty() ? -1 : bucket[tail];
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public boolean isFull() {
		return size == INITIAL_SIZE;
	}
	
}
