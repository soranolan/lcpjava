package com.example.lcpjava.stack;

import java.util.HashMap;
import java.util.Map;

public class Lcp_494_Target_Sum {
	
	/**
	 * time  : O(2 ^ n)
	 * space : O(n)
	 * 
	 * if array is equal to null || array length is equal to zero
	 * 		return 0
	 * end if
	 * 
	 * int index <- 0
	 * int sum <- 0
	 * Map<String, Integer> memo <- new HashMap
	 * 
	 * return DFS(array, index, sum, target, memo)
	 * */
	public int findTargetSumWays_1(int[] nums, int target) {
		if (nums == null || nums.length == 0) { return 0; }
		
		int index = 0;
		int sum = 0;
		Map<String, Integer> memo = new HashMap<>();
		
		return DFS(nums, index, sum, target, memo);
	}
	
	/**
	 * String key <- index concatenate "->" concatenate sum
	 * if memo containsKey(key)
	 * 		return memo get(key)
	 * end if
	 * 
	 * if index is equal to array length
	 * 		if sum is equal to target
	 * 			return 1
	 * 		end if
	 * 		return 0
	 * end if
	 * 
	 * int number <- array[index]
	 * int add <- DFS(array, index plus one, sum plus number, target, memo)
	 * int subtract <- DFS(array, index plus one, sum minus number, target, memo)
	 * 
	 * memo put(key, add plus subtract)
	 * 
	 * return add plus subtract
	 * */
	public int DFS(int[] nums, int index, int sum, int target, Map<String, Integer> memo) {
		String key = index + "->" + sum;
		if (memo.containsKey(key)) { return memo.get(key); }
		
		if (index == nums.length) {
			if (sum == target) { return 1; }
			return 0;
		}
		
		int number = nums[index];
		int add = DFS(nums, index + 1, sum + number, target, memo);
		int subtract = DFS(nums, index + 1, sum - number, target, memo);
		
		memo.put(key, add + subtract);
		
		return add + subtract;
	}
	
	/**
	 * numbers : 1, 1, 1, 1, 1
	 * target  : 3
	 * 
	 * how many numbers to construct target
	 * ¡õ
	 * 				0	1	2	3	4	5	6	7	8	9	10	¡ö index
	 * 				-5	-4	-3	-2	-1	0	1	2	3	4	5	¡ö target number
	 * 0	*	1						1					
	 * 1	*	1					1		1				
	 * 2	*	1				1		2		1			
	 * 3	*	1			1		3		3		1		
	 * 4	*	1		1		4		6		4		1	
	 * 5	*	1	1		5		10		10		5		1
	 * */
	/**
	 * time  : O(n * range)
	 * space : O(n * range)
	 * 
	 * int total <- 0
	 * for number in array
	 * 		total <- total plus number
	 * end for
	 * if target is greater than total || target is lower than minus total
	 * 		return 0
	 * end if
	 * 
	 * int range <- two times total plus one
	 * int[] dp <- new int[range]
	 * dp[total] <- 1
	 * 
	 * for number in array
	 * 		int[] newDP <- new int[range]
	 * 		for int index <- num; index plus number is lower than range; index++
	 * 			newDP[index minus number] <- newDP[index minus number] plus dp[index]
	 * 			newDP[index plus number] <- newDP[index plus number] plus dp[index]
	 * 		end for
	 * 		dp <- newDP
	 * end for
	 * 
	 * return dp[target plus total]
	 * */
	public int findTargetSumWays_2(int[] nums, int target) {
		int total = 0;
		for (int num : nums) { total += num; }
		if (target > total || target < -total) { return 0; }
		
		int range = 2 * total + 1;
		int[] dp = new int[range];																					// S : O(range)
		dp[total] = 1;
		
		for (int num : nums) {																						// T : O(n)
			int[] newDP = new int[range];																			// S : O(range)
			for (int index = num; index + num < range; index++) {													// T : O(range)
				newDP[index - num] = newDP[index - num] + dp[index];
				newDP[index + num] = newDP[index + num] + dp[index];
			}
			dp = newDP;
		}
		
		return dp[target + total];
	}
	
	/**
	 * 1 + 1 + 1 - 1 - 1 = 1
	 * 3 - 2 = 1
	 * (1 + 1 + 1) - (1 + 1) = 1
	 * Sum(Positive) - Sum(Negative) = target
	 * Sum(Positive) + Sum(Negative) + Sum(Positive) - Sum(Negative) = target + Sum(Positive) + Sum(Negative)
	 * 2 * Sum(Positive) = target + Sum(Positive) + Sum(Negative)
	 * 2 * Sum(Positive) = target + sum of input array
	 * Sum(Positive) = (target + Sum(Array)) / 2
	 * target + Sum(Array) must be even
	 * */
	/**
	 * numbers : 1, 1, 1, 1, 1
	 * target  : 3
	 * 
	 * how many numbers to construct target number
	 * ¡õ
	 * 				0	1	2	3	4	5	¡ö target number
	 * 0	*	1	1					
	 * 1	*	1	1	1				
	 * 2	*	1	1	2	1			
	 * 3	*	1	1	3	3	1		
	 * 4	*	1	1	4	6	4	1	
	 * 5	*	1	1	5	10	10	5	1
	 * */
	/**
	 * time  : O(n * m)
	 * space : O(m)
	 * 
	 * int total <- 0
	 * for number in array
	 * 		total <- total plus number
	 * end for
	 * 
	 * if target is greater than total || target is lower than minus total
	 * 		return 0
	 * end if
	 * if (target plus total) modulo two is not equal to zero
	 * 		return 0
	 * end if
	 * 
	 * int sumOfPositive <- (target plus total) divided by two
	 * return subset(arrays, sumOfPositive)
	 * */
	public int findTargetSumWays(int[] nums, int target) {
		int total = 0;
		for (int num : nums) { total += num; }																		// T : O(n)
		
		if (target > total || target < -total) { return 0; }
		if ((target + total) % 2 != 0) { return 0; }
		
		int sumOfPositive = (target + total) >>> 1;
		return subset(nums, sumOfPositive);
	}
	
	/**
	 * int[] dp <- new int[sumOfPositive plus one]
	 * dp[0] <- 1
	 * 
	 * for number in array
	 * 		for int index <- sumOfPositive; if index is greater than or equal to number; index--
	 * 			dp[index] <- dp[index] plus dp[index minus number]
	 * 		end for
	 * end for
	 * 
	 * return dp[sumOfPositive]
	 * */
	public int subset(int[] nums, int sumOfPositive) {
		int[] dp = new int[sumOfPositive + 1];																		// S : O(m)
		dp[0] = 1;
		
		for (int num : nums) {																						// T : O(n)
			for (int index = sumOfPositive; index >= num; index--) {												// T : O(m)
				dp[index] = dp[index] + dp[index - num];
			}
		}
		
		return dp[sumOfPositive];
	}
	
}
