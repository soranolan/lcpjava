package com.example.lcpjava.array;

public class NumMatrix_1 {
	
	int[][] mat;
	
	/**
	 * time  : O(1)
	 * space : O(1)
	 * */
	public NumMatrix_1(int[][] matrix) {
		mat = matrix;
	}
	
	/**
	 * time  : O(m * n)
	 * space : O(1)
	 * 
	 * Brute Force
	 * */
	public int sumRegion(int row1, int col1, int row2, int col2) {
		int sum = 0;
		
		for (int row = row1; row <= row2; row++) {																	// T : O(m)
			for (int col = col1; col <= col2; col++) {																// T : O(n)
				sum += mat[row][col];
			}
		}
		
		return sum;
	}
	
}
