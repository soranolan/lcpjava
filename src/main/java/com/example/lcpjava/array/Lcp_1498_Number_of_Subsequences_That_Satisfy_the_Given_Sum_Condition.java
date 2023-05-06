package com.example.lcpjava.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lcp_1498_Number_of_Subsequences_That_Satisfy_the_Given_Sum_Condition {
	
	/**
	 * time  : O(n!)
	 * space : O(n!)
	 * 
	 * Time Limit Exceeded
	 * 
	 * https://leetcode.com/problems/number-of-subsequences-that-satisfy-the-given-sum-condition/solutions/754981/from-brute-force-backtracking-to-efficient-two-pointer-solution/
	 * */
	public int numSubseq_1(int[] nums, int target) {
		Arrays.sort(nums);
		
		List<Integer> bucket = new ArrayList<>();
		
		long[] count = new long[1];
		
		backtrack(0, nums, bucket, target, count);
		
		return (int) (count[0] % 1000000007);
	}
	
	private void backtrack(int start, int[] nums, List<Integer> bucket, int target, long[] count) {
		int n = nums.length;
		
		if (bucket.size() > 0) {
			if (bucket.get(0) + bucket.get(bucket.size() - 1) <= target) {
				count[0]++;
			}
		}
		
		for (int i = start; i < n; i++) {
			bucket.add(nums[i]);
			backtrack(i + 1, nums, bucket, target, count);
			bucket.remove(bucket.size() - 1);
		}
	}
	
	/**
	 * time  : O(n log n)
	 * space : O(1)
	 * 
	 * https://leetcode.com/problems/number-of-subsequences-that-satisfy-the-given-sum-condition/solutions/709227/java-c-python-two-sum/
	 * */
	public int numSubseq(int[] nums, int target) {
		Arrays.sort(nums);
		
		int n = nums.length;
		int mod = 1000000007;
		int left = 0;
		int right = n - 1;
		int count = 0;
		
		// try to save time and avoid Math.pow precision lose
		// https://leetcode.com/problems/number-of-subsequences-that-satisfy-the-given-sum-condition/solutions/709227/java-c-python-two-sum/comments/597197
		int[] pow = new int[n];
		pow[0] = 1;
		for (int i = 1; i < n; i++) {
			pow[i] = pow[i - 1] * 2 % mod;
		}
		
		while (left <= right) {																						// if there is only one number
			if (nums[left] + nums[right] > target) {
				right--;
			} else {
				count = (count + pow[right - left]) % mod;
				left++;
			}
		}
		
		return count;
	}
	
}
