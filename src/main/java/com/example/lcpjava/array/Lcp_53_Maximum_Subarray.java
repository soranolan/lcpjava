package com.example.lcpjava.array;

import java.util.Arrays;

public class Lcp_53_Maximum_Subarray {
	
	/**
	 * time  : O(n ^ 2)
	 * space : O(1)
	 * 
	 * Brute Force
	 * 
	 * https://leetcode.com/problems/maximum-subarray/discuss/1595195/C%2B%2BPython-7-Simple-Solutions-w-Explanation-or-Brute-Force-%2B-DP-%2B-Kadane-%2B-Divide-and-Conquer
	 * 
	 * 
	 * int length <- nums length
	 * int historyMax <- Integer min value
	 * 
	 * for int start <- 0; if start is lower than length; start++
	 * 		int sum <- 0
	 * 		
	 * 		for int end <- start; if end is lower than length; end++
	 * 			sum <- sum plus nums[end]
	 * 			historyMax <- Math max(sum, historyMax)
	 * 		end for
	 * end for
	 * 
	 * return historyMax
	 * */
	public int maxSubArray_1(int[] nums) {
		int length = nums.length;
		int historyMax = Integer.MIN_VALUE;
		
		for (int start = 0; start < length; start++) {																// T : O(n)
			int sum = 0;
			
			for (int end = start; end < length; end++) {															// T : O(n)
				sum += nums[end];
				historyMax = Math.max(sum, historyMax);
			}
		}
		
		return historyMax;
	}
	
	/**
	 * time  : O(n ^ 2)
	 * space : O(1)
	 * 
	 * return recursion(zero, false, nums)
	 * */
	public int maxSubArray_2(int[] nums) {
		return recursion(0, false, nums);
	}
	
	/**
	 * if index is greater than or equal to nums length
	 * 		return if pick is true then zero else minus 100000
	 * end if
	 * 
	 * if pick is true
	 * 		return Math max(zero, nums[index] plus recursion(index plus one, true, nums))
	 * end if
	 * 
	 * return Math max(recursion(index plus one, false, nums), nums[index] plus recursion(index plus one, true, nums))
	 * */
	public int recursion(int index, boolean pick, int[] nums) {
		if (index >= nums.length) { return pick ? 0 : -100000; }
		if (pick) { return Math.max(0, nums[index] + recursion(index + 1, true, nums)); }
		return Math.max(recursion(index + 1, false, nums), nums[index] + recursion(index + 1, true, nums));
	}
	
	/**
	 * time  : O(n)
	 * space : O(n)
	 * 
	 * Memoization
	 * 
	 * 
	 * int[][] dp <- new int[nums length][two]
	 * 
	 * fill dp with minus one
	 * 
	 * return recursion(zero, zero, nums, dp)
	 * */
	public int maxSubArray_3(int[] nums) {
		int[][] dp = new int[nums.length][2];
		Arrays.stream(dp).forEach(arr -> Arrays.fill(arr, -1));
		return recursion(0, 0, nums, dp);
	}
	
	/**
	 * if index is greater than or equal to nums length
	 * 		return if pick is equal to one then zero else minus 100000
	 * end if
	 * 
	 * if dp[index][pick] is not equal to minus one
	 * 		return dp[index][pick]
	 * end if
	 * 
	 * if pick is equal to one
	 * 		return dp[index][pick] <- Math max(zero, nums[index] plus recursion(index plus one, one, nums, dp))
	 * end if
	 * 
	 * return dp[index][pick] <- Math max(recursion(index plus one, zero, nums, dp), nums[index] plus recursion(index plus one, one, nums, dp))
	 * */
	public int recursion(int index, int pick, int[] nums, int[][] dp) {
		if (index >= nums.length) { return (pick == 1) ? 0 : -100000; }
		if (dp[index][pick] != -1) { return dp[index][pick]; }
		if (pick == 1) { return dp[index][pick] = Math.max(0, nums[index] + recursion(index + 1, 1, nums, dp)); }
		return dp[index][pick] = Math.max(recursion(index + 1, 0, nums, dp), nums[index] + recursion(index + 1, 1, nums, dp));
	}
	
