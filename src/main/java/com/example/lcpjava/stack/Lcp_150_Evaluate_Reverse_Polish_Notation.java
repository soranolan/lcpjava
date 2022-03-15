package com.example.lcpjava.stack;

import java.util.Stack;

public class Lcp_150_Evaluate_Reverse_Polish_Notation {
	
	/**
	 * time  : O(n)
	 * space : O(n)
	 * 
	 * Stack<Integer> stack <- new Stack
	 * 
	 * for token in array
	 * 		switch token
	 * 			case "+"
	 * 				stack push(stack pop plus stack pop)
	 * 				break
	 * 			case "-"
	 * 				stack push(minus one times stack pop plus stack pop)
	 * 				break
	 * 			case "*"
	 * 				stack push(stack pop times stack pop)
	 * 				break
	 * 			case "/"
	 * 				int second <- stack pop
	 * 				int first <- stack pop
	 * 				stack push(first divided by second)
	 * 				break
	 * 			default
	 * 				stack push(token to Integer)
	 * 				break
	 * 		end switch
	 * end for
	 * 
	 * return stack peek
	 * */
	public int evalRPN(String[] tokens) {
		Stack<Integer> stack = new Stack<>();																		// S : O(n)
		
		for (String token : tokens) {																				// T : O(n)
			switch (token) {
				case "+" :
					stack.push(stack.pop() + stack.pop());
					break;
				case "-" :
					stack.push(-1 * stack.pop() + stack.pop());
					break;
				case "*" :
					stack.push(stack.pop() * stack.pop());
					break;
				case "/" :
					int second = stack.pop();
					int first = stack.pop();
					stack.push(first / second);
					break;
				default :
					stack.push(Integer.parseInt(token));
					break;
			}
		}
		
		return stack.peek();
	}
	
}
