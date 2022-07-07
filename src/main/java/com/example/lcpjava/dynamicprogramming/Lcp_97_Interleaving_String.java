package com.example.lcpjava.dynamicprogramming;

import java.util.Arrays;

public class Lcp_97_Interleaving_String {
	
	/**
	 * time  : O(2 ^ (m + n))
	 * space : O(m + n)
	 * 
	 * Brute Force
	 * */
	public boolean isInterleave_1(String s1, String s2, String s3) {
		int m = s1.length();
		int n = s2.length();
		
		if (m + n != s3.length()) { return false; }
		
		return isValid(s1, 0, s2, 0, "", s3);
	}
	
	private boolean isValid(String s1, int i, String s2, int j, String result, String s3) {
		if (s3.equals(result.toString()) && i == s1.length() && j == s2.length()) { return true; }
		
		boolean answer = false;
		
		if (i < s1.length()) { answer |= isValid(s1, i + 1, s2, j, result + s1.charAt(i), s3); }
		
		if (j < s2.length()) { answer |= isValid(s1, i, s2, j + 1, result + s2.charAt(j), s3); }
		
		return answer;
	}
	
	/**
	 * time  : O(m * n)
	 * space : O(m * n)
	 * 
	 * Memoization
	 * */
	public boolean isInterleave_2(String s1, String s2, String s3) {
		int m = s1.length();
		int n = s2.length();
		if (m + n != s3.length()) { return false; }
		
		int[][] memo = new int[m][n];																				// S : O(m * n)
		Arrays.asList(memo).forEach(arr -> Arrays.fill(arr, -1));													// T : O(m * n)
		
		return isValid(s1, 0, s2, 0, s3, 0, memo);																	// T : O(m * n)
	}
	
	private boolean isValid(String s1, int i, String s2, int j, String s3, int k, int[][] memo) {
		if (i == s1.length()) { return s2.substring(j).equals(s3.substring(k)); }
		if (j == s2.length()) { return s1.substring(i).equals(s3.substring(k)); }
		if (memo[i][j] != -1) { return memo[i][j] == 1; }
		
		boolean answer = false;
		
		if (s1.charAt(i) == s3.charAt(k) && isValid(s1, i + 1, s2, j, s3, k + 1, memo) ||
			s2.charAt(j) == s3.charAt(k) && isValid(s1, i, s2, j + 1, s3, k + 1, memo)) {
			answer = true;
		}
		
		memo[i][j] = answer ? 1 : 0;
		
		return answer;
	}
	
	/**
	 * time  : O(m * n)
	 * space : O(m * n)
	 * 
	 * https://leetcode.com/problems/interleaving-string/discuss/32078/DP-Solution-in-Java
	 * 
	 *       C d b b c a
	 *       0 1 2 3 4 5
	 * R 0   T          
	 * a 1 ↓ T          
	 * a 2 ↓ T T T T T  
	 * b 3 →   T T   T  
	 * c 4       T T T T
	 * c 5         T   T
	 * 
	 * like a maze
	 * */
	public boolean isInterleave_3(String s1, String s2, String s3) {
		int rows = s1.length();																						// m
		int cols = s2.length();																						// n
		if (rows + cols != s3.length()) { return false; }
		
		boolean[][] dp = new boolean[rows + 1][cols + 1];															// S : O(m * n)
		dp[0][0] = true;
		
		// if s2 is empty, just check s1 and s3
		for (int row = 1; row <= rows; row++) {																		// T : O(m)
			dp[row][0] = dp[row - 1][0] && s1.charAt(row - 1) == s3.charAt(row - 1);
		}
		
		// if s1 is empty, just check s2 and s3
		for (int col = 1; col <= cols; col++) {																		// T : O(n)
			dp[0][col] = dp[0][col - 1] && s2.charAt(col - 1) == s3.charAt(col - 1);
		}
		
		// s1 and s2 both not empty
		for (int row = 1; row <= rows; row++) {																		// T : O(m)
			for (int col = 1; col <= cols; col++) {																	// T : O(n)
				int char1 = s1.charAt(row - 1);
				int char2 = s2.charAt(col - 1);
				int char3 = s3.charAt(row + col - 1);
				
				dp[row][col] = (char1 == char3 && dp[row - 1][col]) || (char2 == char3 && dp[row][col - 1]);
			}
		}
		
		return dp[rows][cols];
	}
	
	/**
	 * Follow up:
	 * Could you solve it using only O(s2.length) additional memory space?
	 * */
	/**
	 * time  : O(m * n)
	 * space : O(n)
	 * 
	 * reuse previous dp array
	 * */
	public boolean isInterleave(String s1, String s2, String s3) {
		int m = s1.length();
		int n = s2.length();
		if (m + n != s3.length()) { return false; }
		
		boolean[] dp = new boolean[n + 1];																			// S : O(n + 1)
		
		for (int i = 0; i <= m; i++) {																				// T : O(m)
			for (int j = 0; j <= n; j++) {																			// T : O(n)
				if (i == 0 && j == 0) {
					dp[j] = true;
				} else if (i == 0) {
					dp[j] = dp[j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1);
				} else if (j == 0) {
					dp[j] = dp[j] && s1.charAt(i - 1) == s3.charAt(i + j - 1);
				} else {
					dp[j] = (dp[j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)) || (dp[j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
				}
			}
		}
		
		return dp[n];
	}
	
}
