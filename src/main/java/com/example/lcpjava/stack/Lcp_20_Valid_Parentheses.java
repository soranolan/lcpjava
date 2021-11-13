package com.example.lcpjava.stack;

import java.util.Stack;

public class Lcp_20_Valid_Parentheses {
	
	/**
	 * time  : O(n)
	 * space : O(n)
	 * 
	 * Stack<Character> stack <- new Stack
	 * char[] parentheses <- s to char array
	 * 
	 * for char right in parentheses
	 * 		if stack is empty
	 * 			stack push(right)
	 * 			continue
	 * 		end if
	 * 		
	 * 		char left <- stack peek
	 * 		if left is equal to '{' && right is equal to '}'
	 * 			stack pop
	 * 		else if left is equal to '[' && right is equal to ']'
	 * 			stack pop
	 * 		else if left is equal to '(' && right is equal to ')'
	 * 			stack pop
	 * 		else
	 * 			stack push(right)
	 * 		end if
	 * end for
	 * 
	 * return stack is empty
	 * */
	public boolean isValid(String s) {
		Stack<Character> stack = new Stack<>();																		// S : O(n)
		char[] parentheses = s.toCharArray();
		
		for (char right : parentheses) {																			// T : O(n)
			if (stack.isEmpty()) {																					// T : O(1)
				stack.push(right);																					// T : O(1)
				continue;
			}
			
			char left = stack.peek();
			if (left == '{' && right == '}') {
				stack.pop();																						// T : O(1)
			} else if (left == '[' && right == ']') {
				stack.pop();																						// T : O(1)
			} else if (left == '(' && right == ')') {
				stack.pop();																						// T : O(1)
			} else {
				stack.push(right);																					// T : O(1)
			}
		}
		
		return stack.isEmpty();																						// T : O(1)
	}
	
}
