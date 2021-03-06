package com.example.lcpjava.array;

import java.util.ArrayList;
import java.util.List;

public class Lcp_54_Spiral_Matrix {
	
	/**
	 * time  : O(m * n)
	 * space : O(m * n)
	 * 
	 * int m <- array length
	 * int n <- array[0] length
	 * 
	 * int row <- 0
	 * int col <- 0
	 * 
	 * int rows <- m
	 * int cols <- n
	 * 
	 * List<Integer> result <- empty ArrayList
	 * 
	 * while result size is lower than m times n
	 * 		for int i <- col; if i is lower than cols; i++
	 * 			result add array[row][i]
	 * 		end for
	 * 		
	 * 		if result size is greater than or equal to m times n
	 * 			break
	 * 		end if
	 * 		
	 * 		for int i <- row plus one; if i is lower than rows minus one; i++
	 * 			result add array[i][cols - 1]
	 * 		end for
	 * 		
	 * 		if result size is greater than or equal to m times n
	 * 			break
	 * 		end if
	 * 		
	 * 		for int i <- cols minus one; if i is greater than or equal to col; i--
	 * 			result add array[rows minus one][i]
	 * 		end for
	 * 		
	 * 		if result size is greater than or equal to m times n
	 * 			break
	 * 		end if
	 * 		
	 * 		for int i <- rows minus two; if i is greater than row; i--
	 * 			result add array[i][col]
	 * 		end for
	 * 		
	 * 		if result size is greater than or equal to m times n
	 * 			break
	 * 		end if
	 * 		
	 * 		col++
	 * 		row++
	 * 		cols--
	 * 		rows--
	 * end while
	 * 
	 * return result
	 * */
	public List<Integer> spiralOrder(int[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;
		
		int row = 0;
		int col = 0;
		
		int rows = m;
		int cols = n;
		
		List<Integer> result = new ArrayList<>();																	// S : O(m * n)
		
		while (result.size() < m * n) {																				// T : O(m * n)
			// →
			for (int i = col; i < cols; i++) { result.add(matrix[row][i]); }										// T : O(n)
			if (result.size() >= m * n) { break; }
			
			// ↓
			for (int i = row + 1; i < rows - 1; i++) { result.add(matrix[i][cols - 1]); }							// T : O(m)
			if (result.size() >= m * n) { break; }
			
			// ←
			for (int i = cols - 1; i >= col; i--) { result.add(matrix[rows - 1][i]); }								// T : O(n)
			if (result.size() >= m * n) { break; }
			
			// ↑
			for (int i = rows - 2; i > row; i--) { result.add(matrix[i][col]); }									// T : O(m)
			if (result.size() >= m * n) { break; }
			
			col++;
			row++;
			cols--;
			rows--;
		}
		
		return result;
	}
	
}
