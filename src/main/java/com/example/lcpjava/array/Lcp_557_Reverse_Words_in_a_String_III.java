package com.example.lcpjava.array;

import java.util.Stack;

public class Lcp_557_Reverse_Words_in_a_String_III {
	
	/**
	 * time  : O(n)
	 * space : O(n)
	 * */
	public String reverseWords_1(String s) {
		StringBuilder sb = new StringBuilder();																		// S : O(n)
		Stack<Character> stack = new Stack<>();																		// S : O(n)
		
		for (char c : s.toCharArray()) {																			// T : O(n)
			if (c != ' ') {
				stack.push(c);																						// T : O(1)
			} else {
				while (!stack.isEmpty()) {																			// T : O(n - space)
					sb.append(stack.pop());																			// T : O(1)
				}
				sb.append(" ");																						// T : O(1)
			}
		}
		
		while (!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		
		return sb.toString();
	}
	
	/**
	 * time  : O(n)
	 * space : O(n)
	 * 
	 * Solution Tab
	 * */
	public String reverseWords(String s) {
		char[] c = s.toCharArray();																					// S : O(n)
		int length = s.length();
		int left = 0;
		
		for (int current = 0; current < length; current++) {														// T : O(n)
			if (c[current] != ' ') { continue; }
			
			int right = current - 1;
			
			reverse(c, left, right);																				// T : O(n / 2)
			
			left = current + 1;
		}
		
		reverse(c, left, length - 1);
		
		return new String(c);																						// S : O(n)
	}
	
	private void reverse(char[] c, int left, int right) {
		while (left < right) {
			char temp = c[left];
			c[left] = c[right];
			c[right] = temp;
			
			left++;
			right--;
		}
	}
	
}
