package com.example.lcpjava.array;

import java.util.ArrayList;
import java.util.List;

public class Lcp_1023_Camelcase_Matching {
	
	/**
	 * time  : O(n * m)
	 * space : O(1)
	 * 
	 * https://leetcode.com/problems/camelcase-matching/discuss/270029/JavaC%2B%2BPython-Check-Subsequence-and-Regax
	 * */
	public List<Boolean> camelMatch(String[] queries, String pattern) {
		List<Boolean> result = new ArrayList<>();
		
		for (String query : queries) {																				// T : O(n)
			result.add(isMatch(query, pattern));
		}
		
		return result;
	}
	
	private boolean isMatch(String query, String pattern) {
		int left = 0;
		
		for (int right = 0; right < query.length(); right++) {														// T : O(m)
			if (left < pattern.length() && query.charAt(right) == pattern.charAt(left)) {
				left++;
			} else if (query.charAt(right) < 'a') {
				// uppercase char which not match pattern
				return false;
			}
		}
		
		return left == pattern.length();
	}
	
}
