package com.example.lcpjava.dynamicprogramming;

import java.util.Arrays;

public class Lcp_2466_Count_Ways_To_Build_Good_Strings {
	
	/**
	 * time  : O(2 ^ high)
	 * space : O(2 ^ high)
	 * 
	 * Time Limit Exceeded
	 * */
	public int countGoodStrings_1(int low, int high, int zero, int one) {
		int[] count = new int[1];
		StringBuilder sb = new StringBuilder();
		recursive_1(sb, low, high, zero, one, count);
		return count[0] % 1000000007;
	}
	
	private void recursive_1(StringBuilder sb, int low, int high, int zero, int one, int[] count) {
		int length = sb.length();
		if (length > high) { return; }
		if (low <= length && length <= high) { count[0]++; }
		
		for (int i = 1; i <= zero; i++) { sb.append("0"); }
		recursive_1(sb, low, high, zero, one, count);
		sb.setLength(sb.length() - zero);
		
		for (int i = 1; i <= one; i++) { sb.append("1"); }
		recursive_1(sb, low, high, zero, one, count);
		sb.setLength(sb.length() - one);
	}
	
	/**
	 * time  : O(2 ^ high)
	 * space : O(2 ^ high)
	 * 
	 * Time Limit Exceeded
	 * */
	public int countGoodStrings_2(int low, int high, int zero, int one) {
		int[] count = new int[1];
		recursive_2(0, low, high, zero, one, count);
		return count[0] % 1000000007;
	}
	
	private void recursive_2(int length, int low, int high, int zero, int one, int[] count) {
		if (length > high) { return; }
		if (low <= length && length <= high) { count[0]++; }
		
		recursive_2(length + zero, low, high, zero, one, count);
		recursive_2(length + one, low, high, zero, one, count);
	}
	
	/**
	 * time  : O(2 ^ high)
	 * space : O(2 ^ high)
	 * 
	 * Time Limit Exceeded
	 * 
	 * https://leetcode.com/problems/count-ways-to-build-good-strings/solutions/3518468/c-recursive-memoization-tabulation-solution/
	 * */
	public int countGoodStrings_3(int low, int high, int zero, int one) {
		int ways = 0;
		
		for (int length = low; length <= high; length++) { ways = ways + recursive_3(length, zero, one); }
		
		return ways % 1000000007;
	}
	
	private int recursive_3(int length, int zero, int one) {
		if (length == 0) { return 1; }
		if (length < 0) { return 0; }
		return recursive_3(length - zero, zero, one) + recursive_3(length - one, zero, one);
	}
	
	/**
	 * time  : O(high)
	 * space : O(high)
	 * 
	 * Memoization
	 * 
	 * https://leetcode.com/problems/count-ways-to-build-good-strings/solutions/3518468/c-recursive-memoization-tabulation-solution/
	 * */
	public int countGoodStrings_4(int low, int high, int zero, int one) {
		int[] dp = new int[high + 1];
		Arrays.fill(dp, -1);
		
		int ways = 0;
		int mod = 1000000007;
		
		for (int length = low; length <= high; length++) { ways = (ways + recursive_4(length, zero, one, dp) % mod) % mod; }
		
		return ways;
	}
	
	private int recursive_4(int length, int zero, int one, int[] dp) {
		if (length == 0) { return 1; }
		if (length < 0) { return 0; }
		if (dp[length] != -1) { return dp[length]; }
		
		int mod = 1000000007;
		int zeros = recursive_4(length - zero, zero, one, dp) % mod;
		int ones = recursive_4(length - one, zero, one, dp) % mod;
		
		return dp[length] = (zeros + ones) % mod;
	}
	
	/**
	 * time  : O(high)
	 * space : O(high)
	 * 
	 * Tabulation
	 * 
	 * https://leetcode.com/problems/count-ways-to-build-good-strings/solutions/2807155/coin-change-problem-variant/
	 * https://www.youtube.com/watch?v=LbdhHgjcerA
	 * */
	public int countGoodStrings(int low, int high, int zero, int one) {
		int ways = 0;
		int mod = 1000000007;
		int[] dp = new int[high + 1];
		dp[0] = 1;
		
		for (int length = 1; length <= high; length++) {
			if (length >= zero) { dp[length] = (dp[length] + dp[length - zero]) % mod; }
			if (length >= one) { dp[length] = (dp[length] + dp[length - one]) % mod; }
			if (length >= low) { ways = (ways + dp[length]) % mod; }
		}
		
		return ways;
	}
	
}
