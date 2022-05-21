package com.example.lcpjava.array;

import java.util.Arrays;

public class Lcp_322_Coin_Change {
	
	/**
	 * time  : O(n!)
	 * space : O(n!)
	 * 
	 * Brute Force
	 * */
	public int coinChange_1(int[] coins, int amount) {
		int[] result = new int[1];
		result[0] = Integer.MAX_VALUE;
		
		backtrack(coins, amount, 0, result);
		
		return (result[0] != Integer.MAX_VALUE) ? result[0] : -1;
	}
	
	private void backtrack(int[] coins, int amount, int count, int[] result) {
		if (amount == 0) {
			result[0] = Math.min(result[0], count);
			return;
		}
		
		for (int i = coins.length - 1; i >= 0; i--) {
			int coin = coins[i];
			if (coin > amount) { continue; }
			
			backtrack(coins, amount - coin, count + 1, result);
		}
	}
	
	/**
	 * time  : O(amount * length)
	 * space : O(amount * length)
	 * 
	 * Memoization
	 * 
	 * https://leetcode.com/problems/coin-change/discuss/1371738/C%2B%2B-Recursion-greater-DP-Memoization-greater-DP-Tabulation
	 * */
	public int coinChange_2(int[] coins, int amount) {
		int[][] memo = new int[amount + 1][coins.length + 1];														// S : O(amount * length)
		Arrays.stream(memo).forEach(arr -> Arrays.fill(arr, -1));													// T : O(amount * length)
		
		int coin = recursive_1(coins, amount, coins.length, memo);													// T : O(amount * length)
		
		return coin != Integer.MAX_VALUE - 1 ? coin : -1;
	}
	
	private int recursive_1(int[] coins, int amount, int length, int[][] memo) {
		if (length == 0 || amount == 0) { return (amount == 0) ? 0 : Integer.MAX_VALUE - 1; }
		if (memo[amount][length] != -1) { return memo[amount][length]; }
		
		int withdraw = 0 + recursive_1(coins, amount, length - 1, memo);
		int coin = coins[length - 1];
		
		if (coin > amount) {
			memo[amount][length] = withdraw;
		} else {
			int pick = 1 + recursive_1(coins, amount - coin, length, memo);
			memo[amount][length] = Math.min(withdraw, pick);
		}
		
		return memo[amount][length];
	}
	
	/**
	 * time  : O(amount * length)
	 * space : O(amount * length)
	 * 
	 * Tabulation
	 * */
	public int coinChange_3(int[] coins, int amount) {
		int length = coins.length;
		int[][] memo = new int[amount + 1][length + 1];																// S : O(amount * length)
		Arrays.stream(memo).forEach(arr -> Arrays.fill(arr, -1));													// T : O(amount * length)
		
		for (int amt = 0; amt < amount + 1; amt++) {																// T : O(amount)
			for (int len = 0; len < length + 1; len++) {															// T : O(length)
				if (amt == 0 || len == 0) {
					memo[amt][len] = (amt == 0) ? 0 : Integer.MAX_VALUE - 1;
				}
			}
		}
		
		for (int amt = 1; amt < amount + 1; amt++) {																// T : O(amount)
			for (int len = 1; len < length + 1; len++) {															// T : O(length)
				int withdraw = 0 + memo[amt][len - 1];
				int coin = coins[len - 1];
				
				if (coin > amt) {
					memo[amt][len] = withdraw;
				} else {
					int pick = 1 + memo[amt - coin][len];
					memo[amt][len] = Math.min(withdraw, pick);
				}
			}
		}
		
		return memo[amount][length] != Integer.MAX_VALUE - 1 ? memo[amount][length] : -1;
	}
	
	/**
	 * time  : O(amount * length)
	 * space : O(amount)
	 * 
	 * https://leetcode.com/problems/coin-change/discuss/1104361/Coin-Change-or-Simple-DP-w-explanation-or-Short-and-Easy
	 * */
	public int coinChange(int[] coins, int amount) {
		int[] dp = new int[amount + 1];																				// S : O(amount)
		Arrays.fill(dp, amount + 1);																				// T : O(amount)
		dp[0] = 0;
		
		for (int coin : coins) {																					// T : O(length)
			for (int amt = coin; amt <= amount; amt++) {															// T : O(amount)
				dp[amt] = Math.min(dp[amt], 1 + dp[amt - coin]);													// 1 : pick current amount as one way; dp[amt - coin] : how many ways to formed remaining amount
			}
		}
		
		return dp[amount] > amount ? -1 : dp[amount];
	}
	
}
