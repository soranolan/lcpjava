package com.example.lcpjava.array;

public class NumMatrix_3 {
	
	int[][] dp;
	
	/**
	 * time  : O(m * n)
	 * space : O(m * n)
	 * */
	public NumMatrix_3(int[][] matrix) {
		int rows = matrix.length;
		int cols = matrix[0].length;
		
		dp = new int[rows][cols + 1];																				// S : O(m * n)
		
		for (int row = 0; row < rows; row++) {																		// T : O(m)
			for (int col = 0; col < cols; col++) {																	// T : O(n)
				dp[row][col + 1] = matrix[row][col] + dp[row][col];
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
			sum += dp[row][col2 + 1] - dp[row][col1];
		}
		
		return sum;
	}
	
}
