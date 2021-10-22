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
	
}
