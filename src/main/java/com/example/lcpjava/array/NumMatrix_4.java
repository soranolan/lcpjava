package com.example.lcpjava.array;

public class NumMatrix_4 {
	
	int[][] dp;
	
	/**
	 * time  : O(m * n)
	 * space : O(m * n)
	 * 
	 * https://leetcode.com/problems/range-sum-query-2d-immutable/discuss/1204223/Short-and-Simple-Solutions-w-Explanation-and-Diagram-or-1-D-Prefix-Sum-and-Submatrix-Sum-Approach
	 * */
	public NumMatrix_4(int[][] matrix) {
		int rows = matrix.length;
		int cols = matrix[0].length;
		
		dp = new int[rows + 1][cols + 1];																			// S : O(m * n)
		
		for (int row = 1; row <= rows; row++) {																		// T : O(m)
			for (int col = 1; col <= cols; col++) {																	// T : O(n)
				// downRight = downRight + topLeft + top + left - topLeft
				dp[row][col] = dp[row][col] +  matrix[row - 1][col - 1] + dp[row - 1][col] + dp[row][col - 1] - dp[row - 1][col - 1];
			}
		}
	}
	
	/**
	 * time  : O(1)
	 * space : O(1)
	 * */
	public int sumRegion(int row1, int col1, int row2, int col2) {
		// downRight - top - left + topLeft
		return dp[row2 + 1][col2 + 1] - dp[row1][col2 + 1] - dp[row2 + 1][col1] + dp[row1][col1];
	}
	
}
