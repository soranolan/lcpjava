package com.example.lcpjava.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lcp_2007_Find_Original_Array_From_Doubled_Array {
	
	/**
	 * time  : O(n log n)
	 * space : O(k)
	 * 
	 * https://leetcode.com/problems/find-original-array-from-doubled-array/discuss/2578114/Short-oror-C%2B%2B-oror-Java-oror-PYTHON-oror-Explained-Solution-oror-Beginner-Friendly-oror-BY-MR-CODER
	 * */
	public int[] findOriginalArray_1(int[] changed) {
		int n = changed.length;
		if (n % 2 != 0) { return new int[0]; }
		
		Arrays.sort(changed);																						// T : O(n log n)
		
		Map<Integer, Integer> number2Frequency = new HashMap<>();													// S : O(k * 2)
		for (int num : changed) { number2Frequency.put(num, number2Frequency.getOrDefault(num, 0) + 1); }			// T : O(n)
		
		int index = 0;
		int[] result = new int[n / 2];
		
		for (int num : changed) {																					// T : O(n)
			if (number2Frequency.get(num) == 0) { continue; }
			
			int doubled = num * 2;
			
			if (number2Frequency.getOrDefault(doubled, 0) <= 0) { return new int[0]; }
			
			number2Frequency.put(num, number2Frequency.get(num) - 1);
			number2Frequency.put(doubled, number2Frequency.get(doubled) - 1);
			result[index++] = num;
		}
		
		return result;
	}
	
	/**
	 * time  : O(n + k log k)
	 * space : O(k)
	 * 
	 * https://leetcode.com/problems/find-original-array-from-doubled-array/discuss/1470959/JavaC++Python-Match-from-the-Smallest-or-Biggest-100/1110603
	 * */
	public int[] findOriginalArray_2(int[] changed) {
		int n = changed.length;
		if (n % 2 != 0) { return new int[0]; }
		
		Map<Integer, Integer> number2Frequency = new HashMap<>();													// S : O(k * 2)
		for (int num : changed) { number2Frequency.put(num, number2Frequency.getOrDefault(num, 0) + 1); }			// T : O(n)
		
		List<Integer> keys = new ArrayList<>(number2Frequency.keySet());											// S : O(k)
		Collections.sort(keys);																						// T : O(k log k)
		
		int index = 0;
		int[] result = new int[n / 2];
		
		for (int key : keys) {																						// T : O(k)
			int doubled = key * 2;
			if (number2Frequency.get(key) > number2Frequency.getOrDefault(doubled, 0)) { return new int[0]; }
			
			for (int i = 0; i < number2Frequency.get(key); i++) {
				result[index++] = key;
				number2Frequency.put(doubled, number2Frequency.get(doubled) - 1);
			}
		}
		
		return result;
	}
	
	/**
	 * time  : O(n + max)
	 * space : O(max)
	 * 
	 * Accepted Solutions Runtime Distribution
	 * */
	public int[] findOriginalArray(int[] changed) {
		int n = changed.length;
		if (n % 2 != 0) { return new int[0]; }
		
		int max = -1;
		for (int num : changed) { max = Math.max(max, num); }														// T : O(n)
		
		int[] bucket = new int[max + 1];																			// S : O(max + 1)
		for (int num : changed) { bucket[num]++; }																	// T : O(n)
		
		int index = 0;
		int[] result = new int[n / 2];
		
		for (int original = 0; original <= max; original++) {														// T : O(max + 1)
			if (bucket[original] <= 0) { continue; }
			
			int doubled = original * 2;
			if (doubled > max || bucket[doubled] <= 0) { return new int[0]; }
			
			bucket[original]--;
			bucket[doubled]--;
			result[index++] = original;
			
			// revisit same original value, and check again
			original--;
		}
		
		return result;
	}
	
}
