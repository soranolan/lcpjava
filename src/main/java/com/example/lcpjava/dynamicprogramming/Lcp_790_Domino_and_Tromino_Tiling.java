package com.example.lcpjava.dynamicprogramming;

import java.util.Arrays;

public class Lcp_790_Domino_and_Tromino_Tiling {
	
	/**
	 * time  : O(3 ^ n)
	 * space : O(n)
	 * 
	 * https://leetcode.com/problems/domino-and-tromino-tiling/solutions/1620975/c-python-simple-solution-w-images-explanation-optimization-from-brute-force-to-dp/
	 * */
	public int numTilings_1(int n) {
		return (int) tiling(0, n, false);
	}
	
	private long tiling(int index, int n, boolean previousTilingHasGap) {
		if (index > n) { return 0; }
		
		if (index == n) {
			if (previousTilingHasGap) {
				return 0;
			} else {
				return 1;
			}
		}
		
		// (T5 or T6) + T2
		if (previousTilingHasGap) { return (tiling(index + 1, n, false) + tiling(index + 1, n, true)) % 1000000007; }
		
		// T1 + T2 + (T3 or T4)
		return (tiling(index + 1, n, false) + tiling(index + 2, n, false) + 2L * tiling(index + 2, n, true)) % 1000000007;
	}
	
	/**
	 * time  : O(n)
	 * space : O(n)
	 * 
	 * Memoization
	 * 
	 * https://leetcode.com/problems/domino-and-tromino-tiling/solutions/1620975/c-python-simple-solution-w-images-explanation-optimization-from-brute-force-to-dp/
	 * */
	public int numTilings_2(int n) {
		long[][] memo = new long[1001][2];																			// n
		for (long[] arr : memo) { Arrays.fill(arr, -1); }
		return (int) tiling(0, n, 0, memo);
	}
	
	private long tiling(int index, int n, int previousTilingHasGap, long[][] memo) {
		if (index > n) { return 0; }
		
		if (index == n) {
			if (previousTilingHasGap == 1) {
				return 0;
			} else {
				return 1;
			}
		}
		
		if (memo[index][previousTilingHasGap] != -1) { return memo[index][previousTilingHasGap]; }
		
		// (T5 or T6) + T2
		if (previousTilingHasGap == 1) { return memo[index][1] = (tiling(index + 1, n, 0, memo) + tiling(index + 1, n, 1, memo)) % 1000000007; }
		
		// T1 + T2 + (T3 or T4)
		return memo[index][previousTilingHasGap] = (tiling(index + 1, n, 0, memo) + tiling(index + 2, n, 0, memo) + 2L * tiling(index + 2, n, 1, memo)) % 1000000007;
	}
	
	/**
	 * time  : O(n)
	 * space : O(n)
	 * 
	 * Tabulation
	 * 
	 * https://leetcode.com/problems/domino-and-tromino-tiling/solutions/1620975/c-python-simple-solution-w-images-explanation-optimization-from-brute-force-to-dp/
	 * */
	public int numTilings_3(int n) {
		long[][] dp = new long[1001][2];
		dp[1] = new long[] { 1L, 1L };
		dp[2] = new long[] { 2L, 2L };
		
		for (int i = 3; i <= n; i++) {																				// T : O(n - 2)
			dp[i][0] = (dp[i - 1][0] + dp[i - 2][0] + 2L * dp[i - 2][1]) % 1000000007;
			dp[i][1] = (dp[i - 1][0] + dp[i - 1][1]) % 1000000007;
		}
		
		return (int) dp[n][0];
	}
	
	/**
	 * time  : O(n)
	 * space : O(1)
	 * 
	 * Space Optimized
	 * 
	 * https://leetcode.com/problems/domino-and-tromino-tiling/solutions/1620975/c-python-simple-solution-w-images-explanation-optimization-from-brute-force-to-dp/
	 * */
	public int numTilings(int n) {
		long[][] dp = new long[3][2];
		dp[1] = new long[] { 1L, 1L };
		dp[2] = new long[] { 2L, 2L };
		
		for (int i = 3; i <= n; i++) {																				// T : O(n - 2)
			dp[i % 3][0] = (dp[(i - 1) % 3][0] + dp[(i - 2) % 3][0] + 2L * dp[(i - 2) % 3][1]) % 1000000007;
			dp[i % 3][1] = (dp[(i - 1) % 3][0] + dp[(i - 1) % 3][1]) % 1000000007;
		}
		
		return (int) dp[n % 3][0];
	}
	
}
