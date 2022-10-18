package com.example.lcpjava.array;

import java.util.Deque;
import java.util.LinkedList;

public class Lcp_38_Count_and_Say {
	
	/**
	 * time  : O(n * m)
	 * space : O(n * m)
	 * */
	public String countAndSay_1(int n) {
		String target = "1";
		
		for (int i = 2; i <= n; i++) {																				// T : O(n - 1)
			Deque<int[]> deque = new LinkedList<>();																// S : O(m)
			
			countFreq(target, deque);																				// T : O(m - 1)
			
			target = formNewNum(deque);																				// T : O(m)
		}
		
		return target;
	}
	
	private void countFreq(String target, Deque<int[]> deque) {
		deque.offerLast(new int[] { target.charAt(0) - '0', 1 });
		
		for (int i = 1; i < target.length(); i++) {																	// T : O(m - 1)
			if (target.charAt(i) == target.charAt(i - 1)) {
				int[] freq = deque.pollLast();
				freq[1]++;
				deque.offerLast(freq);
			} else {
				deque.offerLast(new int[] { target.charAt(i) - '0', 1 });
			}
		}
	}
	
	private String formNewNum(Deque<int[]> deque) {
		StringBuilder sb = new StringBuilder();																		// S : O(m)
		
		while (!deque.isEmpty()) {																					// T : O(m)
			int[] freq = deque.pollFirst();
			sb.append(freq[1]);
			sb.append(freq[0]);
		}
		
		return sb.toString();
	}
	
	/**
	 * time  : O(n * m)
	 * space : O(n * m)
	 * 
	 * Accepted Solutions Runtime Distribution
	 * https://leetcode.com/problems/count-and-say/discuss/16040/Straightforward-Java-Solution
	 * */
	public String countAndSay(int n) {
		String target = "1";
		
		for (int i = 2; i <= n; i++) {																				// T : O(n - 1)
			target = countFreq(target);																				// T : O(m - 1)
		}
		
		return target;
	}
	
	private String countFreq(String target) {
		StringBuilder sb = new StringBuilder();																		// S : O(m)
		char previousChar = target.charAt(0);
		int freq = 1;
		
		for (int i = 1; i < target.length(); i++) {																	// T : O(m - 1)
			if (target.charAt(i) == previousChar) {
				freq++;
			} else {
				sb.append(freq);
				sb.append(previousChar);
				
				previousChar = target.charAt(i);
				
				freq = 1;
			}
		}
		
		// handle the last character
		sb.append(freq);
		sb.append(previousChar);
		
		return sb.toString();
	}
	
}
