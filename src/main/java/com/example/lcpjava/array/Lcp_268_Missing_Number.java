package com.example.lcpjava.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Lcp_268_Missing_Number {
	
	/**
	 * time  : O(n log n)
	 * space : O(1)
	 * */
	public int missingNumber_1(int[] nums) {
		Arrays.sort(nums);																							// T : O(n log n)
		
		int start = 0;
		int end = nums.length;
		
		while (start < end) {																						// T : O(log n)
			int missing = start + (end - start) / 2;
			int occupied = nums[missing];
			
			if (occupied > missing) {
				end = missing;
			} else {
				start = missing + 1;
			}
		}
		
		return start;
	}
	
	/**
	 * time  : O(n)
	 * space : O(n)
	 * */
	public int missingNumber_2(int[] nums) {
		Set<Integer> set = new HashSet<>();																			// S : O(n)
		
		for (int num : nums) { set.add(num); }																		// T : O(n)
		
		for (int i = 0; i <= nums.length; i++) {																	// T : O(n)
			if (!set.contains(i)) { return i; }
		}
		
		return -1;
	}
	
	/**
	 * time  : O(n)
	 * space : O(n)
	 * */
	public int missingNumber_3(int[] nums) {
		int length = nums.length;
		boolean[] memo = new boolean[length + 1];																	// S : O(n)
		
		for (int num : nums) { memo[num] = true; }																	// T : O(n)
		
		for (int i = 0; i <= length; i++) {																			// T : O(n)
			if (!memo[i]) { return i; }
		}
		
		return -1;
	}
	
	/**
	 * Follow up
	 * 
	 * T : O(n)
	 * S : O(1)
	 * */
	
	/**
	 * time  : O(n)
	 * space : O(1)
	 * 
	 * Math is the king!
	 * 
	 * Gauss
	 * 
	 * https://zh.wikipedia.org/wiki/%E7%AD%89%E5%B7%AE%E6%95%B0%E5%88%97
	 * */
	public int missingNumber_4(int[] nums) {
		int length = nums.length;
		int sum = ((1 + length) * length) / 2;
		
		for (int num : nums) { sum -= num; }																		// T : O(n)
		
		return sum;
	}
	
	/**
	 * time  : O(n)
	 * space : O(1)
	 * 
	 * number XOR number = zero
	 * zero XOR number = number
	 * 
	 * https://leetcode.com/problems/missing-number/discuss/69786/3-different-ideas%3A-XOR-SUM-Binary-Search.-Java-code
	 * */
	public int missingNumber(int[] nums) {
		int length = nums.length;
		int result = length;
		
		for (int i = 0; i < length; i++) { result = result ^ i ^ nums[i]; }											// T : O(n)
		
		return result;
	}
	
}
