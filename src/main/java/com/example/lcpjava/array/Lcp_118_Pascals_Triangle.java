package com.example.lcpjava.array;

import java.util.ArrayList;
import java.util.List;

public class Lcp_118_Pascals_Triangle {
	
	/**
	 * time  : O(n ^ 2)
	 * space : O(n ^ 2)
	 * */
	public List<List<Integer>> generate_1(int numRows) {
		List<List<Integer>> outer = new ArrayList<>();
		List<Integer> inner = new ArrayList<>();
		
		for (int i = 0; i < numRows; i++) {
			for (int j = inner.size() - 1; j > 0; j--) {
				inner.set(j, inner.get(j) + inner.get(j - 1));														// T : O(1)
			}
			inner.add(1);																							// T : O(α(n))
			List<Integer> clone = new ArrayList<>(inner);
			outer.add(clone);																						// T : O(α(n))
		}
		
		return outer;
	}
	
	/**
	 * time  : O(n ^ 2)
	 * space : O(n ^ 2)
	 * 
	 * https://stackoverflow.com/questions/32498653/what-would-be-the-time-complexity-of-the-pascal-triangle-algorithm
	 * */
	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> result = new ArrayList<>();
		
		List<Integer> first = new ArrayList<>();
		first.add(1);																								// T : O(α(n))
		
		result.add(first);																							// T : O(α(n))
		
		for (int i = 1; i < numRows; i++) {
			List<Integer> previous = result.get(i - 1);																// T : O(1)
			List<Integer> current = new ArrayList<>();
			
			current.add(1);																							// T : O(α(n))
			
			for (int j = 1; j < previous.size(); j++) {
				current.add(previous.get(j - 1) + previous.get(j));													// T : O(α(n))
			}
			
			current.add(1);																							// T : O(α(n))
			
			result.add(current);																					// T : O(α(n))
		}
		
		return result;
	}
	
}
