package com.example.lcpjava.stack;

import java.util.Stack;

public class Lcp_1544_Make_The_String_Great {
	
	/**
	 * time  : O(n)
	 * space : O(n)
	 * 
	 * Stack<Character> stack <- new Stack
	 * 
	 * for char current in s to char array
	 * 		if stack is not empty && Math abs(current minus stack peek) is equal to 32
	 * 			stack pop
	 * 		else
	 * 			stack push(current)
	 * 		end if
	 * end for
	 * 
	 * StringBuilder sb <- new StringBuilder
	 * 
	 * for char c in stack
	 * 		sb append(c)
	 * end for
	 * 
	 * return sb to string
	 * */
	public String makeGood_1(String s) {
		Stack<Character> stack = new Stack<>();																		// S : O(n)
		
		for (char current : s.toCharArray()) {																		// T : O(n)
			if (!stack.isEmpty() && Math.abs(current - stack.peek()) == 32) {										// T : O(1)
				stack.pop();																						// T : O(1)
			} else {
				stack.push(current);																				// T : O(1)
			}
		}
		
		StringBuilder sb = new StringBuilder();																		// S : O(n)
		
		for (char c : stack) { sb.append(c); }																		// T : O(n)
		
		return sb.toString();
	}
	
	/**
	 * time  : O(n)
	 * space : O(n)
	 * 
	 * int index <- zero
	 * char[] array <- s to char array
	 * 
	 * for char c in array
	 * 		if index is greater than zero && Math abs(array[index minus one] minus c is equal to 32
	 * 			index--
	 * 		else
	 * 			array[index] <- c
	 * 			index++
	 * 		end if
	 * end for
	 * 
	 * return new String(array, zero, index)
	 * */
	public String makeGood(String s) {
		int index = 0;
		char[] arr = s.toCharArray();																				// S : O(n)
		
		for (char c : arr) {																						// T : O(n)
			if (index > 0 && Math.abs(arr[index - 1] - c) == 32) {
				index--;
			} else {
				arr[index] = c;
				index++;
			}
		}
		
		return new String(arr, 0, index);
	}
	
}
