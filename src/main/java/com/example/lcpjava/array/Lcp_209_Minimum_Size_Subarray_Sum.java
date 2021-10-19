package com.example.lcpjava.array;

public class Lcp_209_Minimum_Size_Subarray_Sum {
	
	/**
	 * time  : O(n)
	 * space : O(1)
	 * 
	 * Sliding window
	 * 
	 * int windowLeft <- 0
	 * int windowRight <- 0
	 * int sum <- 0
	 * int min <- Integer max value
	 * 
	 * while windowRight is lower than array length
	 * 		sum <- sum plus array[windowRight]
	 * 		windowRight++
	 * 		
	 * 		while sum is greater than or equal to target
	 * 			min <- min compare with (windowRight minus windowLeft)
	 * 			sum <- sum minus array[windowLeft]
	 * 			windowLeft++
	 * 		end while
	 * end while
	 * 
	 * return if min is equal to Integer max value then zero else min
	 * */
	public int minSubArrayLen(int target, int[] nums) {
		int windowLeft = 0;
		int windowRight = 0;
		int sum = 0;
		int min = Integer.MAX_VALUE;
		
		while (windowRight < nums.length) {																			// T : O(n)
			sum += nums[windowRight];
			windowRight++;
			
			while (sum >= target) {																					// T : O(n)
				min = Math.min(min, windowRight - windowLeft);
				sum -= nums[windowLeft];
				windowLeft++;
			}
		}
		
		return min == Integer.MAX_VALUE ? 0 : min;
	}
	
	public static void main(String[] args) {
		Lcp_209_Minimum_Size_Subarray_Sum lcp = new Lcp_209_Minimum_Size_Subarray_Sum();
		int target = -1;
		int[] input = null;
		int output = -1;
		
		// 2
		target = 7;
		input = new int[] { 2, 3, 1, 2, 4, 3 };
		output = lcp.minSubArrayLen(target, input);
		System.out.println(output);
		
		// 1
		target = 4;
		input = new int[] { 1, 4, 4 };
		output = lcp.minSubArrayLen(target, input);
		System.out.println(output);
		
		// 0
		target = 11;
		input = new int[] { 1, 1, 1, 1, 1, 1, 1, 1 };
		output = lcp.minSubArrayLen(target, input);
		System.out.println(output);
		
		// 8
		target = 213;
		input = new int[] { 12, 28, 83, 4, 25, 26, 25, 2, 25, 25, 25, 12 };
		output = lcp.minSubArrayLen(target, input);
		System.out.println(output);
	}
	
}
