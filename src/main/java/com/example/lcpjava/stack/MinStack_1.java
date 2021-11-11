package com.example.lcpjava.stack;

public class MinStack_1 {
	
	public Node head;
	
	public MinStack_1() {
		
	}
	
	public void push(int val) {
		Node current = null;
		if (head == null) {
			current = new Node(val, val, null);
		} else {
			current = new Node(val, Math.min(val, head.min), head);
		}
		head = current;
	}
	
	public void pop() {
		head = head.next;
	}
	
	public int top() {
		return head.val;
	}
	
	public int getMin() {
		return head.min;
	}
	
}
