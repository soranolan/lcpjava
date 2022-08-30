package com.example.lcpjava.array;

public class Lcp_48_Rotate_Image {
	
	/**
	 * 1 2 3				7 8 9			7 4 1
	 * 4 5 6	reverse		4 5 6	swap	8 5 2
	 * 7 8 9				1 2 3			9 6 3
	 * */
	/**
	 * time  : O(n ^ 2)
	 * space : O(1)
	 * 
	 * reverse and swap
	 * */
	public void rotate_1(int[][] matrix) {
		reverse(matrix);
		swap(matrix);
	}
	
	private void reverse(int[][] matrix) {
		int length = matrix.length;
		int top = 0;
		int down = length - 1;
		
		while (top < down) {																						// T : O(n)
			int[] temp = matrix[top];
			matrix[top] = matrix[down];
			matrix[down] = temp;
			
			top++;
			down--;
		}
	}
	
	private void swap(int[][] matrix) {
		int length = matrix.length;																					// n
		
		for (int row = 0; row < length; row++) {																	// T : O(n)
			for (int col = row + 1; col < length; col++) {															// T : O(n)
				int temp = matrix[row][col];
				matrix[row][col] = matrix[col][row];
				matrix[col][row] = temp;
			}
		}
	}
	
	/**
	 * time  : O(n ^ 2)
	 * space : O(1)
	 * */
	public void rotate(int[][] matrix) {
		int length = matrix.length;
		int index = length - 1;
		int rows = (length + 1) / 2;
		int cols = length / 2;
		
		for (int row = 0; row < rows; row++) {																		// T : O(n)
			for (int col = 0; col < cols; col++) {																	// T : O(n)
				int temp = matrix[index - col][row];
				matrix[index - col][row] = matrix[index - row][index - col];
				matrix[index - row][index - col] = matrix[col][index - row];
				matrix[col][index - row] = matrix[row][col];
				matrix[row][col] = temp;
			}
		}
	}
	
}
