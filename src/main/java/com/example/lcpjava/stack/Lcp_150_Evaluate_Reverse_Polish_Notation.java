package com.example.lcpjava.stack;

import java.util.Stack;

public class Lcp_150_Evaluate_Reverse_Polish_Notation {
	
	/**
	 * time  : O(n)
	 * space : O(n)
	 * */
	public int evalRPN_1(String[] tokens) {
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
	
	/**
	 * time  : O(n)
	 * space : O(n)
	 * 
	 * Accepted Solutions Runtime Distribution
	 * */
	public int evalRPN(String[] tokens) {
		int n = tokens.length;
		int[] nextPosition = new int[1];
		return eval(tokens, n - 1, nextPosition);
	}
	
	private int eval(String[] tokens, int currentPosition, int[] nextPosition) {
		String token = tokens[currentPosition];
		char operand = token.charAt(0);
		
		if (token.length() == 1 && (operand == '+' || operand == '-' || operand == '*' || operand == '/')) {
			int right = eval(tokens, currentPosition - 1, nextPosition);
			int left = eval(tokens, nextPosition[0], nextPosition);
			
			if (operand == '+') {
				return left + right;
			} else if (operand == '-') {
				return left - right;
			} else if (operand == '*') {
				return left * right;
			} else {
				return left / right;
			}
		} else {
			nextPosition[0] = currentPosition - 1;
			return Integer.parseInt(token);
		}
	}
	
}
