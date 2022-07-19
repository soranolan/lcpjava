package com.example.lcpjava.array;

import java.util.Stack;

public class Lcp_2116_Check_if_a_Parentheses_String_Can_Be_Valid {
	
	/**
	 * time  : O(n)
	 * space : O(n)
	 * 
	 * https://leetcode.com/problems/check-if-a-parentheses-string-can-be-valid/discuss/2213128/JAVA-oror-EASY-TO-UNDERSTAND-oror-TWO-STACKS-oror-GREEDY
	 * */
	public boolean canBeValid(String s, String locked) {
		int length = s.length();																					// n
		if (length % 2 != 0) { return false; }
		
		Stack<Integer> flip = new Stack<>();																		// S : O(n)
		Stack<Integer> open = new Stack<>();																		// S : O(n)
		
		for (int i = 0; i < length; i++) {																			// T : O(n)
			if (locked.charAt(i) == '0') {
				flip.push(i);
			} else if (s.charAt(i) == '(') {
				open.push(i);
			} else if (s.charAt(i) == ')' && !open.isEmpty()) {
				open.pop();
			} else if (s.charAt(i) == ')' && !flip.isEmpty()) {
				flip.pop();
			} else {
				return false;
			}
		}
		
		while (!open.isEmpty() && !flip.isEmpty()) {																// T : O(n)
			if (open.peek() > flip.peek()) { return false; }
			open.pop();
			flip.pop();
		}
		
		if (!open.isEmpty()) { return false; }
		if (flip.size() % 2 != 0) { return false; }
		
		return true;
	}
	
	/**
	 * time  : O(n)
	 * space : O(1)
	 * 
	 * https://leetcode.com/problems/check-if-a-parentheses-string-can-be-valid/discuss/1646594/Left-to-right-and-right-to-left
	 * https://leetcode.com/problems/check-if-a-parentheses-string-can-be-valid/discuss/1650613/Intuition-Explained-oror-Balanced-Parentheses-Greedy-Approach-oror-C%2B%2B-Clean-Code
	 * */
	public boolean canBeValid_(String s, String locked) {
		int length = s.length();																					// n
		if (length % 2 != 0) { return false; }
		
		int open = 0;
		int flip = 0;
		
		for (int i = 0; i < length; i++) {																			// T : O(n)
			if (locked.charAt(i) == '0') {
				flip++;
			} else {
				if (s.charAt(i) == '(') {
					open++;
				} else {
					open--;
				}
			}
			if (flip + open < 0) { return false; }
		}
		
		int close = 0;
		flip = 0;
		
		for (int i = length - 1; i >= 0; i--) {																		// T : O(n)
			if (locked.charAt(i) == '0') {
				flip++;
			} else {
				if (s.charAt(i) == ')') {
					close++;
				} else {
					close--;
				}
			}
			if (flip + close < 0) { return false; }
		}
		
		return true;
	}
	
}
