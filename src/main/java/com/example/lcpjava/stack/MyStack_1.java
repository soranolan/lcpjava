package com.example.lcpjava.stack;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack_1 {
	
	Queue<Integer> pushQueue = null;																				// S : O(n)
	
	Queue<Integer> popQueue = null;																					// S : O(n)
	
	public MyStack_1() {
		pushQueue = new LinkedList<>();
		popQueue = new LinkedList<>();
	}
	
	public void push(int val) {
		pushQueue.offer(val);																						// T : O(1)
		
		while (!popQueue.isEmpty()) { pushQueue.offer(popQueue.poll()); }											// T : O(n)
		
		Queue<Integer> emptyQueue = popQueue;
		popQueue = pushQueue;
		pushQueue = emptyQueue;
	}
	
	public int pop() {
		return empty() ? -1 : popQueue.poll();																		// T : O(1)
	}
	
	public int top() {
		return empty() ? -1 : popQueue.peek();																		// T : O(1)
	}
	
	public boolean empty() {
		return popQueue.isEmpty();																					// T : O(1)
	}
	
}