	/**
	 * time  : O(n)
	 * space : O(n)
	 * 
	 * Bottom-Up Tabulation
	 * 
	 * 
	 * int length <- nums length
	 * int[][] dp <- new int[two][length]
	 * 
	 * dp[0][0] <- nums[0]
	 * dp[1][0] <- nums[0]
	 * 
	 * for int i <- 1; if i is lower than length; i++
	 * 		dp[1][i] <- Math max(nums[i], nums[i] plus dp[1][i minus one])
	 * 		dp[0][i] <- Math max(dp[0][i minus one], dp[1][i])
	 * end for
	 * 
	 * return dp[0][length minus one]
	 * */
	public int maxSubArray_4(int[] nums) {
		int length = nums.length;
		int[][] dp = new int[2][length];																			// S : O(2 * n)
		
		dp[0][0] = nums[0];																							// history max sum
		dp[1][0] = nums[0];																							// current max sum
		
		for (int i = 1; i < length; i++) {																			// T : O(n)
			dp[1][i] = Math.max(nums[i], nums[i] + dp[1][i - 1]);
			dp[0][i] = Math.max(dp[0][i - 1], dp[1][i]);
		}
		
		return dp[0][length - 1];
	}
	
	/**
	 * time  : O(n)
	 * space : O(n)
	 * 
	 * Bottom-Up Tabulation
	 * 
	 * 
	 * int historyMax <- nums[0]
	 * int length <- nums length
	 * int[] dp <- new int[length]
	 * dp[0] <- nums[0]
	 * 
	 * for int i <- 1; if i is lower than length; i++
	 * 		dp[i] <- Math max(nums[i], nums[i] plus dp[i minus one])
	 * 		historyMax <- Math max(historyMax, dp[i])
	 * end for
	 * 
	 * return historyMax
	 * */
	public int maxSubArray_5(int[] nums) {
		int historyMax = nums[0];
		int length = nums.length;
		int[] dp = new int[length];																					// S : O(n)
		dp[0] = nums[0];
		
		for (int i = 1; i < length; i++) {																			// T : O(n)
			dp[i] = Math.max(nums[i], nums[i] + dp[i - 1]);
			historyMax = Math.max(historyMax, dp[i]);
		}
		
		return historyMax;
	}
	
	/**
	 * time  : O(n)
	 * space : O(1)
	 * 
	 * Kadane's Algorithm
	 * 
	 * 
	 * int currentSum <- 0
	 * int historyMax <- Integer min value
	 * 
	 * for int num in nums
	 * 		currentSum <- Math max(num, currentSum plus num)
	 * 		historyMax <- Math max(historyMax, currentSum)
	 * end for
	 * 
	 * return historyMax
	 * */
	public int maxSubArray_6(int[] nums) {
		int currentSum = 0;
		int historyMax = Integer.MIN_VALUE;
		
		for (int num : nums) {																						// T : O(n)
			currentSum = Math.max(num, currentSum + num);
			historyMax = Math.max(historyMax, currentSum);
		}
		
		return historyMax;
	}
	
	/**
	 * Follow up
	 * Divide and conquer
	 * 1. [L ~ mid - 1]
	 * 2. [mid + 1 ~ R]
	 * 3. [L' ~ mid - 1] + [mid] + [mid + 1 ~ R']
	 * */
	/**
	 * time  : O(n log n)
	 * space : O(log n)
	 * 
	 * return recursion(zero, nums length minus one, nums)
	 * */
	public int maxSubArray_7(int[] nums) {
		return recursion(0, nums.length - 1, nums);
	}
	
