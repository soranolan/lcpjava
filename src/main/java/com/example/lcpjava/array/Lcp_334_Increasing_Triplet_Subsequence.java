package com.example.lcpjava.array;

public class Lcp_334_Increasing_Triplet_Subsequence {
	
	/**
	 * time  : O(n ^ 3)
	 * space : O(1)
	 * */
	public boolean increasingTriplet_1(int[] nums) {
		int n = nums.length;
		if (n < 3) { return false; }
		
		for (int i = 0; i < n - 2; i++) {																			// T : O(n - 2)
			for (int j = i + 1; j < n - 1; j++) {																	// T : O(n - 2)
				for (int k = j + 1; k < n; k++) {																	// T : O(n - 2)
					if (nums[i] < nums[j] && nums[j] < nums[k]) {
						return true;
					}
				}
			}
		}
		
		return false;
	}
	
	/**
	 * time  : O(n)
	 * space : O(n)
	 * 
	 * https://leetcode.com/problems/increasing-triplet-subsequence/discuss/270884/Python-2-solutions%3A-Right-So-Far-One-pass-O(1)-Space-Clean-and-Concise
	 * */
	public boolean increasingTriplet_2(int[] nums) {
		int n = nums.length;
		if (n < 3) { return false; }
		
		int[] leftMin = new int[n];																					// S : O(n)
		leftMin[0] = nums[0];
		for (int i = 1; i < n; i++) { leftMin[i] = Math.min(leftMin[i - 1], nums[i]); }								// T : O(n - 1)
		
		int[] rightMax = new int[n];																				// S : O(n)
		rightMax[n - 1] = nums[n - 1];
		for (int i = n - 2; i >= 0; i--) { rightMax[i] = Math.max(rightMax[i + 1], nums[i]); }						// T : O(n - 1)
		
		for (int i = 1; i < n - 1; i++) {																			// T : O(n - 2)
			if (leftMin[i - 1] < nums[i] && nums[i] < rightMax[i + 1]) { return true; }
		}
		
		return false;
	}
	
	/**
	 * Follow up:
	 * 
	 * Could you implement a solution that runs in O(n) time complexity and O(1) space complexity?
	 * */
	
	/**
	 * time  : O(n)
	 * space : O(1)
	 * 
	 * https://leetcode.com/problems/increasing-triplet-subsequence/discuss/79004/Concise-Java-solution-with-comments.
	 * */
	public boolean increasingTriplet(int[] nums) {
		if (nums.length < 3) { return false; }
		
		int i = Integer.MAX_VALUE;
		int j = Integer.MAX_VALUE;
		
		for (int k : nums) {																						// T : O(n)
			if (k <= i) {
				i = k;
			} else if (k <= j) {
				j = k;
			} else {
				return true;
			}
		}
		
		return false;
	}
	
}
