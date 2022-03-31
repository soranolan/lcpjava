package com.example.lcpjava.array;

public class Lcp_64_Minimum_Path_Sum {
	
	/**
	 * time  : O(2 ^ (m + n))
	 * space : O(m + n)
	 * 
	 * Brute Force
	 * https://leetcode.com/problems/minimum-path-sum/discuss/344980/Java.-Details-from-Recursion-to-DP.
	 * 
	 * 
	 * int rows <- grid length
	 * int cols <- grid[0] length
	 * 
	 * return recursion(rows minus one, cols minus one, grid)
	 * */
	public int minPathSum_1(int[][] grid) {
		int rows = grid.length;																						// m
		int cols = grid[0].length;																					// n
		return recursion(rows - 1, cols - 1, grid);
	}
	
	/**
	 * if row is equal to zero && col is equal to zero
	 * 		return grid[row][col]
	 * end if
	 * 
	 * if row is equal to zero
	 * 		return grid[row][col] plus recursion(row, col minus one, grid)
	 * end if
	 * 
	 * if col is equal to zero
	 * 		return grid[row][col] plus recursion(row minus one, col, grid)
	 * end if
	 * 
	 * return grid[row][col] plus Math min(recursion(row minus one, col, grid), recursion(row, col minus one, grid))
	 * */
	public int recursion(int row, int col, int[][] grid) {
		if (row == 0 && col == 0) { return grid[row][col]; }
		if (row == 0) { return grid[row][col] + recursion(row, col - 1, grid); }
		if (col == 0) { return grid[row][col] + recursion(row - 1, col, grid); }
		return grid[row][col] + Math.min(recursion(row - 1, col, grid), recursion(row, col - 1, grid));
	}
	
	/**
	 * time  : O(m * n)
	 * space : O(m * n)
	 * 
	 * Memoization
	 * 
	 * 
	 * int rows <- grid length
	 * int cols <- grid[0] length
	 * 
	 * int[][] dp <- new int[row plus one][col plus one]
	 * 
	 * return recursion(rows minus one, cols minus one, grid, dp)
	 * */
	public int minPathSum_2(int[][] grid) {
		int rows = grid.length;																						// m
		int cols = grid[0].length;																					// n
		int[][] dp = new int[rows + 1][cols + 1];																	// S : O(m * n)
		return recursion(rows - 1, cols - 1, grid, dp);
	}
	
	/**
	 * if row is equal to zero && col is equal to zero
	 * 		return grid[row][col]
	 * end if
	 * 
	 * if dp[row][col] is not equal to zero
	 * 		return dp[row][col]
	 * end if
	 * 
	 * if row is equal to zero
	 * 		return grid[row][col] plus recursion(row, col minus one, grid, dp)
	 * end if
	 * 
	 * if col is equal to zero
	 * 		return grid[row][col] plus recursion(row minus one, col, grid, dp)
	 * end if
	 * 
	 * dp[row][col] <- grid[row][col] plus Math min(recursion(row minus one, col, grid, dp), recursion(row, col minus one, grid, dp))
	 * 
	 * return dp[row][col]
	 * */
	public int recursion(int row, int col, int[][] grid, int[][] dp) {
		if (row == 0 && col == 0) { return grid[row][col]; }
		if (dp[row][col] != 0) { return dp[row][col]; }
		if (row == 0) { return grid[row][col] + recursion(row, col - 1, grid, dp); }
		if (col == 0) { return grid[row][col] + recursion(row - 1, col, grid, dp); }
		
		dp[row][col] = grid[row][col] + Math.min(recursion(row - 1, col, grid, dp), recursion(row, col - 1, grid, dp));
		
		return dp[row][col];
	}
	
	/**
	 * time  : O(m * n)
	 * space : O(m * n)
	 * 
	 * int rows <- grid length
	 * int cols <- grid[0] length
	 * 
	 * int[][] dp <- new int[row plus one][col plus one]
	 * dp[0][0] <- grid[0][0]
	 * 
	 * for int col <- 1; if col is lower than cols; col++
	 * 		dp[0][col] <- dp[0][col minus one] plus grid[0][col]
	 * end for
	 * 
	 * for int row <- 1; if row is lower than rows; row++
	 * 		dp[row][0] <- dp[row minus one][0] plus grid[row][0]
	 * end for
	 * 
	 * for int row <- 1; if row is lower than rows; row++
	 * 		for int col <- 1; if col is lower than cols; col++
	 * 			dp[row][col] <- grid[row][col] plus Math min(dp[row minus one][col], dp[row][col minus one])
	 * 		end for
	 * end for
	 * 
	 * return dp[rows minue one][cols minus one]
	 * */
	public int minPathSum_3(int[][] grid) {
		int rows = grid.length;																						// m
		int cols = grid[0].length;																					// n
		int[][] dp = new int[rows + 1][cols + 1];																	// S : O(m * n)
		dp[0][0] = grid[0][0];
		
		for (int col = 1; col < cols; col++) { dp[0][col] = dp[0][col - 1] + grid[0][col]; }						// T : O(n - 1)
		
		for (int row = 1; row < rows; row++) { dp[row][0] = dp[row - 1][0] + grid[row][0]; }						// T : O(m - 1)
		
		for (int row = 1; row < rows; row++) {																		// T : O(m)
			for (int col = 1; col < cols; col++) {																	// T : O(n)
				dp[row][col] = grid[row][col] + Math.min(dp[row - 1][col], dp[row][col - 1]);
			}
		}
		
		return dp[rows - 1][cols - 1];
	}
	
	/**
	 * time  : O(m * n)
	 * space : O(1)
	 * 
	 * int rows <- grid length
	 * int cols <- grid[0] length
	 * 
	 * for int col <- 1; if col is lower than cols; col++
	 * 		grid[0][col] <- grid[0][col minus one] plus grid[0][col]
	 * end for
	 * 
	 * for int row <- 1; if row is lower than rows; row++
	 * 		grid[row][0] <- grid[row minus one][0] plus grid[row][0]
	 * end for
	 * 
	 * for int row <- 1; if row is lower than rows; row++
	 * 		for int col <- 1; if col is lower than cols; col++
	 * 			grid[row][col] <- grid[row][col] plus Math min(grid[row minus one][col], grid[row][col minus one])
	 * 		end for
	 * end for
	 * 
	 * return grid[rows minue one][cols minus one]
	 * */
	public int minPathSum(int[][] grid) {
		int rows = grid.length;																						// m
		int cols = grid[0].length;																					// n
		
		for (int col = 1; col < cols; col++) { grid[0][col] += grid[0][col - 1]; }									// T : O(n - 1)
		
		for (int row = 1; row < rows; row++) { grid[row][0] += grid[row - 1][0]; }									// T : O(m - 1)
		
		for (int row = 1; row < rows; row++) {																		// T : O(m)
			for (int col = 1; col < cols; col++) {																	// T : O(n)
				grid[row][col] += Math.min(grid[row - 1][col], grid[row][col - 1]);
			}
		}
		
		return grid[rows - 1][cols - 1];
	}
	
}
