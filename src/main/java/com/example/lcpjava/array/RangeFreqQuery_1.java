package com.example.lcpjava.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** Time Limit Exceeded */
public class RangeFreqQuery_1 {
	
	public Map<Integer, List<Integer>> memo;																		// S : O(n)
	
	/**
	 * time  : O(n)
	 * space : O(n)
	 * */
	public RangeFreqQuery_1(int[] arr) {
		memo = new HashMap<>();
		
		for (int i = 0; i < arr.length; i++) {																		// T : O(n)
			int number = arr[i];
			List<Integer> test = memo.getOrDefault(number, new ArrayList<>());										// T : O(1)
			test.add(i);
			memo.put(number, test);																					// T : O(1)
		}
	}
	
	/**
	 * time  : O(m)
	 * space : O(1)
	 * */
	public int query(int left, int right, int value) {
		if (!memo.containsKey(value)) { return 0; }																	// T : O(1)
		
		int freq = 0;
		List<Integer> indices = memo.get(value);																	// T : O(1)
		
		for (int indice : indices) {																				// T : O(m)
			if (indice < left || indice > right) { continue; }
			
			freq++;
		}
		
		return freq;
	}
	
}
