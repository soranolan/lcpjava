package com.example.lcpjava.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** Time Limit Exceeded */
public class RangeFreqQuery_1 {
	
	public Map<Integer, List<Integer>> memo;
	
	public RangeFreqQuery_1(int[] arr) {
		memo = new HashMap<>();
		
		for (int i = 0; i < arr.length; i++) {
			int number = arr[i];
			List<Integer> test = memo.getOrDefault(number, new ArrayList<>());
			test.add(i);
			memo.put(number, test);
		}
	}
	
	public int query(int left, int right, int value) {
		if (!memo.containsKey(value)) { return 0; }
		
		int freq = 0;
		List<Integer> indices = memo.get(value);
		
		for (int indice : indices) {
			if (indice < left || indice > right) { continue; }
			
			freq++;
		}
		
		return freq;
	}
	
}
