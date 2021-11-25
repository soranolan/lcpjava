package com.example.lcpjava.stack;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Lcp_394_Decode_String {
	
	public String decodeString_1(String s) {
		Stack<Character> stack = new Stack<>();																		// S : O(result)
		char[] parentheses = s.toCharArray();
		
		for (char right : parentheses) {																			// T : O(n)
			if (right != ']') {
				stack.push(right);
				continue;
			}
			
			int times = 0;
			String repeats = null;
			StringBuilder repeatsBuilder = new StringBuilder();
			StringBuilder timesBuilder = new StringBuilder();
			
			while (!stack.isEmpty()) {																				// T : O(repeats)
				char left = stack.pop();
				if (left != '[') {
					repeatsBuilder.insert(0, left);
					continue;
				}
				break;
			}
			
			while (!stack.isEmpty()) {																				// T : O(digits)
				char left = stack.peek();
				if (Character.isDigit(left)) {
					timesBuilder.insert(0, stack.pop());
					continue;
				}
				break;
			}
			
			repeats = repeatsBuilder.toString();
			times = Integer.parseInt(timesBuilder.toString());
			
			for (int i = 1; i < times; i++) { repeatsBuilder.append(repeats); }										// T : O(10 ^ (digits - 1))
			repeats = repeatsBuilder.toString();
			
			for (char repeat : repeats.toCharArray()) { stack.push(repeat); }										// T : O(repeats * 10 ^ (digits - 1))
		}
		
		StringBuilder result = new StringBuilder();
		while (!stack.isEmpty()) { result.insert(0, stack.pop()); }													// T : O(result)
		return result.toString();
	}
	
	/**
	 * time :  O(Sum(times))
	 * space : O(n * times)
	 * 
	 * Queue<Character> queue <- new LinkedList
	 * 
	 * for character in input to char array
	 * 		queue offer(character)
	 * end for
	 * 
	 * return recursion(queue)
	 * */
	public String decodeString(String s) {
		Queue<Character> queue = new LinkedList<>();																// S : O(n)
		for (char c : s.toCharArray()) { queue.offer(c); }															// T : O(n)
		return recursion(queue);
	}
	
	/**
	 * int times <- 0
	 * StringBuilder result <- new StringBuilder
	 * 
	 * while queue is not empty
	 * 		char character <- queue poll
	 * 		if character is digit
	 * 			times <- (times multiply ten) plus (character minus '0')
	 * 		else if character is equal to '['
	 * 			String repeat <- recursion(queue)
	 * 			for int i <- 0; i is lower than times; i++
	 * 				result append(repeat)
	 * 			end for
	 * 			times <- 0
	 * 		else if character is equal to ']'
	 * 			break while
	 * 		else
	 * 			result append(character)
	 * 		end if
	 * end while
	 * 
	 * return result to string
	 * */
	public String recursion(Queue<Character> queue) {
		int times = 0;
		StringBuilder result = new StringBuilder();
		
		while (!queue.isEmpty()) {																					// T : O(n)
			char c = queue.poll();
			if (Character.isDigit(c)) {
				times = times * 10 + c - '0';
			} else if (c == '[') {
				String repeat = recursion(queue);
				for (int i = 0; i < times; i++) { result.append(repeat); }											// T : O(times)
				times = 0;
			} else if (c == ']') {
				break;
			} else {
				result.append(c);
			}
		}
		
		return result.toString();
	}
	
}
