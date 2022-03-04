package com.example.lcpjava.array;

public class NumMatrix_2 {
	
	int[][] dp;
	
	/**
	 * time  : O(m * n)
	 * space : O(m * n)
	 * */
	public NumMatrix_2(int[][] matrix) {
		int rows = matrix.length;
		int cols = matrix[0].length;
		
		dp = new int[rows][cols];																					// S : O(m * n)
		
		for (int row = 0; row < rows; row++) {																		// T : O(m)
			dp[row][0] = matrix[row][0];
		}
		
		for (int row = 0; row < rows; row++) {																		// T : O(m)
			for (int col = 1; col < cols; col++) {																	// T : O(n)
				dp[row][col] = matrix[row][col] + dp[row][col - 1];
			}
		}
	}
	
	/**
	 * time  : O(m)
	 * space : O(1)
	 * 
	 * Prefix Sum
	 * */
	public int sumRegion(int row1, int col1, int row2, int col2) {
		int sum = 0;
		
		for (int row = row1; row <= row2; row++) {																	// T : O(m)
			sum += dp[row][col2] - (col1 == 0 ? 0 : dp[row][col1 - 1]);
		}
		
		return sum;
	}
	
}