	/**
	 * if start is greater than end
	 * 		return Integer min value
	 * end if
	 * 
	 * int mid <- start plus (end minus start) divide by two
	 * int leftPartSum <- 0
	 * int rightPartSum <- 0
	 * int sum <- 0
	 * 
	 * for int i <- mid minus one; if i is greater than or equal to start; i--
	 * 		sum <- sum plus nums[i]
	 * 		leftPartSum <- Math max(leftPartSum, sum)
	 * end for
	 * 
	 * reset sum to zero
	 * 
	 * for int i <- mid plus one; if i is lower than or equal to end; i++
	 * 		sum <- sum plus nums[i]
	 * 		rightPartSum <- Math max(rightPartSum, sum)
	 * end for
	 * 
	 * int L <- recursion(start, mid minus one, nums)
	 * int R <- recursion(mid plus one, end, nums)
	 * int M <- leftPartSum plus nums[mid] plus rightPartSum
	 * 
	 * return Math max(Math max(L, R), M)
	 * */
	public int recursion(int start, int end, int[] nums) {
		if (start > end) { return Integer.MIN_VALUE; }
		
		int mid = start + (end - start) / 2;
		int leftPartSum = 0;
		int rightPartSum = 0;
		int sum = 0;
		
		/**
		 * why can't i start with 0 (or head or left)?
		 * 
		 * cause we are looking for contiguous array, it may contain middle point.
		 * 
		 * https://leetcode.com/problems/maximum-subarray/discuss/364839/Divide-and-Conquer-Commented-Explanation-and-Big-O-(JS)
		 * */
		for (int i = mid - 1; i >= start; i--) {																	// T : O(n / 2)
			sum += nums[i];
			leftPartSum = Math.max(leftPartSum, sum);
		}
		
		sum = 0;
		for (int i = mid + 1; i <= end; i++) {																		// T : O(n / 2)
			sum += nums[i];
			rightPartSum = Math.max(rightPartSum, sum);
		}
		
		int L = recursion(start, mid - 1, nums);
		int R = recursion(mid + 1, end, nums);
		int M = leftPartSum + nums[mid] + rightPartSum;
		
		return Math.max(Math.max(L, R), M);
	}
	
	/**
	 * time  : O(n)
	 * space : O(n)
	 * 
	 * int length <- nums length
	 * int[] prefixSum <- copy of input
	 * int[] suffixSum <- copy of input
	 * 
	 * for int i <- 1; if i is lower than length; i++
	 * 		prefixSum[i] <- prefixSum[i] plus Math max(zero, prefixSum[i minus one])
	 * end for
	 * 
	 * for int i <- length minus two; if i is greater than or equal to zero; i--
	 * 		suffixSum[i] <- suffixSum[i] plus Math max(zero, suffixSum[i plus one])
	 * end for
	 * 
	 * return recursion(zero, length minus one, nums, prefixSum, suffixSum)
	 * */
	public int maxSubArray(int[] nums) {
		int length = nums.length;
		int[] prefixSum = Arrays.copyOf(nums, length);																// S : O(n)
		int[] suffixSum = Arrays.copyOf(nums, length);																// S : O(n)
		
		for (int i = 1; i < length; i++) { prefixSum[i] += Math.max(0, prefixSum[i - 1]); }							// T : O(n)
		for (int i = length - 2; i >= 0; i--) { suffixSum[i] += Math.max(0, suffixSum[i + 1]); }					// T : O(n)
		
		return recursion(0, length - 1, nums, prefixSum, suffixSum);
	}
	
	/**
	 * if start is equal to end
	 * 		return nums[start]
	 * end if
	 * 
	 * int mid <- start plus (end minus start) divide by two
	 * 
	 * int L <- recursion(start, mid, nums, prefixSum, suffixSum)
	 * int R <- recursion(mid plus one, end, nums, prefixSum, suffixSum)
	 * int M <- prefixSum[mid] plus suffixSum[mid plus one]
	 * 
	 * return Math max(Math max(L, R), M)
	 * */
	public int recursion(int start, int end, int[] nums, int[] prefixSum, int[] suffixSum) {
		if (start == end) { return nums[start]; }
		
		int mid = start + (end - start) / 2;
		
		int L = recursion(start, mid, nums, prefixSum, suffixSum);
		int R = recursion(mid + 1, end, nums, prefixSum, suffixSum);
		int M = prefixSum[mid] + suffixSum[mid + 1];
		
		return Math.max(Math.max(L, R), M);
	}
	
}
