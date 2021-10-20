package com.example.lcpjava.array;

public class Lcp_498_Diagonal_Traverse {
	
	/**
	 * time  : O(m * n)
	 * space : O(m * n)
	 * 
	 * int row <- 0
	 * int col <- 0
	 * int rows <- array length
	 * int cols <- array[0] length
	 * int[] result <- rows multiply cols
	 * 
	 * for int i <- 0; if i is lower than result length; i++
	 * 		result[i] <- array[row][col]
	 * 		if row plus col mod two is equal to zero
	 * 			if col is equal to cols minus one
	 * 				row++
	 * 			else if row is equal to zero
	 * 				col++
	 * 			else
	 * 				row--
	 * 				col++
	 * 			end if
	 * 		else
	 * 			if row is equal to rows minus one
	 * 				col++
	 * 			else if col is equal to zero
	 * 				row++
	 * 			else
	 * 				row++
	 * 				col--
	 * 			end if
	 * 		end if
	 * end for
	 * */
	public int[] findDiagonalOrder(int[][] mat) {
		int row = 0;
		int col = 0;
		int rows = mat.length;
		int cols = mat[0].length;
		int[] result = new int[rows * cols];																		// S : O(rows * cols)
		
		for (int i = 0; i < result.length; i++) {																	// T : O(rows * cols)
			result[i] = mat[row][col];
			if ((row + col) % 2 == 0) {
				if (col == cols - 1) {
					row++;
				} else if (row == 0) {
					col++;
				} else {
					row--;
					col++;
				}
			} else {
				if (row == rows - 1) {
					col++;
				} else if (col == 0) {
					row++;
				} else {
					row++;
					col--;
				}
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		Lcp_498_Diagonal_Traverse lcp = new Lcp_498_Diagonal_Traverse();
		int[][] input = null;
		int[] output = null;
		
		input = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		output = lcp.findDiagonalOrder(input);
		for (int num : output) { System.out.print(num + " "); }
		System.out.println();
		
		input = new int[][] { { 1, 2 }, { 3, 4 } };
		output = lcp.findDiagonalOrder(input);
		for (int num : output) { System.out.print(num + " "); }
		System.out.println();
	}
	
}
