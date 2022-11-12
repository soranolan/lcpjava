package com.example.lcpjava.array;

import java.util.HashMap;
import java.util.Map;

public class Lcp_2260_Minimum_Consecutive_Cards_to_Pick_Up {
	
	/**
	 * time  : O(n)
	 * space : O(n)
	 * */
	public int minimumCardPickup_1(int[] cards) {
		int result = Integer.MAX_VALUE;
		Map<Integer, Integer> lastOccurrence = new HashMap<>();														// S : O(n)
		
		for (int i = 0; i < cards.length; i++) {																	// T : O(n)
			if (lastOccurrence.containsKey(cards[i])) {
				result = Math.min(i - lastOccurrence.get(cards[i]) + 1, result);
			}
			lastOccurrence.put(cards[i], i);
		}
		
		return result == Integer.MAX_VALUE ? -1 : result;
	}
	
	/**
	 * time  : O(n)
	 * space : O(max)
	 * 
	 * Accepted Solutions Runtime Distribution
	 * */
	public int minimumCardPickup(int[] cards) {
		int max = -1;
		for (int card : cards) { max = Math.max(max, card); }														// T : O(n)
		
		int result = Integer.MAX_VALUE;
		int[] lastOccurrence = new int[max + 1];																	// S : O(max + 1)
		
		for (int i = 0; i < cards.length; i++) {																	// T : (n)
			if (lastOccurrence[cards[i]] != 0) {
				result = Math.min(i - (lastOccurrence[cards[i]] - 1) + 1, result);
			}
			lastOccurrence[cards[i]] = i + 1;
		}
		
		return result == Integer.MAX_VALUE ? -1 : result;
	}
	
}
