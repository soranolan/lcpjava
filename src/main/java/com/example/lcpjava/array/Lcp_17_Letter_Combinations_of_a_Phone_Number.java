package com.example.lcpjava.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Lcp_17_Letter_Combinations_of_a_Phone_Number {
	
	/**
	 * time  : O(4 ^ n * n)
	 * space : O(n)
	 * 
	 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/discuss/1148252/Short-and-Easy-Solutions-or-Multiple-Approaches-Explained-or-Beats-100
	 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/discuss/1653877/Java-Backtracking-and-Hashmap
	 * 
	 * 
	 * List<String> combinations <- new ArrayList
	 * 
	 * if digits is equal to null || digits length is equal to zero
	 * 		return combinations
	 * end if
	 * 
	 * Map<Character, String[]> mapping <- new HashMap
	 * 
	 * StringBuilder sb <- new StringBuilder
	 * 
	 * recursive(zero, digits, mapping, sb, combinations)
	 * 
	 * return combinations
	 * */
	public List<String> letterCombinations_1(String digits) {
		List<String> combinations = new ArrayList<>();
		if (digits == null || digits.length() == 0) { return combinations; }
		
		Map<Character, String[]> mapping = new HashMap<>();															// S : O(35)
		mapping.put('2', new String[] { "a", "b", "c" });
		mapping.put('3', new String[] { "d", "e", "f" });
		mapping.put('4', new String[] { "g", "h", "i" });
		mapping.put('5', new String[] { "j", "k", "l" });
		mapping.put('6', new String[] { "m", "n", "o" });
		mapping.put('7', new String[] { "p", "q", "r", "s" });
		mapping.put('8', new String[] { "t", "u", "v" });
		mapping.put('9', new String[] { "w", "x", "y", "z" });
		
		StringBuilder sb = new StringBuilder();
		recursive(0, digits, mapping, sb, combinations);
		return combinations;
	}
	
	/**
	 * if index is equal to digits length
	 * 		combinations add(sb to string)
	 * 		return
	 * end if
	 * 
	 * for String option in mapping get(digits charAt(index))
	 * 		sb append(option)
	 * 		
	 * 		recursive(index plus one, digits, mapping, sb, combinations)
	 * 		
	 * 		sb deleteCharAt(index)
	 * end for
	 * */
	private void recursive(int index, String digits, Map<Character, String[]> mapping, StringBuilder sb, List<String> combinations) {
		if (index == digits.length()) {
			combinations.add(sb.toString());
			return;
		}
		for (String option : mapping.get(digits.charAt(index))) {
			sb.append(option);
			recursive(index + 1, digits, mapping, sb, combinations);
			
			// backtrack, for next round, we need to delete what we just append
			sb.deleteCharAt(index);
		}
	}
	
	/**
	 * time  : O(4 ^ n * n)
	 * space : O(4 ^ n * n)
	 * 
	 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/discuss/8064/My-java-solution-with-FIFO-queue
	 * 
	 * 
	 * List<String> combinations <- new ArrayList
	 * 
	 * if digits is equal to null || digits length is equal to zero
	 * 		return combinations
	 * end if
	 * 
	 * String[] mapping
	 * Queue<String> queue <- new LinkedList
	 * queue offer(empty string)
	 * 
	 * while queue is not empty && queue peek length is not equal to digits length
	 * 		String candidate <- queue poll
	 * 		String options <- mapping[digits charAt(candidate length) minus char two
	 * 		
	 * 		for char option in options to char array
	 * 			StringBuilder sb <- new StringBuilder(candidate)
	 * 			sb append(option)
	 * 			queue offer(sb to string)
	 * 		end for
	 * end while
	 * 
	 * combinations addAll(queue)
	 * 
	 * return combinations
	 * */
	public List<String> letterCombinations_2(String digits) {
		List<String> combinations = new ArrayList<>();
		if (digits == null || digits.length() == 0) { return combinations; }
		
		String[] mapping = { "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };							// S : O(26)
		Queue<String> queue = new LinkedList<>();																	// S : O(4 ^ n * n)
		queue.offer("");																							// T : O(1)
		
		while (!queue.isEmpty() && queue.peek().length() != digits.length()) {										// T : O(4 ^ n * n)
			String candidate = queue.poll();																		// T : O(1)
			String options = mapping[digits.charAt(candidate.length()) - '2'];
			
			for (char option : options.toCharArray()) {
				StringBuilder sb = new StringBuilder(candidate);
				sb.append(option);																					// T : O(1)
				queue.offer(sb.toString());																			// T : O(1)
			}
		}
		
		combinations.addAll(queue);																					// T : O(4 ^ n * n)
		
		return combinations;
	}
	
	/**
	 * time  : O(4 ^ n * n)
	 * space : O(n)
	 * 
	 * List<String> combinations <- new ArrayList
	 * 
	 * if digits is equal to null || digits length is equal to zero
	 * 		return combinations
	 * end if
	 * 
	 * String[] mapping
	 * 
	 * StringBuilder sb <- new StringBuilder
	 * 
	 * recursive(zero, digits, mapping, sb, combinations)
	 * 
	 * return combinations
	 * */
	public List<String> letterCombinations(String digits) {
		List<String> combinations = new ArrayList<>();
		if (digits == null || digits.length() == 0) { return combinations; }
		
		String[] mapping = { "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };							// S : O(26)
		
		StringBuilder sb = new StringBuilder();
		recursive(0, digits, mapping, sb, combinations);
		return combinations;
	}
	
	/**
	 * if index is equal to digits length
	 * 		combinations add(sb to string)
	 * 		return
	 * end if
	 * 
	 * String options <- mapping[digits charAt(index) minus char two
	 * 
	 * for int i <- 0; if i is lower than options length; i++
	 * 		sb append(options charAt(i))
	 * 		
	 * 		recursive(index plus one, digits, mapping, sb, combinations)
	 * 		
	 * 		sb deleteCharAt(index)
	 * end for
	 * */
	private void recursive(int index, String digits, String[] mapping, StringBuilder sb, List<String> combinations) {
		if (index == digits.length()) {
			combinations.add(sb.toString());
			return;
		}
		String options = mapping[digits.charAt(index) - '2'];
		for (int i = 0; i < options.length(); i++) {
			sb.append(options.charAt(i));
			recursive(index + 1, digits, mapping, sb, combinations);
			
			// backtrack, for next round, we need to delete what we just append
			sb.deleteCharAt(index);
		}
	}
	
}
