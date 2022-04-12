package com.example.lcpjava.stack;

import com.example.lcpjava.common.Lcp_155_Node;

public class MinStack_1 {
	
	public Lcp_155_Node head;
	
	public MinStack_1() {
		
	}
	
	public void push(int val) {
		Lcp_155_Node current = null;
		if (head == null) {
			current = new Lcp_155_Node(val, val, null);
		} else {
			current = new Lcp_155_Node(val, Math.min(val, head.min), head);
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
