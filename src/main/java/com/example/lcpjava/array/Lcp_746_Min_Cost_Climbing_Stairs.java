package com.example.lcpjava.array;

import java.util.Arrays;

public class Lcp_746_Min_Cost_Climbing_Stairs {
	
	/**
	 * time  : O(2 ^ n)
	 * space : O(n)
	 * 
	 * https://leetcode.com/problems/min-cost-climbing-stairs/discuss/476388/4-ways-or-Step-by-step-from-Recursion-greater-top-down-DP-greater-bottom-up-DP-greater-fine-tuning
	 * 
	 * 
	 * return Math min(recursion(zero, cost), recursion(one, cost))
	 * */
	public int minCostClimbingStairs_1(int[] cost) {
		return Math.min(recursion(0, cost), recursion(1, cost));
	}
	
	/**
	 * if index is greater than or equal to cost length
	 * 		return zero
	 * end if
	 * 
	 * return cost[index] plus Math min(recursion(index plus one, cost), recursion(index plus two, cost))
	 * */
	public int recursion(int index, int[] cost) {
		if (index >= cost.length) { return 0; }
		
		return cost[index] + Math.min(recursion(index + 1, cost), recursion(index + 2, cost));
	}
	
	/**
	 * time  : O(n)
	 * space : O(n)
	 * 
	 * Memoization
	 * 
	 * 
	 * int length <- cost length
	 * int[] dp <- new int[length plus two]
	 * 
	 * fill dp with minus one
	 * 
	 * dp last two <- zero
	 * 
	 * return Math min(recursion(zero, cost, dp), recursion(one, cost, dp))
	 * */
	public int minCostClimbingStairs_2(int[] cost) {
		int length = cost.length;
		int[] dp = new int[length + 2];																				// S : O(n + 2)
		
		Arrays.fill(dp, -1);																						// T : O(n)
		dp[length] = 0;
		dp[length + 1] = 0;
		
		return Math.min(recursion(0, cost, dp), recursion(1, cost, dp));
	}
	
	/**
	 * if dp[index] is not equal to minus one
	 * 		return dp[index]
	 * end if
	 * 
	 * dp[index] <- cost[index] plus Math min(recursion(index plus one, cost, dp), recursion(index plus two, cost, dp))
	 * 
	 * return dp[index]
	 * */
	public int recursion(int index, int[] cost, int[] dp) {
		if (dp[index] != -1) { return dp[index]; }
		
		dp[index] = cost[index] + Math.min(recursion(index + 1, cost, dp), recursion(index + 2, cost, dp));
		
		return dp[index];
	}
	
	/**
	 * time  : O(n)
	 * space : O(n)
	 * 
	 * int length <- cost length
	 * int[] dp <- new int[length plus two]
	 * 
	 * for int i <- length minus one; if i is greater than or equal to zero; i--
	 * 		dp[i] <- cost[i] plus Math min(dp[i plus one], dp[i plus two])
	 * end for
	 * 
	 * return Math min(dp[0], dp[1])
	 * */
	public int minCostClimbingStairs_3(int[] cost) {
		int length = cost.length;
		int[] dp = new int[length + 2];																				// S : O(n + 2)
		
		for (int i = length - 1; i >= 0; i--) { dp[i] = cost[i] + Math.min(dp[i + 1], dp[i + 2]); }					// T : O(n)
		
		return Math.min(dp[0], dp[1]);
	}
	
	/**
	 * time  : O(n)
	 * space : O(1)
	 * 
	 * int first <- 0
	 * int second <- 0
	 * 
	 * for int i <- cost length minus one; if i is greater than or equal to zero; i--
	 * 		int temp <- cost[i] plus Math min(first, second)
	 * 		second <- first
	 * 		first <- temp
	 * end for
	 * 
	 * return Math min(first, second)
	 * */
	public int minCostClimbingStairs(int[] cost) {
		int first = 0;
		int second = 0;
		
		for (int i = cost.length - 1; i >= 0; i--) {																// T : O(n)
			int temp = cost[i] + Math.min(first, second);
			second = first;
			first = temp;
		}
		
		return Math.min(first, second);
	}
	
}
