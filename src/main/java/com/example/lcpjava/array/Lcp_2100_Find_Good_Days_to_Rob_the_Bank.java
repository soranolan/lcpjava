package com.example.lcpjava.array;

import java.util.ArrayList;
import java.util.List;

public class Lcp_2100_Find_Good_Days_to_Rob_the_Bank {
	
	/**
	 * time  : O(n)
	 * space : O(n)
	 * */
	public List<Integer> goodDaysToRobBank(int[] security, int time) {
		List<Integer> result = new ArrayList<>();
		int n = security.length;
		
		if (time > n / 2) { return result; }
		
		if (time == 0) {
			for (int i = 0; i < n; i++) { result.add(i); }															// T : O(n)
			return result;
		}
		
		// Accepted Solutions Runtime Distribution
		if (time == 1) {
			for (int i = 1; i < n - 1; i++) {																		// T : O(n - 2)
				if (security[i - 1] >= security[i] && security[i] <= security[i + 1]) { result.add(i); }
			}
			return result;
		}
		
		int[] nonIncrease = new int[n];																				// S : O(n)
		int[] nonDecrease = new int[n];																				// S : O(n)
		
		for (int i = 1; i < n - time; i++) {																		// T : O(n - 1 - time)
			if (security[i - 1] >= security[i]) { nonIncrease[i] = nonIncrease[i - 1] + 1; }
		}
		
		for (int i = n - 2; i >= time; i--) {																		// T : O(n - 1 - time)
			if (security[i] <= security[i + 1]) { nonDecrease[i] = nonDecrease[i + 1] + 1; }
		}
		
		for (int i = time; i < n - time; i++) {																		// T : O(n - time * 2)
			if (nonIncrease[i] >= time && nonDecrease[i] >= time) { result.add(i); }
		}
		
		return result;
	}
	
}
