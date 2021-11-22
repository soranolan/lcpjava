package com.example.lcpjava.queue;

import java.util.Stack;

public class MyQueue_1 {
	
	Stack<Integer> pushStack = null;
	
	Stack<Integer> popStack = null;
	
	public MyQueue_1() {
		pushStack = new Stack<>();																					// S : O(n)
		popStack = new Stack<>();																					// S : O(n)
	}
	
	public void push(int val) {
		pushStack.push(val);																						// T : O(1)
	}
	
	public int pop() {
		if (!popStack.isEmpty()) { return popStack.pop(); }															// T : O(1)
		move();
		return empty() ? -1 : popStack.pop();																		// T : O(1)
	}
	
	public int peek() {
		if (!popStack.isEmpty()) { return popStack.peek(); }														// T : O(1)
		move();
		return empty() ? -1 : popStack.peek();																		// T : O(1)
	}
	
	public boolean empty() {
		return pushStack.isEmpty() && popStack.isEmpty();															// T : O(1)
	}
	
	public void move() {
		while (!pushStack.isEmpty()) { popStack.push(pushStack.pop()); }											// T : O(1)
	}
	
}
