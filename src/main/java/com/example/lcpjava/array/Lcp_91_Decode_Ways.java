package com.example.lcpjava.array;

import java.util.Arrays;

public class Lcp_91_Decode_Ways {
	
	/**
	 * time  : O(2 ^ n)
	 * space : O(2 ^ n)
	 * 
	 * https://leetcode.com/problems/decode-ways/discuss/30451/Evolve-from-recursion-to-dp
	 * https://leetcode.com/problems/decode-ways/discuss/1411484/Detailed-Explanation-oror-C%2B%2B-oror-DP-with-Memoization
	 * https://leetcode.com/problems/decode-ways/discuss/608268/Python-Thinking-process-diagram-(DP-%2B-DFS)
	 * */
	public int numDecodings_1(String s) {
		int n = s.length();
		return numDecodings(0, n, s);
	}
	
	private int numDecodings(int index, int n, String s) {
		if (index == n) { return 1; }
		if (s.charAt(index) == '0') { return 0; }
		
		// pick one digit
		int result = numDecodings(index + 1, n, s);
		
		// pick two digit
		if (index + 1 < n && (s.charAt(index) == '1' || s.charAt(index) == '2' && s.charAt(index + 1) < '7')) {
			result += numDecodings(index + 2, n, s);
		}
		
		return result;
	}
	
	/**
	 * time  : O(n)
	 * space : O(n)
	 * 
	 * https://leetcode.com/problems/decode-ways/discuss/30451/Evolve-from-recursion-to-dp
	 * */
	public int numDecodings_2(String s) {
		int n = s.length();
		
		int[] memo = new int[n];																					// S : O(n)
		Arrays.fill(memo, -1);																						// T : O(n)
		
		return numDecodings(0, n, s, memo);
	}
	
	private int numDecodings(int index, int n, String s, int[] memo) {
		if (index == n) { return 1; }
		if (s.charAt(index) == '0') { return 0; }
		if (memo[index] != -1) { return memo[index]; }
		
		// pick one digit
		int result = numDecodings(index + 1, n, s, memo);
		
		// pick two digit
		if (index + 1 < n && (s.charAt(index) == '1' || s.charAt(index) == '2' && s.charAt(index + 1) < '7')) {
			result += numDecodings(index + 2, n, s, memo);
		}
		
		memo[index] = result;
		
		return memo[index];
	}
	
	/**
	 * time  : O(n)
	 * space : O(n)
	 * 
	 * from right to left
	 * 
	 * https://leetcode.com/problems/decode-ways/discuss/30451/Evolve-from-recursion-to-dp
	 * */
	public int numDecodings_3(String s) {
		int n = s.length();
		int[] dp = new int[n + 1];																					// S : O(n + 1)
		dp[n] = 1;
		
		for (int i = n - 1; i >= 0; i--) {																			// T : O(n)
			if (s.charAt(i) == '0') { continue; }
			
			// pick one digit
			dp[i] = dp[i + 1];
			
			// pick two digit
			if (i + 1 < n && (s.charAt(i) == '1' || s.charAt(i) == '2' && s.charAt(i + 1) < '7')) {
				dp[i] += dp[i + 2];
			}
		}
		
		return dp[0];
	}
	
	/**
	 * time  : O(n)
	 * space : O(1)
	 * 
	 * https://leetcode.com/problems/decode-ways/discuss/30451/Evolve-from-recursion-to-dp
	 * */
	public int numDecodings(String s) {
		int ways = 1;
		int previous = 0;
		int n = s.length();
		
		for (int i = n - 1; i >= 0; i--) {																			// T : O(n)
			// pick one digit
			int current = (s.charAt(i) == '0') ? 0 : ways;
			
			// pick two digit
			if (i + 1 < n && (s.charAt(i) == '1' || s.charAt(i) == '2' && s.charAt(i + 1) < '7')) {
				current += previous;
			}
			
			previous = ways;
			ways = current;
		}
		
		return ways;
	}
	
}
