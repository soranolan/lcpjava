package com.example.lcpjava.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lcp_967_Numbers_With_Same_Consecutive_Differences {
	
	/**
	 * time  : O(2 ^ n)
	 * space : O(2 ^ n)
	 * */
	public int[] numsSameConsecDiff_1(int n, int k) {
		// when k is zero, remove duplicate
		Set<Integer> set = new HashSet<>();
		StringBuilder sb = new StringBuilder();
		
		for (int firstDigit = 1; firstDigit <= 9; firstDigit++) {
			sb.append(firstDigit);
			
			backtrack(n - 1, k, firstDigit, sb, set);
			
			sb.setLength(0);
		}
		
		int index = 0;
		int[] result = new int[set.size()];
		for (int num : set) { result[index++] = num; }
		
		return result;
	}
	
	private void backtrack(int n, int k, int previousDigit, StringBuilder sb, Set<Integer> set) {
		if (n == 0) {
			set.add(Integer.parseInt(sb.toString()));
			return;
		}
		
		int sub = previousDigit - k;
		int add = previousDigit + k;
		
		if (sub >= 0) {
			sb.append(sub);
			backtrack(n - 1, k, sub, sb, set);
			sb.setLength(sb.length() - 1);
		}
		
		if (add <= 9) {
			sb.append(add);
			backtrack(n - 1, k, add, sb, set);
			sb.setLength(sb.length() - 1);
		}
	}
	
	/**
	 * time  : O(2 ^ n)
	 * space : O(2 ^ n)
	 * 
	 * https://leetcode.com/problems/numbers-with-same-consecutive-differences/discuss/211183/JavaC%2B%2BPython-Iterative-BFS-Solution
	 * */
	public int[] numsSameConsecDiff_2(int n, int k) {
		List<Integer> result = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
		
		for (int digitCount = 2; digitCount <= n; digitCount++) {
			List<Integer> temp = new ArrayList<>();
			
			for (int previousNumber : result) {
				int lastDigit = previousNumber % 10;
				
				if (lastDigit + k <= 9) { temp.add(previousNumber * 10 + lastDigit + k); }
				
				// when k is zero, remove duplicate
				if (k > 0 && lastDigit - k >= 0) { temp.add(previousNumber * 10 + lastDigit - k); }
			}
			
			result = temp;
		}
		
		return result.stream().mapToInt(Integer::intValue).toArray();
	}
	
	/**
	 * time  : O(2 ^ n)
	 * space : O(2 ^ n)
	 * 
	 * Accepted Solutions Runtime Distribution
	 * */
	public int[] numsSameConsecDiff(int n, int k) {
		List<Integer> bucket = new ArrayList<>();
		
		for (int firstDigit = 1; firstDigit <= 9; firstDigit++) { backtrack(n - 1, k, firstDigit, bucket); }
		
		int[] result = new int[bucket.size()];
		for (int i = 0; i < bucket.size(); i++) { result[i] = bucket.get(i); }
		
		return result;
	}
	
	private void backtrack(int n, int k, int previousNumber, List<Integer> bucket) {
		if (n == 0) {
			bucket.add(previousNumber);
			return;
		}
		
		int lastDigit = previousNumber % 10;
		
		if (lastDigit + k <= 9) { backtrack(n - 1, k, previousNumber * 10 + lastDigit + k, bucket); }
		
		// when k is zero, remove duplicate
		if (k > 0 && lastDigit - k >= 0) { backtrack(n - 1, k, previousNumber * 10 + lastDigit - k, bucket); }
	}
	
}
