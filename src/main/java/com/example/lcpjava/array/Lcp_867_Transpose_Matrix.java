package com.example.lcpjava.array;

public class Lcp_867_Transpose_Matrix {
	
	/**
	 * time  : O(n * m)
	 * space : O(n * m)
	 * */
	public int[][] transpose_1(int[][] matrix) {
		int rows = matrix.length;																					// m
		int cols = matrix[0].length;																				// n
		int[][] result = new int[cols][rows];																		// S : O(n * m)
		int col = 0;
		
		for (int[] mat : matrix) {																					// T : O(m)
			for (int row = 0; row < mat.length; row++) {															// T : O(n)
				result[row][col] = mat[row];
			}
			col++;
		}
		
		return result;
	}
	
	/**
	 * time  : O(n * m)
	 * space : O(n * m)
	 * */
	public int[][] transpose(int[][] matrix) {
		int rows = matrix.length;																					// m
		int cols = matrix[0].length;																				// n
		int[][] result = new int[cols][rows];																		// S : O(n * m)
		
		for (int row = 0; row < rows; row++) {																		// T : O(m)
			for (int col = 0; col < cols; col++) {																	// T : O(n)
				result[col][row] = matrix[row][col];
			}
		}
		
		return result;
	}
	
}
