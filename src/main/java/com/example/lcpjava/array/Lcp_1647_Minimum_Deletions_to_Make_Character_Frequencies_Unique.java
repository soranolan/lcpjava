package com.example.lcpjava.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class Lcp_1647_Minimum_Deletions_to_Make_Character_Frequencies_Unique {
	
	/**
	 * time  : O(n + k ^ 2 * log k)
	 * space : O(k)
	 * */
	public int minDeletions_1(String s) {
		int deletions = 0;
		
		int[] frequency = new int[26];																				// S : O(26)
		for (int i = 0; i < s.length(); i++) { frequency[s.charAt(i) - 'a']++; }									// T : O(n)
		
		Queue<Integer> maxHeap = new PriorityQueue<>((offer, previous) -> previous - offer);						// S : O(k)
		for (int i = 0; i < 26; i++) {																				// T : O(26)
			if (frequency[i] > 0) { maxHeap.offer(frequency[i]); }
		}
		
		while (maxHeap.size() > 1) {																				// T : O(k ^ 2)
			int head = maxHeap.poll();																				// T : O(log k)
			if (head == maxHeap.peek()) {																			// T : O(1)
				if (head - 1 > 0) { maxHeap.offer(head - 1); }														// T : O(log k)
				deletions++;
			}
		}
		
		return deletions;
	}
	
	/**
	 * time  : O(n + k ^ 2)
	 * space : O(k)
	 * */
	public int minDeletions_2(String s) {
		int deletions = 0;
		
		int[] frequency = new int[26];																				// S : O(26)
		for (int i = 0; i < s.length(); i++) { frequency[s.charAt(i) - 'a']++; }									// T : O(n)
		
		Set<Integer> seen = new HashSet<>();																		// S : O(k)
		for (int i = 0; i < 26; i++) {																				// T : O(k ^ 2)
			while (frequency[i] > 0 && seen.contains(frequency[i])) {
				frequency[i]--;
				deletions++;
			}
			
			seen.add(frequency[i]);
		}
		
		return deletions;
	}
	
	/**
	 * time  : O(n + k log k)
	 * space : O(k)
	 * */
	public int minDeletions(String s) {
		int deletions = 0;
		
		int[] frequency = new int[26];																				// S : O(26)
		for (int i = 0; i < s.length(); i++) { frequency[s.charAt(i) - 'a']++; }									// T : O(n)
		
		Arrays.sort(frequency);																						// T : O(k log k)
		
		int max = s.length();
		
		for (int i = 25; i >= 0; i--) {																				// T : O(26)
			if (frequency[i] <= 0) { continue; }
			
			if (frequency[i] > max) {
				deletions += frequency[i] - max;
				frequency[i] = max;
			}
			
			max = Math.max(0, frequency[i] - 1);
		}
		
		return deletions;
	}
	
}
