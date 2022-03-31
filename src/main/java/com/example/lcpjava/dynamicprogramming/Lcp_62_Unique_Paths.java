package com.example.lcpjava.dynamicprogramming;

import java.util.Arrays;

public class Lcp_62_Unique_Paths {
	
	/**
	 * time  : O(2 ^ (m + n))
	 * space : O(m + n)
	 * 
	 * Brute Force
	 * https://leetcode.com/problems/unique-paths/discuss/1581998/C%2B%2BPython-5-Simple-Solutions-w-Explanation-or-Optimization-from-Brute-Force-to-DP-to-Math
	 * 
	 * 
	 * return recursion(zero, zero, m, n)
	 * */
	public int uniquePaths_1(int m, int n) {
		return recursion(0, 0, m, n);
	}
	
	/**
	 * if row is greater than or equal to rows || col is greater than or equal to cols
	 * 		return zero
	 * end if
	 * 
	 * if row is equal to rows minus one && col is equal to cols minus one
	 * 		return one
	 * end if
	 * 
	 * return recursion(row plus one, col, rows, cols) plus recursion(row, col plus one, rows, cols)
	 * */
	public int recursion(int row, int col, int rows, int cols) {
		if (row >= rows || col >= cols) { return 0; }
		if (row == rows - 1 && col == cols - 1) { return 1; }
		return recursion(row + 1, col, rows, cols) + recursion(row, col + 1, rows, cols);
	}
	
	/**
	 * time  : O(m * n)
	 * space : O(m * n)
	 * 
	 * Memoization
	 * 
	 * 
	 * int[][] dp <- new int[m][n]
	 * 
	 * fill dp with minus one
	 * 
	 * return recursion(zero, zero, m, n, dp)
	 * */
	public int uniquePaths_2(int m, int n) {
		int[][] dp = new int[m][n];																					// S : O(m * n)
		Arrays.asList(dp).stream().forEach(arr -> Arrays.fill(arr, -1));											// T : O(m * n)
		
		return recursion(0, 0, m, n, dp);
	}
	
	/**
	 * if row is greater than or equal to rows || col is greater than or equal to cols
	 * 		return zero
	 * end if
	 * 
	 * if row is equal to rows minus one && col is equal to cols minus one
	 * 		return one
	 * end if
	 * 
	 * if dp[row][col] is not equal to minus one
	 * 		return dp[row][col]
	 * end if
	 * 
	 * dp[row][col] <- recursion(row plus one, col, rows, cols, dp) plus recursion(row, col plus one, rows, cols, dp)
	 * 
	 * return dp[row][col]
	 * */
	public int recursion(int row, int col, int rows, int cols, int[][] dp) {
		if (row >= rows || col >= cols) { return 0; }
		if (row == rows - 1 && col == cols - 1) { return 1; }
		if (dp[row][col] != -1) { return dp[row][col]; }
		
		dp[row][col] = recursion(row + 1, col, rows, cols, dp) + recursion(row, col + 1, rows, cols, dp);
		
		return dp[row][col];
	}
	
	/**
	 * 1 1 1  1  1  1  1
	 * 1 2 3  4  5  6  7
	 * 1 3 6 10 15 21 28
	 * */
	/**
	 *     1
	 *    1 1
	 *   1 2 1
	 *  1 3 3 1
	 * 1 4 6 4 1
	 * */
	/**
	 * time  : O(m * n)
	 * space : O(m * n)
	 * 
	 * Tabulation
	 * 
	 * 
	 * int[][] dp <- new int[m][n]
	 * 
	 * fill dp with one
	 * 
	 * for int row <- 1; if row is lower than m; row++
	 * 		for int col <- 1; if col is lower than n; col++
	 * 			dp[row][col] <- dp[row minus one][col] plus dp[row][col minus one]
	 * 		end for
	 * end for
	 * 
	 * return dp[m minus one][n minus one]
	 * */
	public int uniquePaths_3(int m, int n) {
		int[][] dp = new int[m][n];																					// S : O(m * n)
		Arrays.asList(dp).stream().forEach(arr -> Arrays.fill(arr, 1));												// T : O(m * n)
		
		for (int row = 1; row < m; row++) {																			// T : O(m - 1)
			for (int col = 1; col < n; col++) {																		// T : O(n - 1)
				dp[row][col] = dp[row - 1][col] + dp[row][col - 1];
			}
		}
		
		return dp[m - 1][n - 1];
	}
	
	/**
	 * time  : O(m * n)
	 * space : O(n)
	 * 
	 * int[] dp <- new int[n]
	 * 
	 * fill dp with one
	 * 
	 * for int row <- 1; if row is lower than m; row++
	 * 		for int col <- 1; if col is lower than n; col++
	 * 			dp[col] <- dp[col] plus dp[col minus one]
	 * 		end for
	 * end for
	 * 
	 * return dp[n minus one]
	 * */
	public int uniquePaths_4(int m, int n) {
		int[] dp = new int[n];																						// S : O(n)
		Arrays.fill(dp, 1);																							// T : O(n)
		
		for (int row = 1; row < m; row++) {																			// T : O(m - 1)
			for (int col = 1; col < n; col++) {																		// T : O(n - 1)
				dp[col] += dp[col - 1];
			}
		}
		
		return dp[n - 1];
	}
	
	/**
	 * we need m - 1 down moves, n - 1 right moves, total m + n - 2 moves
	 *  m + n - 2
	 * C
	 *  m - 1
	 * 
	 *  m + n - 2
	 * C
	 *  n - 1
	 * */
	/**
	 * time  : O(Min(m, n))
	 * space : O(1)
	 * 
	 * Math is the king!
	 * 
	 * 
	 * long result <- 1L
	 * int i <- m minus one plus n minus one
	 * int j <- 1
	 * 
	 * while i is greater than or equal to Math max(m, n)
	 * 		result <- (result times i) divide by j
	 * 		i--
	 * 		j++
	 * end while
	 * 
	 * return result to integer
	 * */
	public int uniquePaths(int m, int n) {
		long result = 1L;
		int i = m - 1 + n - 1;
		int j = 1;
		
		while (i >= Math.max(m, n)) {																				// Min(m, n)
			result = (result * i) / j;
			i--;
			j++;
		}
		
		return (int) result;
	}
	
}
