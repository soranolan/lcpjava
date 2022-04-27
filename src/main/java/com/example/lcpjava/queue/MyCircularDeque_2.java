package com.example.lcpjava.queue;

import com.example.lcpjava.common.MyCircularDequeNode;

/**
 * https://leetcode.com/problems/design-circular-deque/discuss/149371/Java-doubly-LinkedList-solution-very-straightforward
 * */
public class MyCircularDeque_2 {
	
	int capacity;
	
	int size;
	
	MyCircularDequeNode head;
	
	MyCircularDequeNode tail;
	
	public MyCircularDeque_2(int k) {
		capacity = k;
		size = 0;
		
		head = new MyCircularDequeNode(-1);
		tail = new MyCircularDequeNode(-1);
		
		head.next = tail;
		tail.prev = head;
	}
	
	public boolean insertFront(int value) {
		if (isFull()) { return false; }
		
		MyCircularDequeNode newNode = new MyCircularDequeNode(value);
		
		newNode.next = head.next;																					// newNode_2 → newNode_1
		head.next.prev = newNode;																					// newNode_2 ← newNode_1
		
		head.next = newNode;																						// head → newNode_2
		newNode.prev = head;																						// head ← newNode_2
		
		size++;
		
		return true;
	}
	
	public boolean insertLast(int value) {
		if (isFull()) { return false; }
		
		MyCircularDequeNode newNode = new MyCircularDequeNode(value);
		
		newNode.prev = tail.prev;																					// newNode_1 ← newNode_2
		tail.prev.next = newNode;																					// newNode_1 → newNode_2
		
		tail.prev = newNode;																						// newNode_2 ← tail
		newNode.next = tail;																						// newNode_2 → tail
		
		size++;
		
		return true;
	}
	
	public boolean deleteFront() {
		if (isEmpty()) { return false; }
		
		head.next.next.prev = head;
		head.next = head.next.next;
		size--;
		
		return true;
	}
	
	public boolean deleteLast() {
		if (isEmpty()) { return false; }
		
		tail.prev.prev.next = tail;
		tail.prev = tail.prev.prev;
		size--;
		
		return true;
	}
	
	public int getFront() {
		return head.next.val;
	}
	
	public int getRear() {
		return tail.prev.val;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public boolean isFull() {
		return size == capacity;
	}
	
}
