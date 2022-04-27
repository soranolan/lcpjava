package com.example.lcpjava.queue;

/**
 * https://leetcode.com/problems/design-circular-deque/discuss/155209/c%2B%2B-99-ring-buffer-no-edge-cases.-fb-interviewer-really-loves-it.-easy-to-impl-in-4mins.-cheers!
 * */
public class MyCircularDeque_3 {
	
	public int head;
	
	public int tail;
	
	public int size;
	
	public final int INITIAL_SIZE;
	
	public int[] bucket;																							// S : O(n)
	
	public MyCircularDeque_3(int k) {
		head = 0;
		tail = k - 1;
		size = 0;
		INITIAL_SIZE = k;
		bucket = new int[k];
	}
	
	public boolean insertFront(int value) {
		if (isFull()) { return false; }
		
		bucket[head] = value;
		head = (head + 1) % INITIAL_SIZE;
		size++;
		
		return true;
	}
	
	public boolean insertLast(int value) {
		if (isFull()) { return false; }
		
		bucket[tail] = value;
		tail = (tail + INITIAL_SIZE - 1) % INITIAL_SIZE;
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
		return isEmpty() ? -1 : bucket[(head + INITIAL_SIZE - 1) % INITIAL_SIZE];
	}
	
	public int getRear() {
		return isEmpty() ? -1 : bucket[(tail + 1) % INITIAL_SIZE];
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public boolean isFull() {
		return size == INITIAL_SIZE;
	}
	
}
