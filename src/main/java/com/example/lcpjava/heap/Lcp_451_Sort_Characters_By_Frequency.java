package com.example.lcpjava.heap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class Lcp_451_Sort_Characters_By_Frequency {
	
	/**
	 * time  : O(n log n)
	 * space : O(n)
	 * */
	public String frequencySort_1(String s) {
		Map<Character, Integer> char2Frequency = new HashMap<>();													// S : O(n)
		for (char c : s.toCharArray()) { char2Frequency.put(c, char2Frequency.getOrDefault(c, 0) + 1); }			// T : O(n)
		
		Queue<Character> maxHeap = new PriorityQueue<>(
				(offer, previous) -> char2Frequency.get(previous) - char2Frequency.get(offer));						// S : O(n)
		for (char c : char2Frequency.keySet()) {																	// T : O(n)
			maxHeap.offer(c);																						// T : O(log n)
		}
		
		StringBuilder sb = new StringBuilder();																		// S : O(n)
		while (!maxHeap.isEmpty()) {																				// T : O(n)
			char c = maxHeap.poll();																				// T : O(log n)
			int count = char2Frequency.get(c);																		// T : O(1)
			
			for (int i = 0; i < count; i++) { sb.append(c); }
		}
		
		return sb.toString();
	}
	
	/**
	 * time  : O(n)
	 * space : O(n)
	 * */
	public String frequencySort_2(String s) {
		Map<Character, Integer> countMap = new HashMap<>();															// S : O(n)
		for (char c : s.toCharArray()) { countMap.put(c, countMap.getOrDefault(c, 0) + 1); }						// T : O(n)
		
		int size = s.length() + 1;
		List<List<Character>> buckets = new ArrayList<List<Character>>(size);										// S : O(n + 1)
		for (int i = 0; i < size; i++) { buckets.add(new ArrayList<>()); }											// T : O(n + 1)
		
		for (char c : countMap.keySet()) {																			// T : O(n)
			int count = countMap.get(c);																			// T : O(1)
			buckets.get(count).add(c);																				// T : O(1)
		}
		
		StringBuilder sb = new StringBuilder();
		for (int count = buckets.size() - 1; count >= 0; count--) {													// T : O(n)
			List<Character> bucket = buckets.get(count);															// T : O(1)
			if (bucket.size() == 0) { continue; }
			
			Iterator<Character> it = bucket.iterator();
			while (it.hasNext()) {
				char c = it.next();
				for (int i = 0; i < count; i++) { sb.append(c); }
			}
		}
		
		return sb.toString();
	}
	
	/**
	 * time  : O(n)
	 * space : O(n)
	 * */
	public String frequencySort_3(String s) {
		int n = s.length();
		char[] result = new char[n];																				// S : O(n)
		
		int[] bucket = new int[128];																				// S : O(128)
		for (char c : s.toCharArray()) { bucket[c]++; }																// T : O(n)
		
		int index = 0;
		while (index < n) {																							// T : O(n)
			int maxCount = 0;
			char c = ' ';																							// 32
			
			for (int i = 0; i < 128; i++) {																			// T : O(128)
				if (maxCount < bucket[i]) {
					maxCount = bucket[i];
					c = (char) i;
				}
			}
			
			if (maxCount == 0) { return String.valueOf(result); }
			
			for (int count = 0; count < maxCount; count++) { result[index++] = c; }									// T : O(m)
			
			bucket[c] = 0;
		}
		
		return String.valueOf(result);
	}
	
	/**
	 * time  : O(n)
	 * space : O(n)
	 * 
	 * Accepted Solutions Runtime Distribution
	 * */
	public String frequencySort(String s) {
		int n = s.length();
		
		int[] bucket = new int[128];																				// S : O(128)
		for (char c : s.toCharArray()) { bucket[c]++; }																// T : O(n)
		
		StringBuilder sb = new StringBuilder();																		// S : O(n)
		
		while (sb.length() != n) {																					// T : O(n)
			int maxCount = 0;
			char c = ' ';																							// 32
			
			for (int i = 0; i < 128; i++) {																			// T : O(128)
				if (maxCount < bucket[i]) {
					maxCount = bucket[i];
					c = (char) i;
				}
			}
			
			if (maxCount == 0) { return sb.toString(); }
			
			sb.append(String.valueOf(c).repeat(maxCount));															// T : O(m)
			
			bucket[c] = 0;
		}
		
		return sb.toString();
	}
	
}
