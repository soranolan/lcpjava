package com.example.lcpjava.array;

import java.util.Arrays;

public class Lcp_462_Minimum_Moves_to_Equal_Array_Elements_II {
	
	/**
	 * nums [ 1 0 0 8 6 ]
	 * 
	 * 0 [ 1 0 0 8 6 ] 15
	 * 1 [ 0 1 1 7 5 ] 14
	 * 2 [ 1 2 2 6 4 ] 15
	 * 3 [ 2 3 3 5 3 ] 16
	 * 4 [ 3 4 4 4 2 ] 17
	 * 5 [ 4 5 5 3 1 ] 18
	 */
	/**
	 * time  : O(n * (max - min))
	 * space : O(1)
	 * 
	 * Time Limit Exceeded
	 * */
	public int minMoves2_1(int[] nums) {
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		
		for (int num : nums) {																						// T : O(n)
			min = Math.min(min, num);
			max = Math.max(max, num);
		}
		
		int moves = Integer.MAX_VALUE;
		
		for (int i = min; i <= max; i++) {																			// T : O(max - min)
			int sub = 0;
			
			for (int num : nums) { sub += Math.abs(i - num); }														// T : O(n)
			
			moves = Math.min(moves, sub);
		}
		
		return moves;
	}
	
	/**
	 * time  : O(n log n)
	 * space : O(1)
	 * 
	 * with Median
	 * 
	 * https://leetcode.com/problems/minimum-moves-to-equal-array-elements-ii/discuss/1217473/C%2B%2BPythonJava-2-Solutions-(w-and-wo-Median)-Explained-with-Example-implementation
	 * https://leetcode.com/problems/minimum-moves-to-equal-array-elements-ii/discuss/1217378/Short-and-Easy-Solution-or-Meet-at-the-Median
	 * https://math.stackexchange.com/questions/113270/the-median-minimizes-the-sum-of-absolute-deviations-the-ell-1-norm
	 * https://leetcode.com/problems/minimum-moves-to-equal-array-elements-ii/discuss/94932/Why-median-is-better-than-average
	 * */
	public int minMoves2_2(int[] nums) {
		Arrays.sort(nums);																							// T : O(n log n)
		
		int moves = 0;
		int length = nums.length;
		int median = length / 2;
		
		for (int num : nums) { moves += Math.abs(num - nums[median]); }												// T : O(n)
		
		return moves;
	}
	
	/**
	 * time  : O(n log n)
	 * space : O(1)
	 * 
	 * without Median
	 * 
	 * https://leetcode.com/problems/minimum-moves-to-equal-array-elements-ii/discuss/94937/Java(just-like-meeting-point-problem)
	 * 
	 * nums[n] - target + nums[n - 1] - target + ... + (target - nums[mid - 1]) + (target - nums[mid - 2]) + ... + (target - nums[0])
	 * */
	public int minMoves2(int[] nums) {
		Arrays.sort(nums);																							// T : O(n log n)
		
		int moves = 0;
		int left = 0;
		int right = nums.length - 1;
		
		while (left < right) {																						// T : O(n)
			moves += (nums[right] - nums[left]);
			left++;
			right--;
		}
		
		return moves;
	}
	
	/**
	 * QuickSelect worst case is O(n ^ 2)
	 * 
	 * median of medians algorithm to make it O(n)
	 * 
	 * https://leetcode.com/problems/minimum-moves-to-equal-array-elements-ii/discuss/94917/Java-O(n)-Time-using-QuickSelect
	 * https://leetcode.com/problems/minimum-moves-to-equal-array-elements-ii/discuss/94937/Java(just-like-meeting-point-problem)
	 * https://leetcode.com/problems/minimum-moves-to-equal-array-elements-ii/discuss/2215782/Visual-Explanation-%2B-Interview-Tips-or-JAVA
	 * https://leetcode.com/problems/kth-largest-element-in-an-array/discuss/2180600/A-Guide-to-Quick-Select-or-JAVA
	 * */
	
}
