package com.example.lcpjava.array;

import java.util.Arrays;

public class Lcp_910_Smallest_Range_II {
	
	/**
	 * time  : O(n log n)
	 * space : O(1)
	 * 
	 * Accepted Solutions Runtime Distribution
	 * 
	 * https://leetcode.com/problems/smallest-range-ii/discuss/1968052/Java-oror-TC-O(n)-oror-100-faster
	 * 
	 * 1 2 3 4 5 6 7 8 9
	 * + + + - - - - - -
	 * The maximum = Math.max(lmax + k, rmax - k)
	 * The minimum = Math.min(lmin + k, rmin - k)
	 * 
	 *     m
	 * 1 3 6
	 * + + -
	 * 
	 * 3+3, 6-3 = 6
	 * 0+3, 6-3 = 3
	 * */
	public int smallestRangeII(int[] nums, int k) {
		Arrays.sort(nums);																							// T : O(n log n)
		
		int length = nums.length;																					// n
		int max = nums[length - 1];
		int min = nums[0];
		int rightMax = max;
		int leftMin = min;
		int score = max - min;
		
		for (int mid = 1; mid < length; mid++) {																	// T : O(n - 1)
			int leftMax = nums[mid - 1];
			int rightMin = nums[mid];
			
			max = Math.max(leftMax + k, rightMax - k);
			min = Math.min(leftMin + k, rightMin - k);
			
			score = Math.min(score, max - min);
		}
		
		return score;
	}
	
}
