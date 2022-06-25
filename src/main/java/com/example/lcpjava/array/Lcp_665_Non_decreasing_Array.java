package com.example.lcpjava.array;

public class Lcp_665_Non_decreasing_Array {
	
	/**
	 * time  : O(n)
	 * space : O(1)
	 * 
	 * https://leetcode.com/problems/non-decreasing-array/discuss/1190763/JS-Python-Java-C%2B%2B-or-Simple-Solution-w-Visual-Explanation
	 * 
	 * 
	 *   A
	 *  / \
	 * Y   \   Y
	 *      \ /
	 *       B
	 * */
	public boolean checkPossibility(int[] nums) {
		int count = 0;
		
		for (int i = 1; i < nums.length; i++) {																		// T : O(n)
			if (nums[i - 1] > nums[i]) {
				// second decreasing
				if (count > 0) { return false; }
				
				// failing scenario YABY
				if (i > 1 && i < nums.length - 1 && nums[i - 2] > nums[i] && nums[i - 1] > nums[i + 1]) { return false; }
				
				count++;
			}
		}
		
		return true;
	}
	
}
