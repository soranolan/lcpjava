package com.example.lcpjava.stack;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack_2 {
	
	Queue<Integer> queue = null;																					// S : O(n)
	
	public MyStack_2() {
		queue = new LinkedList<>();
	}
	
	public void push(int val) {
		int size = queue.size();
		queue.offer(val);
		while (size > 0) {																							// T : O(n)
			queue.offer(queue.poll());																				// T : O(1)
			size--;
		}
	}
	
	public int pop() {
		return empty() ? -1 : queue.poll();																			// T : O(1)
	}
	
	public int top() {
		return empty() ? -1 : queue.peek();																			// T : O(1)
	}
	
	public boolean empty() {
		return queue.isEmpty();																						// T : O(1)
	}
	
}
